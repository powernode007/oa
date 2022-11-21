package bjpn.servlet;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//验证码功能
@WebServlet("/code")
public class CodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(80, 40, 4, 5);
        String code = captcha.getCode();
        System.out.println("code = " + code);
        HttpSession session = req.getSession();
        session.setAttribute("code", code);

        captcha.write(resp.getOutputStream());
    }
}
