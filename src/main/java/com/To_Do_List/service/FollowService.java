package com.To_Do_List.service;

import com.To_Do_List.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

    private final FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository){
        this.followRepository = followRepository;
    }


}
