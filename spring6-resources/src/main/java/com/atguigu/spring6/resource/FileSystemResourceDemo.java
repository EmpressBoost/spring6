package com.atguigu.spring6.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

public class FileSystemResourceDemo {

    public static void loadFileResource(String path){
        FileSystemResource resource = new FileSystemResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        try {
            InputStream in = resource.getInputStream();
            byte[] b = new byte[1024];
            while (in.read(b) != -1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        loadFileResource("d:\\atguigu.txt");
        loadFileResource("atguigu.txt");
    }
}
