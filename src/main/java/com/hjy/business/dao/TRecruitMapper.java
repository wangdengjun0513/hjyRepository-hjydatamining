package com.hjy.business.dao;

import com.hjy.business.entity.TRecruit;

import java.util.List;

/**
 * (TRecruit)表数据库访问层
 *
 * @author TRecruit
 * @since 2020-07-27 16:15:29
 */
public interface TRecruitMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param pkRecruitId 主键
     * @return 实例对象
     */
    TRecruit selectById(String pkRecruitId);

    /**
     * 新增数据
     *
     * @param tRecruit 实例对象
     * @return 影响行数
     */
    int insertSelective(TRecruit tRecruit);

    /**
     * 修改数据
     *
     * @param tRecruit 实例对象
     * @return 影响行数
     */
    int updateById(TRecruit tRecruit);

    /**
     * 通过主键删除数据
     *
     * @param pkRecruitId 主键
     * @return 影响行数
     */
    int deleteById(String pkRecruitId);

     /**
     * 通过实体作为筛选条件查询
     *
     * @param tRecruit 实例对象
     * @return 对象列表
     */
    List<TRecruit> selectAllPage(TRecruit tRecruit);

}