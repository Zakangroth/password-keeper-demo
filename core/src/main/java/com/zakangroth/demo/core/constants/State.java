package com.zakangroth.demo.core.constants;

/**
 * User account state.
 * Project : password-keeper-demo
 * Created by Zakangroth on 29/10/2015.
 */
public enum State {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted"),
    LOCKED("Locked");

    private String state;

    State(final String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return this.state;
    }

    public String getName() {
        return this.name();
    }
}
