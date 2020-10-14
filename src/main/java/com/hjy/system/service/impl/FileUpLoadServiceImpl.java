package com.hjy.system.service.impl;

import com.hjy.common.domin.CommonResult;
import com.hjy.common.utils.file.FileUtils;
import com.hjy.system.service.fileUpLoadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传服务实现类
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
@Service
public class FileUpLoadServiceImpl implements fileUpLoadService {


    @Override
    public CommonResult singleVideoUpLoad(MultipartFile file,String username) throws Exception {
        if(!FileUtils.isVideoFile(file)){
            return new CommonResult(201,"success","非视频格式文件，不能上传", null);
        }
        Map<String,Object> pathMap = new HashMap<String,Object>();
        pathMap.put("path",FileUtils.fileUpload(file,username));
        return new CommonResult(200,"success","上传成功!", pathMap);
    }

    @Override
    public CommonResult singlePicUpLoad(MultipartFile file,String username) throws Exception {
        if(!FileUtils.isPicFile(file)){
            return new CommonResult(201,"success","非图片格式文件，不能上传", null);
        }
        Map<String,Object> pathMap = new HashMap<String,Object>();
        pathMap.put("path",FileUtils.fileUpload(file,username));
        return new CommonResult(200,"success","上传成功!", pathMap);
    }

    @Override
    public CommonResult singleDocUpLoad(MultipartFile file,String username) throws Exception {
        if(!FileUtils.isDocFile(file)){
            return new CommonResult(201,"success","非文档格式文件，不能上传", null);
        }
        Map<String,Object> pathMap = new HashMap<String,Object>();
        pathMap.put("path",FileUtils.fileUpload(file,username));
        return new CommonResult(200,"success","上传成功!", pathMap);
    }

    /**
     * 批量上传视频
     * @param file
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public CommonResult batchVideoUpLoad(MultipartFile[] file,String username) throws Exception {
        return new CommonResult(200,"success","上传成功!", FileUtils.fileBatchUpload(file,username));
    }

    /**
     * 批量上传图片
     * @param file
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public CommonResult batchPicUpLoad(MultipartFile[] file,String username) throws Exception {
        return new CommonResult(200,"success","上传成功!", FileUtils.fileBatchUpload(file,username));
    }

    /**
     * 批量上传文档
     * @param file
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public CommonResult batchDocUpLoad(MultipartFile[] file,String username) throws Exception {
        return new CommonResult(200,"success","上传成功!", FileUtils.fileBatchUpload(file,username));
    }
}