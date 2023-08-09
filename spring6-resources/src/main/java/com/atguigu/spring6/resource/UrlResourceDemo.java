package com.atguigu.spring6.resource;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

public class UrlResourceDemo {

    public static void main(String[] args) {
        //http
//        loadUrlResource("http://www.baidu.com");

        //file前缀
        loadUrlResource("file:atguigu.txt");
    }

    public static void loadUrlResource(String path){
        try {
            UrlResource url = new UrlResource(path);
            System.out.println(url.getFilename());
            System.out.println(url.getURI());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().read());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
