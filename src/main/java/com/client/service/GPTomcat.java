package com.client.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.client.service.servlet.GPServlet;

/**
 * tomcat处理输入输出
 */
public class GPTomcat {

    private static final Integer port = 8089;

    private ServerSocket server;

    private static final Map<String, GPServlet> servletMap = new HashMap<String, GPServlet>();

    private static final Properties props = new Properties();

    public static final ExecutorService executors = Executors.newFixedThreadPool(2000);

    public static final Integer MAX_CONNECTIONS = 2000;

    public void init() {
        String WEB_INF = this.getClass().getResource("/").getPath();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(WEB_INF + "web.properties");
            props.load(fis);
            for (Object key : props.keySet()) {
                String keyStr = key.toString();
                if (keyStr.endsWith(".url")) {
                    String servletName = keyStr.replaceAll("\\.url$", "");
                    String url = props.getProperty(keyStr);
                    String className = props.getProperty(servletName + ".className");
                    //实例化servlet逻辑
                    GPServlet obj = (GPServlet) Class.forName(className).newInstance();
                    System.out.println("url:" + url);
                    servletMap.put(url, obj);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void start() {
        //先初始化
        init();
        try {
            server = new ServerSocket(port);
            System.out.println("Tomcat 已启动，监听的端口是:" + port);
            for (int i = 0; i < MAX_CONNECTIONS; i++) {
                executors.submit(() -> {
                    while (true) {
                        Socket socket = server.accept();
                        process(socket);
                        System.out.println("server-thread-" + Thread.currentThread().getName());
                    }
                });
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void process(Socket socket) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            //实例化GPRequest，GPResponse
            GPRequest request = new GPRequest(is);
            GPResponse response = new GPResponse(os);
            String url = request.getUrl();
            if (servletMap.containsKey(url)) {
                GPServlet servlet = servletMap.get(url);
                servlet.service(request, response);
            } else {
                response.write("404 - NotFound");
            }
        } catch (Exception e) {
            System.out.println("process err:" + e.getMessage());
        } finally {
            if (os != null) {
                try {
                    os.flush();
                    os.close();
                    is.close();
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }

    }

    public static void main(String[] args) {

        new GPTomcat().start();
    }
}
/**
 * 多线程启动服务报告：
 * 机器配置：4C16G MAC系统
 * 初始化1000线程 ｜ 连接成功数：887
 * 初始化1000线程 ｜ 连接成功数：882
 *
 *
 */
