package com.hjy.business.controller;

import com.hjy.business.service.ExcelDataService;
import com.hjy.common.domin.CommonResult;
import com.hjy.common.exception.FebsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ExcelDataController {
    @Autowired
    private ExcelDataService excelDataService;

    @PostMapping("/business/upload/excel")
    public CommonResult uploadExcel(MultipartFile file, HttpServletRequest httpRequest) throws FebsException {
        try {
            return excelDataService.uploadExcel(file,httpRequest);
        } catch (Exception e) {
            String message = "修改失败";
            throw new FebsException(message);
        }

    }
}