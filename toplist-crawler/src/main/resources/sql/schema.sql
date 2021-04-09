DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `title`       varchar(255) NOT NULL COMMENT '标题',
    `url`         varchar(255) NOT NULL COMMENT '跳转url',
    `site`        tinyint(5)   NOT NULL COMMENT '1.微博 2.知乎 3.github 4.v2ex 5.简书',
    `url_key`     varchar(55)  NOT NULL COMMENT 'url md5值',
    `feature`     json                  DEFAULT NULL COMMENT '其他特殊字段',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`url_key`),
    KEY (`site`, `create_time`)
) AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;