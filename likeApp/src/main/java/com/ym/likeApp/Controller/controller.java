package com.ym.likeApp.Controller;

import com.ym.likeApp.models.LikeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/like")
public class controller {

    @Autowired
    private KafkaTemplate<String, LikeEvent> kafkaTemplate;

//    public controller(KafkaTemplate<String,LikeEvent> kafkaTemplate){
//        this.kafkaTemplate = kafkaTemplate;
//    }

    @PostMapping("/{postId}")
    public ResponseEntity<Void> likePost(@PathVariable Long postId, @RequestBody Long userId){
        LikeEvent likeEvent = new LikeEvent(postId,userId, Instant.now());
        kafkaTemplate.send("like-topic",likeEvent);
        return ResponseEntity.ok().build();
    }


}