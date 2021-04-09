package com.rookiefly.open.toplist.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rookiefly.open.toplist.common.constants.Sites;
import com.rookiefly.open.toplist.common.entity.News;
import com.rookiefly.open.toplist.web.repository.NewsRepository;
import com.rookiefly.open.toplist.web.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname NewsServiceImpl
 * @Description TODO
 * @Created by rookiefly
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsRepository newsRepository;

    @Override
    public List<News> listNews(String site) {
        Integer siteId = Sites.slugOf(site);
        if (siteId == null) {
            return null;
        }
        QueryWrapper<News> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("site", siteId);
        return newsRepository.selectList(sectionQueryWrapper);
    }
}
