package com.hjy.common.utils.file;

import com.hjy.common.utils.IDUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class VideoFileUtil {

    //判断是否为视频文件
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
   //文件保存工具
    public static String fileUpload(String videoUpLoadPath, MultipartFile file){
        String fileName = file.getOriginalFilename();
        //文件名后缀，即文件类型
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String time = sdf.format(date.getTime());
        //1.创建目录
        StringBuffer dirpath = new StringBuffer(time);
        String filePath = null;
        dirpath.insert(0,videoUpLoadPath);
        filePath = videoUpLoadPath;
        File targetFile = new File(dirpath.toString());
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        File saveFile = new File(targetFile, IDUtils.getUUID()+suffixName.toLowerCase());
        try {
            file.transferTo(saveFile);
        } catch (Exception e) {
        }
        return filePath;
    }

}
