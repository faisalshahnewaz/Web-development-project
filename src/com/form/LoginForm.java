package com.form;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Xuesong Zhang (Andrew ID: xuesongz)
 */
public class LoginForm {
    private String username;
    private String password;
    private String action;

    public LoginForm(HttpServletRequest request) {
    	username = request.getParameter("username");
        password = request.getParameter("password");
        action = request.getParameter("action");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAction() {
        return action;
    }

    public boolean isPresent() {
        return action != null;
    }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (username.trim() == null || username.trim().length() == 0)
            errors.add("Email is required");
        if (password == null || password.length() == 0)
            errors.add("Password is required");
        if (action == null)
            errors.add("Button is required");

        if (errors.size() > 0)
            return errors;

        if (!action.equals("Login") && !action.equals("Register"))
            errors.add("Invalid button");
        if (username.matches(".*[<>\"].*"))
            errors.add("Email may not contain angle brackets or quotes");

        return errors;
    }
}
