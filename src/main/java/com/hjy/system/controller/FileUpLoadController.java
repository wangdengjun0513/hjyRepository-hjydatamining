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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    /**
     * 单个上传视频
     */
    @RequiresPermissions({"upload:video"})
    @PostMapping("/file/upload/video")
    public CommonResult singleVideoUpLoad(MultipartFile file, HttpServletRequest httpRequest) throws FebsException {
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return fileUpLoadService.singleVideoUpLoad(file,sysToken.getUsername());
        } catch (Exception e) {
            String message = "上传失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }


    /**
     * 单个上传图片
     */
    @RequiresPermissions({"upload:pic"})
    @PostMapping("/file/upload/pic")
    public CommonResult singlePicUpLoad(MultipartFile file, HttpServletRequest httpRequest) throws FebsException {
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return fileUpLoadService.singlePicUpLoad(file,sysToken.getUsername());
        } catch (Exception e) {
            String message = "上传失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }




    /**
     * 单个上传文档
     */
    @RequiresPermissions({"upload:doc"})
    @PostMapping("/file/upload/doc")
    public CommonResult singleDocUpLoad(MultipartFile file, HttpServletRequest httpRequest) throws FebsException {
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return fileUpLoadService.singleDocUpLoad(file,sysToken.getUsername());
        } catch (Exception e) {
            String message = "上传失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    /**
     * 批量上传视频
     */
    @RequiresPermissions({"upload:video"})
    @PostMapping("/file/upload/batch/video")
    public CommonResult batchVideoUpLoad(MultipartFile[] file, HttpServletRequest httpRequest) throws FebsException {
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return fileUpLoadService.batchVideoUpLoad(file,sysToken.getUsername());
        } catch (Exception e) {
            String message = "上传失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    /**
     * 批量上传图片
     */
    @RequiresPermissions({"upload:pic"})
    @PostMapping("/file/upload/batch/pic")
    public CommonResult batchPicUpLoad(MultipartFile[] file, HttpServletRequest httpRequest) throws FebsException {
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return fileUpLoadService.batchPicUpLoad(file,sysToken.getUsername());
        } catch (Exception e) {
            String message = "上传失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    /**
     * 批量上传文档
     */
    @RequiresPermissions({"upload:doc"})
    @PostMapping("/file/upload/batch/doc")
    public CommonResult batchDocUpLoad(MultipartFile[] file, HttpServletRequest httpRequest) throws FebsException {
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return fileUpLoadService.batchDocUpLoad(file,sysToken.getUsername());
        } catch (Exception e) {
            String message = "上传失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}