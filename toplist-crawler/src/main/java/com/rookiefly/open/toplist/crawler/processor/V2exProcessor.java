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
 * V2EX首页爬虫
 */
@Slf4j
public class V2exProcessor implements PageProcessor {

    private Site site = Site.me()
            .setDomain("v2ex.com")
            .setSleepTime(100)
            .setUserAgent(USER_AGENT);
    ;

    public static final String HOST = "https://www.v2ex.com";

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(HOST).match()) {
            List<Selectable> list = page.getHtml().xpath("//span[@class=\"item_title\"]").nodes();
            for (Selectable s : list) {
                String title = s.xpath("a/text()").toString();
                String link = s.xpath("a").links().toString().split("#")[0];
                News news = new News();
                news.setTitle(title);
                news.setUrl(link);
                news.setSite(Sites.V2EX.getId());
                try {
                    news.setUrlKey("v2ex_hot_" + MD5Util.md5(link));
                } catch (Exception e) {
                    log.error("md5 hash error", e);
                }
                page.putField("news_" + link, news);
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}