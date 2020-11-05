package com.hjy.business.dao;

import com.hjy.business.entity.TBanner;

import java.util.List;

/**
 * (TBanner)表数据库访问层
 *
 * @author TBanner
 * @since 2020-07-27 16:15:29
 */
public interface ExcelDataMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param pkBannerId 主键
     * @return 实例对象
     */
    TBanner selectById(String pkBannerId);

    /**
     * 新增数据
     *
     * @param tBanner 实例对象
     * @return 影响行数
     */
    int insertSelective(TBanner tBanner);

    /**
     * 修改数据
     *
     * @param tBanner 实例对象
     * @return 影响行数
     */
    int updateById(TBanner tBanner);

    /**
     * 通过主键删除数据
     *
     * @param pkBannerId 主键
     * @return 影响行数
     */
    int deleteById(String pkBannerId);

     /**
     * 通过实体作为筛选条件查询
     *
     * @param tBanner 实例对象
     * @return 对象列表
     */
    List<TBanner> selectAllPage(TBanner tBanner);

}