package com.ym.reddit2.post;

import com.ym.reddit2.models.Post;

import java.util.List;

public interface postService {
    public boolean addPost(Post post);
    public boolean deletePost(String postId);
    public List<Post> getAll();
}
