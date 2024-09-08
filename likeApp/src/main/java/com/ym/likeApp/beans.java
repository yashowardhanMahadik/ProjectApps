package com.ym.likeApp;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class beans {
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("like-topic")
                .partitions(3)
                .build();
    }
}
