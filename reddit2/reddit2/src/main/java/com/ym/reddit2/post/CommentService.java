package com.ym.reddit2.post;

import com.ym.reddit2.models.Comment;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {
    public void addUserComment(Comment comment);

    public void deleteUserComment(String userId, String postId);
    public List<Comment> getCommentsOnPost(String postId);

    Page<Comment> getPaginatedProducts(int page, int size);
}
