package com.ym.reddit1.user;

import com.ym.reddit1.models.Follower;
import com.ym.reddit1.models.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {
    Logger logger;

    @Autowired
    UserRepo userRepo;
    @Autowired
    FollowerRepo followerRepo;

    public boolean createUser(User user){
        userRepo.save(user);
        return true;
    }

    public Page<User> getAllUsers(int pageNumber,int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return userRepo.findAll(pageable);
    }

    public User getUserById(int id){
        return userRepo.findByUserId(id);
    }

    public boolean followUser(String userId, String followerId){
        followerRepo.save(new Follower(userId,followerId));
        return true;
    }

    public List<String> getFollowingUser(String userId) {
        List<Follower> followingUserList = followerRepo.getFollowingUserList(userId);
        System.out.println("sout Folllowing user list is ");
        followingUserList.stream().forEach(System.out::println);
        List<String> stringList = followingUserList.stream().map(follower -> follower.getUserId()).collect(Collectors.toList());
        return stringList;
    }
}
