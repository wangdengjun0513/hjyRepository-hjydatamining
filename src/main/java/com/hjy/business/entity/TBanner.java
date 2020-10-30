package com.hjy.business.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TBanner)实体类
 *
 * @author wangdengjun
 * @since 2020-09-28 17:48:11
 */
@Data
public class TBanner implements Serializable {
    private static final long serialVersionUID = -4053792221031891812L;
    /**
     * banner主键id
     */
    private String pkBannerId;
    /**
     * banner图片
     */
    private String bannerPic;
    /**
     * banner标题
     */
    private String bannerTitle;
    /**
     * banner描述
     */
    private String bannerDesc;
    /**
     * pc跳转地址
     */
    private String bannerPcUrl;
    /**
     * 移动端跳转地址
     */
    private String bannerMobileUrl;
    /**
     * banner状态1已上线2未上线
     */
    private int bannerStatus;
    /**
     * banner序号（值越大越靠前）
     */
    private int bannerSort;
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