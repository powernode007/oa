package bjpn.servlet;

import bjpn.bean.Emp;
import bjpn.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        EmpServiceImpl empService = new EmpServiceImpl();
        List<Emp> list = empService.showEmpService();
        //业务还没结束
        if (list != null) {
            req.setAttribute("list", list);
            req.getRequestDispatcher("pages/emp/emp.jsp").forward(req, resp);
//            req.getSession().setAttribute("list", list);
//            resp.sendRedirect("pages/emp/emp.jsp");
        } else {
            req.setAttribute("listError", "程序出错");
            req.getRequestDispatcher("pages/main/index.jsp").forward(req, resp);
        }

    }
}
