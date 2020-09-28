package com.hjy.system.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TSysUser)实体类
 *
 * @author makejava
 * @since 2020-09-27 17:53:36
 */
@Data
public class TSysUser implements Serializable {
    private static final long serialVersionUID = 786717923782853729L;
    /**
     * 主键id
     */
    private String pkUserId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 最后一次登录时间
     */
    private Date lastLoginDate;
    /**
     * 部门id
     */
    private String fkDeptId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String tel;
    /**
     * 启用状态
     */
    private String enableStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 证件号
     */
    private String idcard;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 真名
     */
    private String fullName;
    /**
     * ip
     */
    private String ip;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 职位
     */
    private String workPosition;
    /**
     * 工作内容
     */
    private String workContent;

    private int startRow;
    private int endRow;
}