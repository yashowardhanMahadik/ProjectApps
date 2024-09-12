package com.ym.kafkaConsumer;

import com.ym.kafkaConsumer.models.LikeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerClass {
    public static final String TOPIC2 = "mongo-topic";

    @Autowired
    MongoRepo repo;

    @KafkaListener(topics = TOPIC2, groupId = "YM-groupz")
    public void consumeMsg(LikeEvent event) {
        repo.save(event);
        System.out.println("Got yhe like event from the topic postId: " + event.getPostId() + ", userId: " + event.getUserId());
    }
}
