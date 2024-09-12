package com.ym.kafkaConsumer;

import com.ym.kafkaConsumer.models.LikeEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo extends MongoRepository<LikeEvent,String> {
}
