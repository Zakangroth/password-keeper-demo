package com.zakangroth.demo.dao;

import com.zakangroth.demo.core.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Project : password-keeper-demo
 * Created by Zakangroth on 30/10/2015.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @SuppressWarnings("unchecked")
    public User findByUsername(String username) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        return (User) crit.uniqueResult();
    }
}
