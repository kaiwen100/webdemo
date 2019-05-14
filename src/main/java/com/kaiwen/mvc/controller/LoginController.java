package com.kaiwen.mvc.controller;

import com.kaiwen.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kaiwen
 * @create 2019-05-14 16:22
 * @since 1.0
 **/
@Controller
@RequestMapping
public class LoginController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/login")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("进入Login页面");
        response.sendRedirect("login.jsp"); // 跳转页面
    }

    @RequestMapping("/doLogin")
    public void doLogin(@RequestParam("userName") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService.checkPassword(username,password);
        request.getSession().setAttribute("userName",username);
        request.getSession().setAttribute("password",password);
        // 跳转主页
        request.getRequestDispatcher("main.jsp").forward(request,response);

    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
