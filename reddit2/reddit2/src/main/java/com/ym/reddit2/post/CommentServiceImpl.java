package com.ym.reddit2.post;

import com.ym.reddit2.Exception.PostNotFoundException;
import com.ym.reddit2.models.Comment;
import com.ym.reddit2.repository.CommentRepo;
import com.ym.reddit2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    postService postOb;
    @Override
    public void addUserComment(Comment comment) {
        if(!postOb.checkPostExist(comment.getPostId())){
            throw new PostNotFoundException(comment.getPostId()+" does not exist");
        }
        commentRepo.save(comment);
    }

    @Override
    public void deleteUserComment(String userId, String postId) {
        //
    }

    @Override
    public List<Comment> getCommentsOnPost(String postId) {
        // check if post exist or not
        if(!postOb.checkPostExist(postId)){
            throw new PostNotFoundException(postId+" does not exist");
        }
        return commentRepo.findAll(postId);
    }
}
