package com.hjy.business.service;

import com.hjy.business.entity.TNews;
import com.hjy.common.domin.CommonResult;

/**
 * (TNews)表服务接口
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
public interface TNewsService {

    /**
     * 通过ID查询单条数据
     *
     * @param parm 主键
     * @return 实例对象
     */
    CommonResult selectById(String parm)throws Exception;


    /**
     * 新增数据
     * @param tNews 实例对象
     * @return 实例对
     */
    CommonResult insertSelective(TNews tNews) throws Exception;

    /**
     * 修改数据
     *
     * @param tNews 实例对象
     * @return 实例对象
     */
    CommonResult updateById(TNews tNews) throws Exception;

    /**
     * 通过主键删除数据
     *
     * @param parm 主键
     * @return 是否成功
     */
    CommonResult deleteById(String parm) throws Exception;

    /**
     *
     * @param param
     * @return
     */
    CommonResult selectAllPage(String param);
}