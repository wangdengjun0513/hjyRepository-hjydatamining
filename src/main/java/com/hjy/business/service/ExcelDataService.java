package com.hjy.business.service;

import com.hjy.common.domin.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传服务接口
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
public interface ExcelDataService {


    /**
     * 单个上传视频
     *
     * @param file
     * @return
     * @
     */
    CommonResult uploadExcel(MultipartFile file, HttpServletRequest httpRequest);


}