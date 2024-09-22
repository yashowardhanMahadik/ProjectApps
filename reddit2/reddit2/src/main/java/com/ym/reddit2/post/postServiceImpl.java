package com.ym.reddit2.post;

import com.ym.reddit2.Exception.SubredditNotFoundException;
import com.ym.reddit2.models.Post;
import com.ym.reddit2.models.PostByUser;
import com.ym.reddit2.repository.PostByUserRepository;
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
    PostByUserRepository postByUserRepo;

    @Autowired
    WebService ws;
    @Override
    public boolean addPost(Post post) {
        if(checkSubredditExist(post.getSubredditName())) {
            postRepository.insert(post);
            return true;
        }
        throw new SubredditNotFoundException("Subreddit not found in the DB");
    }

    public boolean checkPostExist(String postId){
        return postRepository.getPostById(postId) != null;
    }

    @Override
    public boolean checkUserExist(int id) {
        return ws.checkUserExist(id);
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

    @Override
    public boolean getAllPostsOfUser(String userId) {
        return false;
    }

    @Override
    public boolean addPostByUser(Post post, String userId) {
        if(checkSubredditExist(post.getSubredditName())) {
            postByUserRepo.insert(new PostByUser(userId,post.getPostId()));
            postRepository.insert(post);
            return true;
        }
        throw new SubredditNotFoundException("Subreddit not found in the DB");
    }
}
