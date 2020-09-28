package com.hjy.common.utils.file;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    //文件夹路径
    private static final String LED_FILE_DIR = "d:\\hjy\\ywjg";
    //文件名
    private static final String LED_FILE_NAME = "ywjg.txt";
    //led大屏文件目录+文件名
    private static final String LED_FILE = "d:\\hjy\\ywjg\\ywjg.txt";
    //本地makeCardfile
    private static final String MAKE_CARD_FILE = "d:\\hjy\\ywjg\\makeCard.txt";
    private static final String MAKE_CARD_FILE_NAME = "makeCard.txt";

    //大厅LED屏文件取号追加写入
    public static void serviceTakeNumberInputFile(String ordinal){
        FileOutputStream out = null;
        //若此目录不存在，则创建之
        File myPath = new File(LED_FILE_DIR);
        if ( !myPath.exists()){
            myPath.mkdir();
        }
        try {
            //以追加的方式写入文件, 如果覆盖文件则这样写: out = new FileOutputStream(pathFileName), 这样就每次都会重写文件
            out = new FileOutputStream(LED_FILE, true);
            StringBuffer bf = new StringBuffer();
            bf.append(ordinal+" 排队中"+"\n");
            String msg2 = null;
            byte[] bytes = new byte[20480];//20k,根据硬盘缓存大小调节,这个对性能很重要,可以根据服务器硬盘缓冲大小定制,以达到最佳写入速度.一般为硬盘缓存的1/4
            byte[] inbytes = null;
            inbytes = bf.toString().getBytes("utf-8");
            //临时用字节输入流
            ByteArrayInputStream in = new ByteArrayInputStream(inbytes);
            int c;
            while ((c = in.read(bytes)) != -1) {
                out.write(bytes, 0, c);
            }
            in.close();
            //结束时清空变量,养成习惯.
            bytes =null;
            inbytes =null;
            bf = null;
        }catch (Exception e) {
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                out = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //LED大屏顺序叫号写入
    public static void serviceCallNumberReader(String ordinal, String windowName) {
        //读取文件
        List<String> resultList = new ArrayList<>();
        FileInputStream in = null;
        try {
            in = new FileInputStream(LED_FILE);
            //以指定的编码读取文件
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String s = null;
            while ((s = bufReader.readLine())!=null){
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
        try {
            FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,false);
            fw.write("");
            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream out = null;
        //若此目录不存在，则创建之
        try {
            //以追加的方式写入文件, 如果覆盖文件则这样写: out = new FileOutputStream(pathFileName), 这样就每次都会重写文件
            out = new FileOutputStream(LED_FILE, true);
            StringBuffer bf = new StringBuffer();
            for(String s :resultList){
                bf.append(s);
            }
            String msg2 = null;
            byte[] bytes = new byte[20480];//20k,根据硬盘缓存大小调节,这个对性能很重要,可以根据服务器硬盘缓冲大小定制,以达到最佳写入速度.一般为硬盘缓存的1/4
            byte[] inbytes = null;
            inbytes = bf.toString().getBytes("utf-8");
            //临时用字节输入流
            ByteArrayInputStream inputStream = new ByteArrayInputStream(inbytes);
            int c;
            while ((c = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, c);
            }
            inputStream.close();
            //结束时清空变量,养成习惯.
            bytes =null;
            inbytes =null;
            bf = null;
        }catch (Exception e) {
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                out = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //LED大屏办结删除排队信息
    public static void serviceDownNumberInputFile(String ordinal) {
        //读取文件
        List<String> resultList = new ArrayList<>();
        FileInputStream in = null;
        try {
            in = new FileInputStream(LED_FILE);
            //以指定的编码读取文件
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String s = null;
            while ((s = bufReader.readLine())!=null){
                if(!s.substring(0,5).equals(ordinal)){
                    resultList.add(s);
                }else {
                    resultList.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //开始写入文件，先清空
        try {
            FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,false);
            fw.write("");
            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //开始写入文件
        FileOutputStream out = null;
        try {
            //以追加的方式写入文件, 如果覆盖文件则这样写: out = new FileOutputStream(pathFileName), 这样就每次都会重写文件
            out = new FileOutputStream(LED_FILE, true);
            StringBuffer bf = new StringBuffer();
            for(String s :resultList){
                bf.append(s);
            }
            String msg2 = null;
            byte[] bytes = new byte[20480];//20k,根据硬盘缓存大小调节,这个对性能很重要,可以根据服务器硬盘缓冲大小定制,以达到最佳写入速度.一般为硬盘缓存的1/4
            byte[] inbytes = null;
            inbytes = bf.toString().getBytes("utf-8");
            //临时用字节输入流
            ByteArrayInputStream inputStream = new ByteArrayInputStream(inbytes);
            int c;
            while ((c = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, c);
            }
            inputStream.close();
            //结束时清空变量,养成习惯.
            bytes =null;
            inbytes =null;
            bf = null;
        }catch (Exception e){

        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                out = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //特呼写入
    public static void servicevipcallNumberInputFile(String ordinal, String windowName) {
        List<String> resultList = new ArrayList<>();
        //先在首行添加特呼的号码信息
        resultList.add(ordinal+"号到"+windowName+"-特呼");
        //再读取文件
        FileInputStream in = null;
        try {
            in = new FileInputStream(LED_FILE);
            //以指定的编码读取文件
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String s = null;
            while ((s = bufReader.readLine())!=null){
                 resultList.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //开始写入文件，先清空
        try {
            FileWriter fw = new FileWriter(LED_FILE_DIR + "\\" + LED_FILE_NAME,false);
            fw.write("");
            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //开始写入文件
        FileOutputStream out = null;
        try {
            //以追加的方式写入文件, 如果覆盖文件则这样写: out = new FileOutputStream(pathFileName), 这样就每次都会重写文件
            out = new FileOutputStream(LED_FILE, true);
            StringBuffer bf = new StringBuffer();
            for(String s :resultList){
                bf.append(s);
            }
            String msg2 = null;
            byte[] bytes = new byte[20480];//20k,根据硬盘缓存大小调节,这个对性能很重要,可以根据服务器硬盘缓冲大小定制,以达到最佳写入速度.一般为硬盘缓存的1/4
            byte[] inbytes = null;
            inbytes = bf.toString().getBytes("utf-8");
            //临时用字节输入流
            ByteArrayInputStream inputStream = new ByteArrayInputStream(inbytes);
            int c;
            while ((c = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, c);
            }
            inputStream.close();
            //结束时清空变量,养成习惯.
            bytes =null;
            inbytes =null;
            bf = null;
        }catch (Exception e){

        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                out = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
