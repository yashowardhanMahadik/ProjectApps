package com.ym.reddit2.post;

import com.mongodb.DuplicateKeyException;
import com.ym.reddit2.Exception.DuplicateCommentException;
import com.ym.reddit2.Exception.PostNotFoundException;
import com.ym.reddit2.Exception.UserNotFoundException;
import com.ym.reddit2.models.Comment;
import com.ym.reddit2.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        System.out.println("USer id is : "+comment.getUserId());
        if(!postOb.checkUserExist(Integer.parseInt(comment.getUserId()))){
            throw new UserNotFoundException("User id "+comment.getUserId()+" does not exist");
        }
        try {
            commentRepo.save(comment);
        }catch (DuplicateKeyException e){
            throw new DuplicateCommentException("UserId and postId same, comment already exists");
        }
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

    public Page<Comment> getPaginatedProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return commentRepo.findAll(pageable);
    }
}
