package com.hjy.business.service;

import com.hjy.business.entity.TBanner;
import com.hjy.common.domin.CommonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * (TBanner)表服务接口
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
public interface TBannerService {

    /**
     * 通过ID查询单条数据
     *
     * @param parm 主键
     * @return 实例对象
     */
    CommonResult selectById(String parm);


    /**
     * 新增数据
     *
     * @param tBanner
     * @return
     * @
     */
    CommonResult insertSelective(TBanner tBanner, HttpServletRequest httpRequest);


    /**
     * 修改数据
     *
     * @param tBanner
     * @return
     * @
     */
    CommonResult updateById(TBanner tBanner, HttpServletRequest httpRequest);

    /**
     * 通过主键删除数据
     *
     * @param parm 主键
     * @return 是否成功
     */
    CommonResult deleteById(String parm);

    /**
     * @param param
     * @return
     */
    CommonResult selectAllPage(String param);
}