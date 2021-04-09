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
 * 简书首页爬虫
 */
@Slf4j
public class JianShuProcessor implements PageProcessor {

    private Site site = Site.me()
            .setDomain("jianshu.com")
            .setSleepTime(100)
            .setUserAgent(USER_AGENT);
    ;

    public static final String HOST = "https://www.jianshu.com";

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(HOST).match()) {
            List<Selectable> list = page.getHtml().xpath("//ul[@class='note-list']/li").nodes();
            for (Selectable s : list) {
                String title = s.xpath("//div/a/text()").toString();
                String link = s.xpath("//div/a").links().toString();
                News news = new News();
                news.setTitle(title);
                news.setUrl(link);
                news.setSite(Sites.JIANSHU.getId());
                try {
                    news.setUrlKey("jianshu_hot_" + MD5Util.md5(link));
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