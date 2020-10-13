package com.hjy.system.controller;

import com.hjy.business.entity.TBanner;
import com.hjy.business.service.TBannerService;
import com.hjy.common.domin.CommonResult;
import com.hjy.common.exception.FebsException;
import com.hjy.common.utils.TokenUtil;
import com.hjy.system.entity.SysToken;
import com.hjy.system.service.ShiroService;
import com.hjy.system.service.VideoUpLoadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * (TBanner)表控制层
 *
 * @author wangdengjun
 * @since 2020-09-28 17:48:11
 */
@Slf4j
@RestController
public class VideoUpLoadController {
    @Autowired
    private VideoUpLoadService videoUpLoadService;
    @Value("${video.upload.path}")
    private String videoUpLoadPath;
    /**
     * 单个上传视频
     */
    @RequiresPermissions({"video:upload"})
    @PostMapping("/video/upload")
    public CommonResult singleVideoUpLoad(MultipartFile file) throws FebsException {
        try {
            return videoUpLoadService.singleVideoUpLoad(file,videoUpLoadPath);
        } catch (Exception e) {
            String message = "上传失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}