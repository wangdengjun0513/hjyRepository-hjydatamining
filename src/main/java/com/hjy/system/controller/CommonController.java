package com.hjy.system.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hjy.common.domin.CommonResult;
import com.hjy.common.exception.FebsException;
import com.hjy.common.utils.IDUtils;
import com.hjy.common.utils.JsonUtil;
import com.hjy.common.utils.PasswordEncryptUtils;
import com.hjy.system.entity.ActiveUser;
import com.hjy.system.entity.TSysUser;
import com.hjy.system.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    @PostMapping("/test")
    public Map<String,Object> tSysUserAdd(@RequestBody TSysUser tSysUser) throws FebsException{
        try {
            Map<String,Object> result = new HashMap<>();
            String username = tSysUser.getUsername();
            String passwordN0 = tSysUser.getPassword();
            String password = PasswordEncryptUtils.MyPasswordEncryptUtil(username,passwordN0);
            result.put("password",password);
            return result;
        } catch (Exception e) {
            String message = "数据添加失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}
