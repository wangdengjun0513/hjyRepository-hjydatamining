package com.hjy.system.service;

import com.hjy.common.domin.CommonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务接口
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
public interface fileUpLoadService {


    /**
     * 单个上传视频
     * @param file
     * @return
     * @throws Exception
     */
    CommonResult singleVideoUpLoad(MultipartFile file,String username)throws Exception;

    /**
     * 单个上传图片
     * @param file
     * @return
     * @throws Exception
     */
    CommonResult singlePicUpLoad(MultipartFile file,String username)throws Exception;

    /**
     * 单个上传文档
     * @param file
     * @return
     * @throws Exception
     */
    CommonResult singleDocUpLoad(MultipartFile file,String username)throws Exception;

    /**
     * 批量上传视频
     * @param file
     * @return
     * @throws Exception
     */
    CommonResult batchVideoUpLoad(MultipartFile[] file,String username)throws Exception;

    /**
     * 批量上传图片
     * @param file
     * @return
     * @throws Exception
     */
    CommonResult batchPicUpLoad(MultipartFile[] file,String username)throws Exception;

    /**
     * 批量上传文档
     * @param file
     * @return
     * @throws Exception
     */
    CommonResult batchDocUpLoad(MultipartFile[] file,String username)throws Exception;


}