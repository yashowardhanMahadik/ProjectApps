package com.ym.reddit2.post;

import com.ym.reddit2.models.Post;

import java.util.List;

public interface postService {
    public boolean addPost(Post post);
    public boolean deletePost(String postId);
    public List<Post> getAll();
    public boolean checkPostExist(String postId);
    public boolean checkUserExist(int postId);

    public boolean checkSubredditExist(String name);
    public boolean getAllPostsOfUser(String userId);

    public boolean addPostByUser(Post post, String userId);

    public List<Post> getFeed(String userId);
}
