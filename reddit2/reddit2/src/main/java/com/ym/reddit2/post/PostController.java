package com.ym.reddit2.post;

import com.ym.reddit2.models.Comment;
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
    @Autowired
    CommentService commentService;



    @PostMapping("/create")
    public ResponseEntity<Boolean> createPost(@RequestBody Post post){
        return ResponseEntity.ok(postService.addPost(post));
    }

    @PostMapping("/addComment")
    public ResponseEntity<?> addComment(@RequestBody Comment comment){
        commentService.addUserComment(comment);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getComments/{id}")
    public ResponseEntity<?> getComments(@PathVariable String id){
        return ResponseEntity.ok(commentService.getCommentsOnPost(id));
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
