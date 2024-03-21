package com.wzj.web;

import com.wzj.pojo.User;
import com.wzj.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user1 = userService.getUser(username,password);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(user1==null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            boolean flag = userService.register(user);
            if(flag){
                writer.write("code:200,meg:注册成功");
            }else{
                writer.write("code:404,meg:登陆失败");
            }
        }else{
            writer.write("code:200,meg:登陆成功");
        }
    }
}
