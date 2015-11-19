package com.zakangroth.demo.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Project : password-keeper-demo
 * Created by Zakangroth on 28/10/2015.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * Redirect to a right page in case the user tries to change it manually
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    ModelAndView redirectOnLoginPage() {
        return new ModelAndView("redirect:home");
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String homePage(ModelMap homeModel) {
        homeModel.addAttribute("user", getUser());
        return "home";
    }

    /**
     * Get the username from security context
     *
     * @return
     */
    private String getUser() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
