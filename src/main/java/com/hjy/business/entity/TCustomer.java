package com.hjy.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private static final long serialVersionUID = -6687282543187512055L;
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
    private String customerContact;
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
    private String customerProfile;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createDate;
    /**
     * 创建人id
     */
    private String createUserId;
    /**
     * 创建人姓名
     */
    private String createUseFullName;
    /**
     * 最后修改人id
     */
    private String lastModifyUserId;
    /**
     * 最后修改人姓名
     */
    private String lastModifyUserFullName;
    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date lastModifyDate;
}