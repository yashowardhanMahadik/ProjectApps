package com.ym.reddit2.post;

import com.ym.reddit2.Exception.SubredditNotFoundException;
import com.ym.reddit2.models.Post;
import com.ym.reddit2.repository.PostRepository;
import com.ym.reddit2.ws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class postServiceImpl implements postService{
    @Autowired
    PostRepository postRepository;

    @Autowired
    WebService ws;
    @Override
    public boolean addPost(Post post) {
        if(checkSubredditExist(post.getSubredditName())) {
            postRepository.insert(post);
        }
        throw new SubredditNotFoundException("Subreddit not found in the DB");
    }

    public boolean checkPostExist(String postId){
        return postRepository.getPostById(postId) != null;
    }

    @Override
    public boolean deletePost(String postId) {
        postRepository.deleteById(postId);
        return true;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }
    public boolean checkSubredditExist(String name){
        return ws.checkSubredditExist(name);
    }
}
