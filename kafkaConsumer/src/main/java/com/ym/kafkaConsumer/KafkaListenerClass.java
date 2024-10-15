package com.ym.kafkaConsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ym.kafkaConsumer.models.LikeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerClass {
    public static final String TOPIC2 = "mongo-topic";
    public static final String TOPIC3 = "mongo-topic";
    public static final String GROUP_ID = "YM-groupz";

    @Autowired
    LikeRepo repo;

//    @Autowired
//    MongoVoteRepo voteRepo;

    public KafkaListenerClass(LikeRepo mongoRepo){
        this.repo = mongoRepo;
    }

    @KafkaListener(topics = TOPIC2, groupId = GROUP_ID)
    public void consumeMsg(String jsonStr) {
//        JsonObject jsonObject = new JsonObject(jsonStr);
        System.out.println("Got the consumer record"+jsonStr);
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        LikeEvent event;
        try {
            event = mapper.readValue(jsonStr,LikeEvent.class);
            repo.save(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Got yhe like event from the topic postId: " + event.getPostId() + ", userId: " + event.getUserId());
    }

//    @KafkaListener(topics = TOPIC3, groupId = GROUP_ID)
//    public void consumeVote(String jsonStr) {
////        JsonObject jsonObject = new JsonObject(jsonStr);
//        System.out.println("Got the vote record"+jsonStr);
//        ObjectMapper mapper = JsonMapper.builder()
//                .addModule(new JavaTimeModule())
//                .build();
//        VoteEvent event;
//        try {
//            event = mapper.readValue(jsonStr,VoteEvent.class);
//            voteRepo.save(event);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Got yhe like event from the topic postId: " + event.getPostId() + ", userId: " + event.getUserId());
//    }
}
