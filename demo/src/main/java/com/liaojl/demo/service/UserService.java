package com.liaojl.demo.service;

import com.liaojl.demo.entity.User;

/**
 * @author liaojl
 */
public interface UserService {
    User getUser(Long id);

    User addUser(User user);

    User updateUser(User user);

    void delete(Long id);
}
