package com.hjy.system.controller;

import com.hjy.common.domin.CommonResult;
import com.hjy.common.exception.FebsException;
import com.hjy.common.utils.TokenUtil;
import com.hjy.system.entity.SysToken;
import com.hjy.system.service.ShiroService;
import com.hjy.system.service.fileUpLoadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传控制层
 *
 * @author wangdengjun
 * @since 2020-09-28 17:48:11
 */
@Slf4j
@RestController
public class FileUpLoadController {
    @Autowired
    private fileUpLoadService fileUpLoadService;
    @Autowired
    private ShiroService shiroService;
    @Value("${file.upload.path}")
    private String upLoadPath;

    /**
     * 单个上传视频
     */
    @RequiresPermissions({"video:upload"})
    @PostMapping("/file/upload/video")
    public CommonResult singleVideoUpLoad(MultipartFile file, HttpServletRequest httpRequest) throws FebsException {
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return fileUpLoadService.singleVideoUpLoad(file,upLoadPath,sysToken.getUsername());
        } catch (Exception e) {
            String message = "上传失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}