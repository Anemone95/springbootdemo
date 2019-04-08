package com.example.demo.wrapper;

import com.example.demo.entity.User;
import com.example.demo.web.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserWrapper {
    public User unwrapper(UserVO userVO){
        User user=new User();
        user.setUsername(userVO.getUsername());
        user.setPassword(userVO.getPassword());
        return user;
    }
    public UserVO wrapper(User user){
        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return userVO;
    }
}
