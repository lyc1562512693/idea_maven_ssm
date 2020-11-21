package file.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileUtils {

    private static List<File> files = new ArrayList<>();

    public static void main(String[] args) {
       /* try {
            crawlerFileByFileType("G:\\pic\\upuppo\\UpupooResource", "E:\\target", new String[]{".jpg",".png",".JPG",".PNG"});
        }catch (Exception e){
            e.printStackTrace();
        }*/
        findAllFilesInDir("E:\\test");
        System.out.println(files.size());
    }

    public static void findAllFilesInDir(String path){
        File file = new File(path);
        if(file.exists() && file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files){
                findAllFilesInDir(f.getAbsolutePath());
            }
        }else if(file.exists() && file.isFile()){
            files.add(file);
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
        if(file.exists() && file.isDirectory()){
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
    public static void readFile(String path){
        //方式一
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(path));
            System.out.println(bf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String readFileResources(String path){
        String content = "";
        try (BufferedReader bf2 = Files.newBufferedReader(Paths.get(path))) {
            String str = "";
            while ((str = bf2.readLine()) != null){
                content += str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
