package com.ym.reddit2.post;

import com.ym.reddit2.models.Comment;
import com.ym.reddit2.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;
    @Override
    public void addUserComment(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void deleteUserComment(String userId, String postId) {
        //
    }

    @Override
    public List<Comment> getCommentsOnPost(String postId) {
        return commentRepo.findAll(postId);
    }
}
