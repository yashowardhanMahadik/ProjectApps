package com.ym.likeApp.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ym.likeApp.models.LikeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

import static com.ym.likeApp.beans.TOPIC1;
import static com.ym.likeApp.beans.TOPIC2;

@RestController
@RequestMapping("/like")
public class controller {

    private final KafkaTemplate<String, String> kafkaTemplate;

//    private final KafkaTemplate<String,LikeEvent> kafkaTemplate2;

    public controller(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
//        this.kafkaTemplate2 = kafkaTemplate2;
    }

    @GetMapping("/mockAdd/{message}")
    public ResponseEntity<?> likePost(@PathVariable String message){
        long postId = 12132;
        long userId = 42414;
//        LikeEvent likeEvent = new LikeEvent(postId,userId, Instant.now());
//        kafkaTemplate.send(TOPIC1,likeEvent);
        kafkaTemplate.send(TOPIC1,message);
        return ResponseEntity.ok("likeEvent");
    }
    @PostMapping("/postId/{postId}")
    public ResponseEntity<?> addLikeToPost(@PathVariable Long postId, @RequestBody Long userId){
        LikeEvent likeEvent = new LikeEvent(postId,userId, Instant.now());
        ObjectMapper Obj = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        try{
            String jsonStr = Obj.writeValueAsString(likeEvent);
            kafkaTemplate.send(TOPIC2,jsonStr);
        }catch (Exception e){
            System.out.println("EXXXXXXXeption occcccccured");
            e.printStackTrace();
        }

        return ResponseEntity.ok("TOPIC2  @ mongotopic");
    }

    @GetMapping("/live")
    public String isLive(){
        return "ResponseEntity.ok().body(Like-app working)";
    }


}