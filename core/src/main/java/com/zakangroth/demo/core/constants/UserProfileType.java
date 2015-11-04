package com.zakangroth.demo.core.constants;

/**
 * User accounts types.
 * Project : password-keeper-demo
 * Created by Zakangroth on 29/10/2015.
 */
public enum UserProfileType {
    USER("USER");

    String userProfileType;

    UserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType() {
        return userProfileType;
    }
}
