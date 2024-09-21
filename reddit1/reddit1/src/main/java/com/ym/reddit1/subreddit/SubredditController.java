package com.ym.reddit1.subreddit;

import com.ym.reddit1.models.Subreddit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/red1/sub")
public class SubredditController {

    @Autowired
    SubredditImpl subredditImpl;

    //create
    @PostMapping("/create")
    public ResponseEntity<Subreddit> create(@RequestBody String name){
        subredditImpl.addSubreddit(name);
        return ResponseEntity.ok(new Subreddit(name));
    }

    @GetMapping("/check/{name}")
    @ResponseBody
    public boolean checkSubredditExists(@PathVariable String name){
         return subredditImpl.checkSubreddit(name);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Subreddit>> getAll(){
        return ResponseEntity.ok(subredditImpl.getAll());
    }

    @GetMapping("/search/{key}")
    public ResponseEntity<?> getByKey(@PathVariable String key){
        return ResponseEntity.ok(subredditImpl.search(key));
    }
}
