package com.surfilter.lyc;

import org.omg.CORBA.portable.InputStream;

import java.io.*;

public class StringTest {
    public static void main(String[] args) {
        System.out.println("中文编码测试");
    }

    public void streamTest(){
        BufferedReader read = null;
        BufferedWriter writer = null;
        try {
            read = new BufferedReader(new InputStreamReader(new FileInputStream("")));
            new BufferedWriter(new OutputStreamWriter(new FileOutputStream("")));
            String line = "";
            while((line = read.readLine()) != null){
                writer.write(line);
                writer.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void java8StreamTest() throws IOException{
        try(
                BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("")));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("")));
                ){
            String line = "";
            while((line = read.readLine()) != null){
                writer.write(line);
                writer.flush();
            }
        }
    }
}
