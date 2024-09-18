package com.ym.reddit1.subreddit;

import com.ym.reddit1.models.Subreddit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubredditImpl {
    //crud
    @Autowired
    SubredditRepo subredditRepo;

    public void addSubreddit(String name){
        subredditRepo.save(new Subreddit(name));
    }

    public boolean checkSubreddit(String name){
        System.out.println("zzz "+subredditRepo.findByName(name));
       return subredditRepo.findByName(name).isPresent();
    }

    public List<Subreddit> getAll(){
        return subredditRepo.findAll();
    }

    public List<String> search(String key){
      return subredditRepo.searchByKey(key).stream().map(sub-> sub.getName()).collect(Collectors.toList());
    }
}
