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

    private final KafkaTemplate<String, String> kafkaTemplate;

    public controller(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/mockAdd/{message}")
    public ResponseEntity<?> likePost(@PathVariable String message){
        long postId = 12132;
        long userId = 42414;
//        LikeEvent likeEvent = new LikeEvent(postId,userId, Instant.now());
//        kafkaTemplate.send("like-topic",likeEvent);
        kafkaTemplate.send("like-topic",message);
        return ResponseEntity.ok("likeEvent");
    }

    @GetMapping("/live")
    public String isLive(){
        return "ResponseEntity.ok().body(Like-app working)";
    }


}