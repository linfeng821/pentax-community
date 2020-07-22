package com.pentax.community.service;

import com.pentax.community.dao.UserMapper;
import com.pentax.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper  userMapper;

    public User findUserById(int id) {
      return   userMapper.selectById(id);
    }
}
