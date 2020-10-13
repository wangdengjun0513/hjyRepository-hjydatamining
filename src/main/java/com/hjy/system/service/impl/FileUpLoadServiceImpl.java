package com.hjy.system.service.impl;

import com.hjy.common.utils.file.FileUtils;
import com.hjy.system.service.fileUpLoadService;
import com.hjy.common.domin.CommonResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务实现类
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
@Service
public class FileUpLoadServiceImpl implements fileUpLoadService {


    @Override
    public CommonResult singleVideoUpLoad(MultipartFile file,String upLoadPath,String username) throws Exception {

        return new CommonResult(200,"success","上传成功!", FileUtils.fileUpload(upLoadPath,file,username));
    }
}