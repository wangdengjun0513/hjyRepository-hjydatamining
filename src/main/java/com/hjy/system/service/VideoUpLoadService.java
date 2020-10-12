package com.hjy.system.service;

import com.hjy.common.domin.CommonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 视频服务接口
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
public interface VideoUpLoadService {


    /**
     * 单个上传视频
     * @param file
     * @return
     * @throws Exception
     */
    CommonResult singleVideoUpLoad(MultipartFile file,String videoUpLoadPath)throws Exception;


}