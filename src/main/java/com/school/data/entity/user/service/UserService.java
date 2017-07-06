package com.school.data.entity.user.service;


import com.school.data.entity.user.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
