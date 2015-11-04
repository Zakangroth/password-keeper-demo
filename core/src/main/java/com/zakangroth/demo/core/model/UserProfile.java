package com.zakangroth.demo.core.model;

import com.zakangroth.demo.core.constants.UserProfileType;

import javax.persistence.*;

/**
 * Project : password-keeper-demo
 * Created by Zakangroth on 29/10/2015.
 */
@Entity
@Table(name = "USER_PROFILE")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TYPE", length = 15, unique = true, nullable = false)
    private String type = UserProfileType.USER.getUserProfileType();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        if (id != that.id) return false;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
