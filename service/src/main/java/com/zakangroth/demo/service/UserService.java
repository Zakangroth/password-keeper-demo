package com.zakangroth.demo.service;

import com.zakangroth.demo.core.model.User;

/**
 * Project : password-keeper-demo
 * Created by Zakangroth on 29/10/2015.
 */
public interface UserService {
    User findByUsername(String username);
}
