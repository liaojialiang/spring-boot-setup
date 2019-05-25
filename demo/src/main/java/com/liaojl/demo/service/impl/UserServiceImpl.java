package com.liaojl.demo.service.impl;

import com.liaojl.demo.entity.User;
import com.liaojl.demo.repository.UserRepostiory;
import com.liaojl.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liaojl
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepostiory userRepostiory;

    @Override
    public User getUser(Long id) {
        return userRepostiory.findById(id).orElseGet(User::new);
    }

    @Override
    public User addUser(User user) {
        return userRepostiory.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepostiory.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepostiory.deleteById(id);
    }
}
