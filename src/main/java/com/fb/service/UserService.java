package com.fb.service.impl;

import com.fb.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/7/20.
 */
public interface UserService {
    public User getUserById(User user);
    public List<User> getUserList();
    public void updateUser(User user);
    public void delUser(User user);
}

