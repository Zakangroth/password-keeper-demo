package com.zakangroth.demo.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * This configuration creates a Servlet Filter known as the springSecurityFilterChain which is responsible for all
 * the security
 * (protecting the application URLs, validating submitted username and passwords, redirecting to the log in form, etc)
 * within the application.
 * <p/>
 * Project : password-keeper-demo
 * Created by Zakangroth on 28/10/2015.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {


    /**
     * We are using UserDetailService implementations for database-authentication.
     */
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    /**
     * Configures AuthenticationManagerBuilder with user credentials and allowed roles.
     * This AuthenticationManagerBuilder creates AuthenticationManager which is responsible for processing any
     * authentication request.
     *
     * @param auth
     *
     * @throws Exception
     */
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * Configures HttpSecurity which allows configuring web based security for specific http requests.
     * By default it will be applied to all requests, but can be restricted using requestMatcher
     *
     * @param http
     *
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
            In above configuration, we say that URL �/� is not secured, anyone can access it.
            URL �/home/**� can only be accessed by someone who has USER role.
            This code creates a custom login page with �/login� url, which will accept ssoId as username and password
            Http request parameters.
            We have also shown a call to csrf() which is optional as it is by default active in Spring. It is a
            Cross-site request forgery protection.
            We have also used exceptionHandling().accessDeniedPage() which in this case will catch all 403
            [http access denied] exceptions and display our user defined page instead
         */
        http.authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/home/**").access("hasRole('USER')")
                .and().formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .and().csrf();
    }
}
