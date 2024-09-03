package com.ym.reddit2.post;

import com.ym.reddit2.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    postService postService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> createPost(@RequestBody Post post){
        return ResponseEntity.ok(postService.addPost(post));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAll(){
        return ResponseEntity.ok(postService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable String id){
        postService.deletePost(id);
        return ResponseEntity.ok().body(true);
    }
}
