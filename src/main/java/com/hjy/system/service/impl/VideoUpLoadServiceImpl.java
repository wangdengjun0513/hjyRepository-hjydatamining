package com.hjy.system.service.impl;

import com.hjy.common.utils.file.VideoFileUtil;
import com.hjy.system.service.VideoUpLoadService;
import com.hjy.common.domin.CommonResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 视频服务实现类
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
@Service
public class VideoUpLoadServiceImpl implements VideoUpLoadService {


    @Override
    public CommonResult singleVideoUpLoad(MultipartFile file,String videoUpLoadPath) throws Exception {

        return new CommonResult(200,"success","上传成功!", VideoFileUtil.fileUpload(videoUpLoadPath,file));
    }
}