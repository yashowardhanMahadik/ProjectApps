package com.ym.reddit2.post;

import com.ym.reddit2.models.Comment;
import com.ym.reddit2.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/post")
public class PostController {
    // check if the User present in the User table
        //for now just create a User document separately in mongoDB
    // check if the postId and userId exists or not and return the error accordingly

    @Autowired
    postService postService;
    @Autowired
    CommentService commentService;



    @PostMapping("/create")
    public ResponseEntity<Boolean> createPost(@RequestBody Post post){
            post.setTimestamp(Instant.now());
            return ResponseEntity.ok(postService.addPost(post));
    }
    @PostMapping("/createByUser")
    public ResponseEntity<Boolean> createPostByUser(@RequestBody Post post,
                                              @RequestParam(required = true,defaultValue = "Yashow") String userId){
        post.setTimestamp(Instant.now());
        return ResponseEntity.ok(postService.addPostByUser(post,userId));
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
    @GetMapping("/products")
    @ResponseBody
    public Page<Comment> getProducts(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        return commentService.getPaginatedProducts(page, size);
    }

    @GetMapping("/getFeed/{userId}")
    @ResponseBody
    public List<Post> getFeed(@PathVariable String userId){
        System.out.println("User id fetched : "+userId);
        return postService.getFeed(userId);
    }
    //todo: next step create postman collection and import it in the git hub, also set envs for docker and local separately

    //now implement the upvote and downvote functionalitygit
}
