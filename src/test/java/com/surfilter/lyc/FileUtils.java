package com.surfilter.lyc;

import sun.java2d.SurfaceDataProxy;

import java.io.*;
import java.rmi.server.ExportException;
import java.util.Date;

/**
 * 此为文件操作工具类，例如文件输入输出，文件夹下获取指定格式文件等
 */
public class FileUtils {
    public static void main(String[] args) {
        try {
            crawlerFileByFileType("G:\\pic\\upuppo\\UpupooResource", "E:\\target", new String[]{".jpg",".png",".JPG",".PNG"});
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 根据文件类型爬取指定文件夹到目标文件夹
     * @param sourcePath
     * @param targetPath
     * @param fileType
     */
    public static void crawlerFileByFileType(String sourcePath, String targetPath, String[] fileType) throws IOException {
        File file = new File(sourcePath);
        if(file.exists() &&     file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                crawlerFileByFileType(f.getAbsolutePath(),targetPath,fileType);
            }

        }else if(file.exists() && file.isFile()){
            String theFileType = "";
            for(String type : fileType){
                if(file.getName().endsWith(type)){
                    theFileType = type;
                    break;
                }
            }
            if(!"".equals(theFileType)) {
                System.out.println("文件目标路径为：" + file.getAbsolutePath());
                FileInputStream in = new FileInputStream(file);
                String tPath = targetPath+ "/" + new Date().getTime() + Math.random() + "_" + file.getName();
                FileOutputStream out = new FileOutputStream(new File(tPath));
                System.out.println("开始写文件到目标路径：" + tPath);
                byte[] buff = new byte[1024];
                int len = 0;
                while ((len = in.read(buff)) != -1) {
                    out.write(buff);
                }
                System.out.println(tPath +"------文件迁移完成。");
            }
        }
    }

    /**
     * 根据文件名称迁移指定文件下的文件到目标文件夹
     * @param sourcePath
     * @param targetPath
     * @param fileNames
     * @throws IOException
     */
    public static void crawlerFileByFileName(String sourcePath, String targetPath, String[] fileNames) throws IOException {
        File file = new File(sourcePath);
        if(file.exists() && file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                crawlerFileByFileName(f.getAbsolutePath(),targetPath,fileNames);
            }

        }else if(file.exists() && file.isFile()){
            String theFileName = "";
            for(String name : fileNames){
                if(file.getName().contains(name)){
                    theFileName = name;
                    break;
                }
            }
            if(!"".equals(theFileName)) {
                System.out.println("文件目标路径为：" + file.getAbsolutePath());
                FileInputStream in = new FileInputStream(file);
                String tPath = targetPath+ "/" + new Date().getTime() + Math.random() + "_" + file.getName();
                FileOutputStream out = new FileOutputStream(new File(tPath));
                System.out.println("开始写文件到目标路径：" + tPath);
                byte[] buff = new byte[1024];
                int len = 0;
                while ((len = in.read(buff)) != -1) {
                    out.write(buff);
                }
                System.out.println(tPath +"------文件迁移完成。");
            }
        }
    }
}
