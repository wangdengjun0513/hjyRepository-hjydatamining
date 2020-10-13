package com.hjy.common.utils.file;

import com.hjy.common.utils.IDUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件上传工具类
 */
public  class FileUtils {

    /**
     * 判断是否为视频格式
     * @param file
     * @return
     */
    public static boolean isVideoFile(MultipartFile file){
        if(file !=null){
            //文件全名
            String fileName = file.getOriginalFilename();
            //文件名后缀，即文件类型
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String[] s ={".avi",".baimov",".rmvb",".rm",".flv",".mp4",".3gp",".mpeg",".asf",".wmv",".navi",".f4v",".mpg",".dat"};
            if(ArrayUtils.contains(s,suffixName.toLowerCase())){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    /**
     * 判断是否为文档格式
     * @param file
     * @return
     */
    public static boolean isDocFile(MultipartFile file){
        if(file !=null){
            //文件全名
            String fileName = file.getOriginalFilename();
            //文件名后缀，即文件类型
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String[] s ={".doc",".docx",".ppt",".pptx",".xls",".xlsx"};
            if(ArrayUtils.contains(s,suffixName.toLowerCase())){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    /**
     * 判断是否为图片格式
     * @param file
     * @return
     */
    public static boolean isPicFile(MultipartFile file){
        if(file !=null){
            //文件全名
            String fileName = file.getOriginalFilename();
            //文件名后缀，即文件类型
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String[] s ={".jpg",".png",".ppt",".pptx",".xls",".xlsx"};
            if(ArrayUtils.contains(s,suffixName.toLowerCase())){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
   //文件保存工具
    public static String fileUpload(String upLoadPath, MultipartFile file,String username){
        String fileName = file.getOriginalFilename();
        //文件名后缀，即文件类型
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String time = sdf.format(date.getTime());
        time = time +"/"+suffixName.replace(".","");
        //1.创建目录
        StringBuffer dirpath = new StringBuffer(time);
        dirpath.insert(0,upLoadPath);
        File targetFile = new File(dirpath.toString());
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        File saveFile = new File(targetFile, username+IDUtils.getUUID()+suffixName.toLowerCase());
        try {
            file.transferTo(saveFile);
        } catch (Exception e) {
        }
        return saveFile.getPath();
    }

}
