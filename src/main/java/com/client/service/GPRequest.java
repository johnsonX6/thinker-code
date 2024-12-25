package com.client.service;

import com.netflix.discovery.util.StringUtil;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author qzhen
 * 处理http报文字符串
 */
public class GPRequest {

    private String method;
    private String url;

    public GPRequest(InputStream in) {

        String content = "";
        byte[] buff = new byte[1024];
        int len = 0;
        try {
            if ((len = in.read(buff)) != -1) {
                content = new String(buff, 0, len);
            }
            if(StringUtils.isEmpty(content)){
                return;
            }
            System.out.println("post-method-content:" + content);
            String line = content.split("\\n")[0]; //读取字符串
            String[] arr = line.split("\\s"); //按空格分离
            String params = arr.length > 2 ?
                    arr[1].split("\\?")[1]:"";
            System.out.println("get-method-param:" + params);
            this.method = arr[0];
            this.url = arr[1].split("\\?")[0];
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
