package com.rookiefly.open.toplist.crawler.processor;

import com.rookiefly.open.toplist.common.constants.Sites;
import com.rookiefly.open.toplist.common.entity.News;
import com.rookiefly.open.toplist.common.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

import static com.rookiefly.open.toplist.crawler.constants.CrawlerConstant.USER_AGENT;

/**
 * Github Trending爬虫
 */
@Slf4j
public class GithubProcessor implements PageProcessor {

    private final Site site = Site.me()
            .setDomain("github.com")
            .setSleepTime(1000)
            .setUserAgent(USER_AGENT);
    ;

    public static final String HOST = "https://github.com";

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(HOST).match()) {
            List<Selectable> list = page.getHtml().xpath("//article[@class=\"Box-row\"]").nodes();
            for (Selectable s : list) {
                String title = s.xpath("h1/a/@href").toString().substring(1);
                String link = s.xpath("h1/a").links().toString();
                News news = new News();
                news.setTitle(title);
                news.setUrl(link);
                news.setSite(Sites.GITHUB.getId());
                try {
                    news.setUrlKey("github_trending_" + MD5Util.md5(link));
                } catch (Exception e) {
                    log.error("md5 hash error", e);
                }
                page.putField("news" + title, news);
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}