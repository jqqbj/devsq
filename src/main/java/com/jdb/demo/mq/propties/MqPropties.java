package com.jdb.demo.mq.propties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MQ配置文件
 *
 * @author RickyWang
 * @date 18/1/1 15:11:47
 */
@Component
@ConfigurationProperties(prefix = "spring.activemq")
public class MqPropties {

     private String defaultQueueName;

     private Integer queuePrefetch;

    public String getDefaultQueueName() {
        return defaultQueueName;
    }

    public void setDefaultQueueName(String defaultQueueName) {
        this.defaultQueueName = defaultQueueName;
    }

    public Integer getQueuePrefetch() {
        return queuePrefetch;
    }

    public void setQueuePrefetch(Integer queuePrefetch) {
        this.queuePrefetch = queuePrefetch;
    }
}
