package com.zakangroth.demo.dao;

import com.zakangroth.demo.core.model.User;
import org.springframework.stereotype.Repository;

/**
 * Project : password-keeper-demo
 * Created by Zakangroth on 30/10/2015.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public User findById(int id) {
        //TODO : A implémenter
        return null;
    }

    public User findByUsername(String username) {
        //TODO : A implémenter
        return null;
    }
}
