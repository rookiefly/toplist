package com.rookiefly.open.toplist.crawler.processor;

import com.rookiefly.open.toplist.crawler.pipeline.NewsPipeline;
import org.junit.jupiter.api.Test;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 * @Classname ProcessorTest
 * @Description TODO
 * @Created by rookiefly
 */
public class ProcessorTest {

    @Test
    public void testGithub() {
        Spider spider = Spider.create(new GithubProcessor());
        spider.addUrl("https://github.com/trending");
        spider.addPipeline(new ConsolePipeline());
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testJianShu() {
        Spider spider = Spider.create(new JianShuProcessor());
        spider.addUrl("https://www.jianshu.com");
        spider.addPipeline(new ConsolePipeline());
        spider.thread(1);
        spider.setExitWhenComplete(true);
        spider.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testV2ex() {
        Spider spider = Spider.create(new V2exProcessor());
        spider.addUrl("https://www.v2ex.com/?tab=hot");
        spider.addPipeline(new ConsolePipeline());
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testWeibo() {
        Spider spider = Spider.create(new WeiboProcessor());
        spider.addUrl("https://s.weibo.com/top/summary");
        spider.addPipeline(new ConsolePipeline());
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testZhihu() {
        Spider spider = Spider.create(new ZhiHuProcessor());
        spider.addUrl("https://www.zhihu.com/hot");
        spider.addPipeline(new ConsolePipeline());
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
