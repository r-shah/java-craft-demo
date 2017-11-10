package com.rshah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rshah.entity.User;
import com.rshah.jpa.UserRepository;

@Service
public class UserService {

    @Autowired    
    UserRepository userRepo;
    
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    public User save(User user) {
        return this.userRepo.save(user);
    }
}
