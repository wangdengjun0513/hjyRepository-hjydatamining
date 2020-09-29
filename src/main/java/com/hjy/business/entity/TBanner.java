package com.hjy.business.entity;

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
     * banner状态1已上线0未上线
     */
    private int bannerStatus;
    /**
     * 创建时间
     */
    private Date bannerDate;
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