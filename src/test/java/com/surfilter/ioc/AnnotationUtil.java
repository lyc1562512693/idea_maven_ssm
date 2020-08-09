package com.surfilter.ioc;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class AnnotationUtil {

    public static List<Class> getAllClazzByPackageName(String packageName){
       List<Class> clazzs = new ArrayList<>();
       try {
           //根据包路径获取实际文件路径
           String newPackageName = packageName.replace('.', '/');
           URL url = Thread.currentThread().getContextClassLoader().getResource(newPackageName);
           String protocol = url.getProtocol();
           if ("file".equals(protocol)) {
               String filePath = URLDecoder.decode(url.getFile(), "utf-8");
               findClassByFile(packageName, filePath, clazzs);
           }
       }catch(UnsupportedEncodingException e){
           e.printStackTrace();
       }
       return clazzs;
    }

    /**
     * 根据文件路径获取指定包路径下的文件
     * @param packageName
     * @param filePath
     * @param clazzs
     */
    public static void findClassByFile(String packageName, String filePath, List<Class> clazzs){
        File file = new File(filePath);
        //递归的退出条件
        if(!file.exists() || !file.isDirectory()){
            return;
        }
        //可以使用过滤器过滤文件
        File[] files = file.listFiles();
        //递归添加文件
        for(File sonFile: files){
            if(!sonFile.isDirectory()){//不是文件夹则直接添加
                //去掉.class后缀
                String className = sonFile.getName().substring(0, sonFile.getName().length() - 6);
                try {
                    clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
                }catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            }else{
                findClassByFile(packageName + "." + sonFile.getName(), sonFile.getAbsolutePath(),clazzs);
            }
        }
    }
}
