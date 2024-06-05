package com.gaurav.springboot.learnwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

// Before Spring Security we used this
//
//@Controller
//@SessionAttributes("username")
//public class LoginController {
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    private final AuthenticationService authenticationService;
//
//    public LoginController(AuthenticationService authenticationService){
//        this.authenticationService = authenticationService;
//    }
//
//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String doLogin(){
//        return "login";
//    }
//
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String goToTodosPage(@RequestParam String username, @RequestParam String password,
//                                ModelMap model){
//        if(authenticationService.isValidUser(username, password)){
//            model.put("username", username);
//            model.put("password", password);
//            return "welcome";
//        }else{
//            model.put("error", "Invalid Credentials");
//            return "login";
//        }
//    }
//}
