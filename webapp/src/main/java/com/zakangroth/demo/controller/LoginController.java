package com.zakangroth.demo.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Project : password-keeper-demo
 * Created by Zakangroth on 23/10/2015.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    /**
     * Access login page
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }


    /**
     * User is logged out of spring security context.
     * Don't forget setInvalidateHttpSession(false) or localization cache will be lost.
     *
     * @param request
     * @param response
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
            securityContextLogoutHandler.setInvalidateHttpSession(false);
            securityContextLogoutHandler.logout(request, response, auth);
        }
        Locale locale = LocaleContextHolder.getLocale();
        return "redirect:/login?logout&lang=" + locale.toString();
    }
}
