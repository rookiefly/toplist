package com.rookiefly.open.toplist.common.constants;

import java.util.Arrays;

/**
 * @Classname ChannelType
 * @Description 1.微博热门 2.知乎热榜 3.github趋势 4.v2ex热门 5.简书推荐
 * @Created by rookiefly
 */
public enum Sites {
    /**
     * 微博热门
     */
    WEIBO(1, "微博", "weibo"),
    ZHIHU(2, "知乎", "zhihu"),
    GITHUB(3, "github", "github"),
    V2EX(4, "v2ex", "v2ex"),
    JIANSHU(5, "简书", "jianshu"),
    ;

    private final Integer id;

    private final String title;

    private final String slug;

    Sites(Integer id, String title, String slug) {
        this.id = id;
        this.title = title;
        this.slug = slug;
    }

    public static Integer slugOf(String site) {
        return Arrays.stream(Sites.values()).filter(sites -> site.equals(sites.getSlug())).findFirst().map(Sites::getId).orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }
}
