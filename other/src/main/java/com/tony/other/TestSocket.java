/*
*       Copyright© (2020).
*/
package com.tony.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @author tony
* @create 2021-09-09
* @description:
*/
public class TestSocket {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(8080);
        while (true){
            //阻塞等待连接
            Socket client = server.accept();
            //fork出一个线程调系统的recvfrom去读IO
            new Thread(() -> {
                try {
                    //读数据
                    InputStream in = client.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    while (true){
                        System.out.println(reader.readLine());
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
