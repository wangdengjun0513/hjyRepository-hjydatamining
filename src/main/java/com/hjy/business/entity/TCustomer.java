package com.hjy.business.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TCustomer)实体类
 *
 * @author wangdengjun
 * @since
 */
@Data
public class TCustomer implements Serializable {
    private static final long serialVersionUID = -2654819087415453966L;
    /**
     * 新闻主键id
     */
    private String pkCustomerId;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 联系方式
     */
    private String customerTel;
    /**
     * 客户来源
     */
    private String customerSource;
    /**
     * 单位
     */
    private String customerCompany;
    /**
     * 职务
     */
    private String customerPost;
    /**
     * 性格特点
     */
    private String customerCharacter;
    /**
     * 客户简介
     */
    private String characterProfile;
    /**
     * 创建时间
     */
    private Date customerDate;
    /**
     * 创建人id
     */
    private String fkUserId;
    /**
     * 最后修改人id
     */
    private String lastModifyUserId;
    /**
     * 最后修改时间
     */
    private Date lastModifyDate;
}