package com.ym.reddit1.subreddit;

import com.ym.reddit1.models.Subreddit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubredditImpl {
    //crud
    @Autowired
    SubredditRepo subredditRepo;

    public void addSubreddit(String name){
        subredditRepo.save(new Subreddit(name));
    }

    public boolean checkSubreddit(String name){
       return subredditRepo.findByName(name).isPresent();
    }

    public List<Subreddit> getAll(){
        return subredditRepo.findAll();
    }
}
