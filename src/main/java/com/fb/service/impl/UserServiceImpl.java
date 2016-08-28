package com.fb.service.impl;

import com.fb.dao.UserDao;
import com.fb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import com.fb.service.impl.UserService;
/**
 * Created by Administrator on 2016/7/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(User user){
        User u = new User();
        u = userDao.getUserById(user);
        return u;
    }

    public List<User> getUserList() {
        List<User> ul = new ArrayList<User>();
        ul = userDao.getUserList();
        return ul;
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void delUser(User user) {
        userDao.delUser(user);
    }
}
