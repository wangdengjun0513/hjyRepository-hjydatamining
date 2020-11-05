package com.hjy.business.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (TBanner)实体类
 *
 * @author wangdengjun
 * @since 2020-09-28 17:48:11
 */
@Data
public class ExcelData implements Serializable {
    private static final long serialVersionUID = -2815122340981197225L;
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 居住地
     */
    private String location;

    /**
     * 职业
     */
    private String job;
}