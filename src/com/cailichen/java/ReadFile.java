package com.cailichen.java;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author cailichen
 * @create 2020-11-19 15:38
 */
public class ReadFile {
    public static void main(String[] args) {
        try {
            ///两种读写文件的方式
            //第一种：采用nio.file.Files类
            Path path = Paths.get("F:\\test.txt");//获取文件路径
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);//通过文件路径读取文件
            //StandardCharsets.UTF_8为jdk8提供的字符编码静态常量
            String content = "Hello World!";
            Files.write(path, content.getBytes());
            //Files.write(path,lines, StandardOpenOption.APPEND);
            /**
             * StandardOpenOption是一个枚举类，代表文件连接时的标准选项
             * APPEND表示如果文件存在并且以WRITE的方式连接时就会把文件内容清空，文件设置为0字节大小
             * 如果文件只以READ连接时，该选项会被忽略
             * https://blog.csdn.net/qq_40837310/article/details/106267399
             * */
            //第二种：
            //采用BufferedWriter进行写文件操作
            BufferedWriter bfw = Files.newBufferedWriter(path);
            bfw.write("Files类的API：newBufferedWriter");
            bfw.flush();//清空缓存用于提升性能
            bfw.close();
            //采用BufferedReader进行读文件操作
            BufferedReader bfd = Files.newBufferedReader(path);
            System.out.println(bfd.readLine());
            bfw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
