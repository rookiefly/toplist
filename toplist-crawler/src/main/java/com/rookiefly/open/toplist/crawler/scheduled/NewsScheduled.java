package com.rookiefly.open.toplist.crawler.scheduled;

import com.rookiefly.open.toplist.crawler.pipeline.NewsPipeline;
import com.rookiefly.open.toplist.crawler.processor.GithubProcessor;
import com.rookiefly.open.toplist.crawler.processor.JianShuProcessor;
import com.rookiefly.open.toplist.crawler.processor.V2exProcessor;
import com.rookiefly.open.toplist.crawler.processor.WeiboProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;

@Component
@Slf4j
public class NewsScheduled {

    @Resource
    private NewsPipeline newsPipeline;

    /**
     * 简书爬虫定时任务
     */
    @Scheduled(cron = "0 0/10 * * * ? ")
    public void jianShuScheduled() {
        log.info("----开始执行简书定时任务----");
        Spider spider = Spider.create(new JianShuProcessor());
        spider.addUrl("http://www.jianshu.com");
        spider.addPipeline(newsPipeline);
        spider.thread(1);
        spider.setExitWhenComplete(true);
        spider.start();
    }

    /**
     * v2ex爬虫定时任务
     */
    @Scheduled(cron = "0 0/10 * * * ? ")
    public void v2exScheduled() {
        log.info("----开始执行v2ex定时任务----");
        Spider spider = Spider.create(new V2exProcessor());
        spider.addUrl("https://www.v2ex.com/?tab=hot");
        spider.addPipeline(newsPipeline);
        spider.thread(1);
        spider.setExitWhenComplete(true);
        spider.start();
    }

    /**
     * github爬虫定时任务
     */
    @Scheduled(cron = "0 0/10 * * * ? ")
    public void githubScheduled() {
        log.info("----开始执行github定时任务----");
        Spider spider = Spider.create(new GithubProcessor());
        spider.addUrl("https://github.com/trending");
        spider.addPipeline(newsPipeline);
        spider.thread(1);
        spider.setExitWhenComplete(true);
        spider.start();
    }

    /**
     * weibo爬虫定时任务
     */
    @Scheduled(cron = "0 0/10 * * * ? ")
    public void weiboScheduled() {
        log.info("----开始执行weibo定时任务----");
        Spider spider = Spider.create(new WeiboProcessor());
        spider.addUrl("https://s.weibo.com/top/summary");
        spider.addPipeline(newsPipeline);
        spider.thread(1);
        spider.setExitWhenComplete(true);
        spider.start();
    }
}