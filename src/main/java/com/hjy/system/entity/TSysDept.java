package com.hjy.system.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TSysDept)实体类
 *
 * @author makejava
 * @since 2020-09-28 09:48:46
 */
@Data
public class TSysDept implements Serializable {
    private static final long serialVersionUID = -68710426239434138L;
    /**
     * 部门主键id
     */
    private Integer pkDeptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 部门地址
     */
    private String deptAddress;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 部门级别
     */
    private String deptLevel;
    /**
     * 上级部门
     */
    private String superiorDept;
    /**
     * 部门领导
     */
    private String deptLeader;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 领导证件号
     */
    private String leaderCard;
}