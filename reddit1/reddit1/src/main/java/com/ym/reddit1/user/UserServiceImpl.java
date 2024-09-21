package com.ym.reddit1.user;

import com.ym.reddit1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepo userRepo;

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
}
