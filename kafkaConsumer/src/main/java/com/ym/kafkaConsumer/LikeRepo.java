package com.ym.kafkaConsumer;

import com.ym.kafkaConsumer.models.LikeEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface LikeRepo extends MongoRepository<LikeEvent,String> {
}
