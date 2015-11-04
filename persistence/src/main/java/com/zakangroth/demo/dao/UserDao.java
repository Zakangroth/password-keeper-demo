package com.zakangroth.demo.dao;

import com.zakangroth.demo.core.model.User;

/**
 * Project : password-keeper-demo
 * Created by Zakangroth on 30/10/2015.
 */
public interface UserDao {
    User findById(int id);

    User findByUsername(String username);
}
