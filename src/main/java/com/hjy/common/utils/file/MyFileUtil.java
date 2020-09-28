package com.hjy.common.utils.file;

import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public  class MyFileUtil {
    //文件夹路径
//    private static final String LED_FILE_DIR = "d:\\ywjg";
    private static final String LED_FILE_DIR = "C:\\Users\\Administrator\\Desktop\\led";
    //文件名
//    private static final String LED_FILE_NAME = "ywjg.txt";
    private static final String LED_FILE_NAME = "叫号.txt";
    //led大屏文件目录+文件名
//    private static final String LED_FILE = "d:\\ywjg\\ywjg.txt";
    private static final String LED_FILE = "C:\\Users\\Administrator\\Desktop\\led\\叫号.txt";

    //判断是否为图片文件
    public static boolean PictureFileUtil(MultipartFile file){
        if(file !=null){
            //文件全名
            String fileName = file.getOriginalFilename();
            //文件名后缀，即文件类型
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            if(suffixName.equals(".jpg")){
                return true;
            }else {
               return false;
            }
        }
        return false;
    }
    //黑红名单添加时，文件保存逻辑处理
    public static String[] FileUtil(String fenlei, MultipartFile[] files, String IDcard){
        StringBuffer dbfilePathsb = new StringBuffer();
        StringBuffer dbfilePathsb2 = new StringBuffer();
        String[]strings = new String[2];
        if(files!=null && files.length>0){
            for(int i = 0,j = 0,k = 0;i < files.length; i++){
                MultipartFile file = files[i];
                if(!file.isEmpty()){
                    //获取时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
                    String time = sdf.format(date.getTime());
                    String times[] = time.split("_");
                    //拿到的该文件名
                    String fileName = file.getOriginalFilename();
                    //判断是否为图片文件
                    if(PictureFileUtil(file)){
                        j++;
                        //重命名文件名
                        if(j>0){
                            fileName = times[0] + "_" + times[1] + "_" + times[2] + "_"+IDcard+"_"+j+".jpg";
                            if(j==1){
                                dbfilePathsb.append(fileName);
                            }else {
                                dbfilePathsb.append("-"+fileName);
                            }
                        }
                    }else {
                        //文件名后缀，即文件类型
                        String suffixName = file.getOriginalFilename().substring(fileName.lastIndexOf("."));
                        k++;
                        //重命名文件名
                        if(k>0){
                            fileName = times[0] + "_" + times[1] + "_" + times[2] + "_"+IDcard+"_"+k+suffixName;
                            if(k==1){
                                dbfilePathsb2.append(fileName);
                            }else {
                                dbfilePathsb2.append("-"+fileName);
                            }
                        }
                    }
                    //调用文件上传工具类
                    String filePath = FileUpload(fenlei,fileName,file);
                    if(i==0){
                        dbfilePathsb.insert(0,filePath+"applyBook_");
                    }else if(i==1){
                        dbfilePathsb2.insert(0,filePath+"codeCertificates_");
                    }

                }
            }
        }
        //为文件1路径及其名称
        strings[0] =dbfilePathsb.toString();
        //为文件2路径及其名称
        strings[1] =dbfilePathsb2.toString();
        return strings;
    }
    //黑红名单添加时，文件保存工具
    public static String FileUpload(String fenlei, String fileName, MultipartFile file){
        //获取时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
        String time = sdf.format(date.getTime());
        String times[] = time.split("_");
        //1.创建目录
        StringBuffer dirpath = new StringBuffer(times[0] + "/" + times[1] + "/" + times[2]);
        String filePath = null;
        if(fenlei.equals("红名单")){
            dirpath.insert(0,"D:/aTest/ywjg/redList/");
            filePath = "D:/aTest/ywjg/redList/";
        }else if(fenlei.equals("黑名单")){
            dirpath.insert(0,"D:/aTest/ywjg/blackList/");
            filePath = "D:/aTest/ywjg/blackList/";
        }
        File targetFile = new File(dirpath.toString());
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        File saveFile = new File(targetFile, fileName);
        try {
            file.transferTo(saveFile);
        } catch (Exception e) {
        }
        return filePath;
    }

    //大厅LED屏文件取号追加写入
    public static void serviceTakeNumberInputFile(String ordinal){
        StringBuffer fileBuf=new StringBuffer();
        //若此目录不存在，则创建之
        File myPath = new File(LED_FILE_DIR);
        if ( !myPath.exists()){
            myPath.mkdir();
        }
        try {
            // FileWriter如果该文件名的文件不存在，先创建再读写;存在的话直接追加写,关键字true表示追加
            FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,true);
            fw.write(ordinal+" 排队中"+"\n");
            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //LED大屏顺序叫号写入
    public static void serviceCallNumberReader(String ordinal,String windowName) {
        File file = new File(LED_FILE);
        List<String> resultList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = bufferedReader.readLine())!=null){
                if(s.substring(0,5).equals(ordinal)){
                    resultList.add(ordinal+"号到"+windowName);
                }else {
                    resultList.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //开始写入文件，先清空
        int i = 0;
        try {
            if(i==0){
                FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,false);
                fw.write("");
                i++;
            }
            // FileWriter如果该文件名的文件不存在，先创建再读写;存在的话直接追加写,关键字true表示追加
            FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,true);
            for(String s:resultList){
                fw.write(s+"\n");
            }
            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //LED大屏办结删除排队信息
    public static void serviceDownNumberInputFile(String ordinal) {
        File file = new File(LED_FILE);
        List<String> resultList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = bufferedReader.readLine())!=null){
                if(!s.substring(0,5).equals(ordinal)){
                    resultList.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //开始写入文件，先清空
        int i = 0;
        try {
            if(i==0){
                FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,false);
                fw.write("");
                i++;
            }
            // FileWriter如果该文件名的文件不存在，先创建再读写;存在的话直接追加写,关键字true表示追加
            FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,true);
            for(String s:resultList){
                fw.write(s+"\n");
            }
            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //特呼写入
    public static void servicevipcallNumberInputFile(String ordinal,String windowName) {
        File file = new File(LED_FILE);
        List<String> resultList = new ArrayList<>();
        //先在首行添加特呼的号码信息
        resultList.add(ordinal+"号到"+windowName+"-特呼");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = bufferedReader.readLine())!=null){
                    resultList.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //开始写入文件，先清空
        int i = 0;
        try {
            if(i==0){
                FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,false);
                fw.write("");
                i++;
            }
            // FileWriter如果该文件名的文件不存在，先创建再读写;存在的话直接追加写,关键字true表示追加
            FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,true);
            for(String s:resultList){
                fw.write(s+"\n");
            }
            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //led大屏文件写入总的工具
    public static void LedFileInput(String ordinal,String windowName,boolean getNum,boolean callNum,boolean downOrNullOrBackNum,boolean vipNum) {
        StringBuffer fileBuf=new StringBuffer();
        //若此目录不存在，则创建之
        File myPath = new File(LED_FILE_DIR);
        if ( !myPath.exists()){
            myPath.mkdir();
        }
        List<String> resultList = new ArrayList<>();
        try {
            // FileWriter如果该文件名的文件不存在，先创建再读写;存在的话直接追加写,关键字true表示追加
            FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,true);
            //取号 getNum=true
            if(getNum){
                fw.write(ordinal+" 排队中"+"\n");
                return;
            }
            if(callNum){

            }

            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        File file = new File(LED_FILE);
        //先在首行添加特呼的号码信息
        resultList.add(ordinal+"号到"+windowName+"办理业务-特呼");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = bufferedReader.readLine())!=null){
                    resultList.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //开始写入文件，先清空
        int i = 0;
        try {
            if(i==0){
                FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,false);
                fw.write("");
                i++;
            }
            // FileWriter如果该文件名的文件不存在，先创建再读写;存在的话直接追加写,关键字true表示追加
            FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,true);
            for(String s:resultList){
                fw.write(s+"\n");
            }
            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
