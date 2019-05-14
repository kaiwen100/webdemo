package com.kaiwen.mvc.service;

import org.springframework.stereotype.Service;

/**
 * @author kaiwen
 * @create 2019-05-14 16:30
 * @since 1.0
 **/
@Service
public class UserService {

    public void checkPassword (String username, String password) {
        System.out.println("调用了密码校验的方法:" + username + "  >>> " + password);
    }
}
