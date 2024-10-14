package com.ym.likeApp;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class beans {
    public static final String TOPIC1 =  "like-topic";
    public static final String TOPIC2 =  "mongo-topic";

    public static final String TOPIC3 =  "mongo-topic";
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(TOPIC1)
                .partitions(3)
                .build();
    }

    public NewTopic mongoTopic(){
        return TopicBuilder.name(TOPIC2)
                .partitions(2)
                .build();
    }

    public NewTopic voteTopic(){
        return TopicBuilder.name(TOPIC3)
                .partitions(2)
                .build();
    }
}
