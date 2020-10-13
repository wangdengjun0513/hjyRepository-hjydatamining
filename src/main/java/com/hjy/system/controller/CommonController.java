package com.hjy.system.controller;

import com.hjy.common.domin.CommonResult;
import com.hjy.common.exception.FebsException;
import com.hjy.common.utils.IDUtils;
import com.hjy.system.entity.ActiveUser;
import com.hjy.system.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class CommonController {

    @Autowired
    private ShiroService shiroService;

    @PostMapping("/common/file/upload")
    public CommonResult fileUpload(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpSession session) throws FebsException {
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        try {
            //
            CommonResult commonResult = shiroService.insertFile(activeUser.getUsername(),files);
            return commonResult;
        } catch (Exception e) {
            String message = "文件上传失败！";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}
