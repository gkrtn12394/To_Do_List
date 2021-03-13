package com.To_Do_List.repository;

import com.To_Do_List.domain.Follow;

import java.util.List;
import java.util.Optional;

public interface FollowRepository {
    Follow save(Follow follow);
    Optional<Follow> findById(long id);
    Optional<Follow> findByName(String name);
    void updateById(long id, Follow follow);
    List<Follow> findAll();
}
