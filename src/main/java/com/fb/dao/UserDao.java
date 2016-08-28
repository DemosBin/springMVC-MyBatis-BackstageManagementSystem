package com.fb.dao;

import com.fb.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/7/20.
 */
@Repository
public interface UserDao {
    User getUserById(User user);
    List<User> getUserList();
    void updateUser(User user);
    void delUser(User user);
}
