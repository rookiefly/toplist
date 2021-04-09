package com.rookiefly.open.toplist.crawler.pipeline;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rookiefly.open.toplist.common.entity.News;
import com.rookiefly.open.toplist.crawler.repository.NewsRepository;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class NewsPipeline implements Pipeline {

    @Resource
    private NewsRepository newsRepository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getKey().contains("news")) {
                News news = (News) entry.getValue();
                QueryWrapper<News> sectionQueryWrapper = new QueryWrapper<>();
                sectionQueryWrapper.eq("url_key", news.getUrlKey());
                if (newsRepository.selectOne(sectionQueryWrapper) == null) {
                    newsRepository.insert(news);
                }
            }

        }
    }
}