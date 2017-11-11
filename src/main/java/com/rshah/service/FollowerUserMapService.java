package com.rshah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rshah.jpa.FollowerUserMapRepository;

@Service
public class FollowerUserMapService {

    @Autowired
    FollowerUserMapRepository followerUserMapRepo;

    public FollowerUserMapService(FollowerUserMapRepository followerUserMapRepo) {
        this.followerUserMapRepo = followerUserMapRepo;
    }
}
