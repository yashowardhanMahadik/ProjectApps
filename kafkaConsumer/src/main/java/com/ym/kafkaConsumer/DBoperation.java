package com.ym.kafkaConsumer;

import com.ym.kafkaConsumer.models.LikeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBoperation {

//    @Autowired
//     MongoVoteRepo voteRepo;

    @Autowired
    LikeRepo repo;

    public void save(LikeEvent s){
        repo.save(s);
    }
}
