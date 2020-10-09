package com.hjy.business.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TNews)实体类
 *
 * @author wangdengjun
 * @since 2020-09-28 17:48:11
 */
@Data
public class TNews implements Serializable {
    private static final long serialVersionUID = -2654819087415453966L;
    /**
     * 新闻主键id
     */
    private String pkNewsId;
    /**
     * 新闻标题
     */
    private String newsTitle;
    /**
     * 新闻内容
     */
    private String newsContent;
    /**
     * 新闻封面
     */
    private String newsCover;
    /**
     * 新闻状态1已上线0未上线
     */
    private int newsStatus;
    /**
     * 新闻类型 1普通新闻2党内行业新闻3公司党建动态
     */
    private int newsType;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 创建人id
     */
    private String createUserId;
    /**
     * 最后修改人id
     */
    private String lastModifyUserId;
    /**
     * 最后修改时间
     */
    private Date lastModifyDate;
}