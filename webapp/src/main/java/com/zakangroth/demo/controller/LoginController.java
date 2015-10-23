package com.zakangroth.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Project : password-keeper-demo
 * Created by Zakangroth on 23/10/2015.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    /**
     * Redirect to a right page in case the user tries to change it manually
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    ModelAndView redirectOnLoginPage() {
        return new ModelAndView("redirect:/login");
    }

    /**
     * See login page
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    String viewPage() {
        return "login";
    }
}
