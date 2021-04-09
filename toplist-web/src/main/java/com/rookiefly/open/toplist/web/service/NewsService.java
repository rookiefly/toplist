package com.rookiefly.open.toplist.web.service;

import com.rookiefly.open.toplist.common.entity.News;

import java.util.List;

/**
 * @Classname NewsService
 * @Description TODO
 * @Created by rookiefly
 */
public interface NewsService {

    List<News> listNews(String site);
}
