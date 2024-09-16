package com.ym.reddit2.post;

import com.ym.reddit2.models.Post;
import com.ym.reddit2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class postServiceImpl implements postService{
    @Autowired
    PostRepository postRepository;
    @Override
    public boolean addPost(Post post) {
        postRepository.insert(post);
        return true;
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
}
