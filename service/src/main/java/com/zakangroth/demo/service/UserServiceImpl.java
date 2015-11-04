package com.zakangroth.demo.service;

import com.zakangroth.demo.core.model.User;
import com.zakangroth.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Project : password-keeper-demo
 * Created by Zakangroth on 29/10/2015.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }
}
