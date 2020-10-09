package com.hjy.business.dao;

import com.hjy.business.entity.TCustomer;

import java.util.List;

/**
 * (TCustomer)表数据库访问层
 *
 * @author TCustomer
 * @since 2020-07-27 16:15:29
 */
public interface TCustomerMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param pkCustomerId 主键
     * @return 实例对象
     */
    TCustomer selectById(String pkCustomerId);

    /**
     * 新增数据
     *
     * @param TCustomer 实例对象
     * @return 影响行数
     */
    int insertSelective(TCustomer TCustomer);

    /**
     * 修改数据
     *
     * @param TCustomer 实例对象
     * @return 影响行数
     */
    int updateById(TCustomer TCustomer);

    /**
     * 通过主键删除数据
     *
     * @param pkCustomerId 主键
     * @return 影响行数
     */
    int deleteById(String pkCustomerId);

     /**
     * 通过实体作为筛选条件查询
     *
     * @param tCustomer 实例对象
     * @return 对象列表
     */
    List<TCustomer> selectAllPage(TCustomer tCustomer);

}