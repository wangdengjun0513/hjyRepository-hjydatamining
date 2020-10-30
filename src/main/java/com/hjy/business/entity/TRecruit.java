package com.hjy.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TRecruit)实体类
 *
 * @author wangdengjun
 * @since 2020-09-28 17:48:11
 */
@Data
public class TRecruit implements Serializable {
    private static final long serialVersionUID = -4053792221031891812L;
    /**
     * Recruit主键id
     */
    private String pkRecruitId;
    /**
     * 招聘职位
     */
    private String recruitPosition;
    /**
     * 任职要求
     */
    private String recruitRequirement;
    /**
     * 薪资范围
     */
    private String recruitSalaryRange;
    /**
     * 招聘人数
     */
    private int recruitNumber;
    /**
     * recruit状态1已发布2未发布
     */
    private int recruitStatus;
    /**
     * 序号（值越大越靠前）
     */
    private int recruitSort;
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