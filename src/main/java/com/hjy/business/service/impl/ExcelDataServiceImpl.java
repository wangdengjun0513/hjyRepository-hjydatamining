package com.hjy.business.service.impl;

import com.hjy.business.entity.ExcelData;
import com.hjy.business.service.ExcelDataService;
import com.hjy.common.domin.CommonResult;
import com.hjy.common.utils.ExcelUtil;
import com.hjy.common.utils.TokenUtil;
import com.hjy.common.utils.file.FileUtils;
import com.hjy.system.entity.SysToken;
import com.hjy.system.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传服务实现类
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
@Service
public class ExcelDataServiceImpl implements ExcelDataService {

    @Autowired
    private ShiroService shiroService;

    @Override
    public CommonResult uploadExcel(MultipartFile file, HttpServletRequest httpRequest) {
        if (null == file || file.isEmpty()) {
            return new CommonResult(440, "success", "请选择excel文件", null);
        }
        if (!ExcelUtil.isExcelFile(file)) {
            return new CommonResult(441, "success", "非excel格式文件，不能上传", null);
        }
        List<ExcelData> parsedResult = ExcelUtil.readExcel(file);
        SysToken sysToken = shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
        Map<String, Object> pathMap = new HashMap<String, Object>();
//        pathMap.put("path", FileUtils.fileUpload(file, sysToken.getUsername()));
        return new CommonResult(200, "success", "上传成功!", pathMap);
    }

}