package bjpn.servlet;


import bjpn.bean.User;
import bjpn.service.UserService;
import bjpn.service.impl.UserServiceCodeImpl;
import bjpn.service.impl.UserServiceImpl;
import bjpn.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String usercode = req.getParameter("userCode");
        String userpwd = req.getParameter("userPwd");
        String code = req.getParameter("code");
        String check = req.getParameter("loginCheck");
        boolean loginCheck = Boolean.parseBoolean(check);

        UserServiceCodeImpl userServiceCode = new UserServiceCodeImpl();
        Result result = userServiceCode.login(code, req.getSession());

        UserService userService = new UserServiceImpl();
        User user = userService.loginUserService(usercode, userpwd);
        if (result.getCode() == -1) {
            req.setAttribute("codeError", "验证码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
//            resp.getWriter().write("验证码错误");
        } else {
            if (user != null) {
                if (loginCheck) {
                    Cookie loginCookie = new Cookie("loginCode", usercode);
                    Cookie pwdCookie = new Cookie("loginPwd", userpwd);
                    loginCookie.setMaxAge(60 * 60 * 24 * 14);
                    pwdCookie.setMaxAge(60 * 60 * 24 * 14);
                    loginCookie.setPath("/");
                    pwdCookie.setPath("/");
                    resp.addCookie(loginCookie);
                    resp.addCookie(pwdCookie);
                } else {
                    Cookie loginCookie = new Cookie("loginCode", usercode);
                    Cookie pwdCookie = new Cookie("loginPwd", userpwd);
                    loginCookie.setMaxAge(0);
                    pwdCookie.setMaxAge(0);
                    //将web设置为cookie根路径，web下的应用都能共享cookie
                    loginCookie.setPath("/");
                    pwdCookie.setPath("/");
                    resp.addCookie(loginCookie);
                    resp.addCookie(pwdCookie);
                }

                req.getSession().setAttribute("user", user);
                resp.getWriter().write("ok");


            } else {
                resp.getWriter().write("账号或密码错误");
            }
        }

    }
}
