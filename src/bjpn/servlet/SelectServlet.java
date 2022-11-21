package bjpn.servlet;

import bjpn.bean.Dept;
import bjpn.bean.Emp;
import bjpn.service.DeptService;
import bjpn.service.EmpService;
import bjpn.service.impl.DeptServiceImpl;
import bjpn.service.impl.EmpServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        DeptService deptService = new DeptServiceImpl();
        List<Dept> deptList = deptService.findAllDeptService();
        String jsonStr = JSON.toJSONString(deptList);
        response.getWriter().write(jsonStr);
    }
}
