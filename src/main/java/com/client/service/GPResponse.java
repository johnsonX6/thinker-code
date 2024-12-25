package com.client.service;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author qzhen
 * 处理http响应类
 */
public class GPResponse {

    private OutputStream out;

    public GPResponse(OutputStream out) {
        this.out = out;
    }

    public void write(String s) {
        //状态码为200
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n").append("Content-Type:text/html\n").append("\r\n")
                .append(s);
        try {
            out.write(sb.toString().getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
