package com.rookiefly.open.toplist.web.controller;

import com.rookiefly.open.toplist.common.constants.Sites;
import com.rookiefly.open.toplist.common.entity.News;
import com.rookiefly.open.toplist.web.service.NewsService;
import com.rookiefly.open.toplist.web.vo.Site;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname ToplistController
 * @Description Controller
 * @Created by rookiefly
 */
@RestController
public class ToplistController {

    @Resource
    private NewsService newsService;

    @GetMapping("/sites")
    public List<Site> sites() {
        List<Site> siteList = Arrays.stream(Sites.values()).map(siteEnum -> {
            Site site = new Site();
            site.setId(siteEnum.getId());
            site.setTitle(siteEnum.getTitle());
            site.setSlug(siteEnum.getSlug());
            return site;
        }).collect(Collectors.toList());
        return siteList;
    }

    @GetMapping("/sites/{site}/items")
    public List<News> items(@PathVariable String site) {
        return newsService.listNews(site);
    }
}
