package com.rookiefly.open.toplist.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Classname News
 * @Description TODO
 * @Created by rookiefly
 */
@Data
public class News {

    private Long id;

    private String title;

    private String url;

    private Integer site;

    private String urlKey;

    private String feature;

    private Date createTime;

    private Date updateTime;
}
