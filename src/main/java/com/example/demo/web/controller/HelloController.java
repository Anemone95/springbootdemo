package com.example.demo.web.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.web.vo.Message;
import com.example.demo.web.vo.UserVO;
import com.example.demo.wrapper.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @Autowired
    private UserWrapper userWrapper;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello")
    public String say(){
        return "Hello Spring Boot";
    }
    @RequestMapping(value = "/create")
    public Message create(@RequestBody UserVO userVO){
        User user = userWrapper.unwrapper(userVO);
        userService.create(user);
        return new Message<>(user,200);
    }
    @RequestMapping(value = "/login/{username}")
    public Message login(HttpServletRequest request, @PathVariable("username")String username){
        HttpSession session=request.getSession();
        User user = userService.findByUsername(username);
        UserVO userVO=userWrapper.wrapper(user);
        session.setAttribute("User", userVO);
        return new Message<>(user,200);
    }
    @RequestMapping(value = "/getcookie")
    public Message getcookie(HttpServletRequest request){
        HttpSession session=request.getSession();
        UserVO userVo= (UserVO) session.getAttribute("User");
        return new Message<>(userVo,200);
    }
}
