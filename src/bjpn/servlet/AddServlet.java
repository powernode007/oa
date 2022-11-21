package bjpn.servlet;

import bjpn.bean.Emp;
import bjpn.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/add")
@MultipartConfig
public class AddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//接收参数
        String ename = req.getParameter("ename");
        String job = req.getParameter("job");
        String sal = req.getParameter("sal");
        String empHiredate = req.getParameter("empHiredate");
        String upImg = req.getParameter("upImg");
        String deptno = req.getParameter("deptno");
        //调用函数
        String fileName = upload(req, resp);
    //数据库连接
        EmpServiceImpl empService = new EmpServiceImpl();
        Emp emp = new Emp();
        emp.setName(ename);
        emp.setJob(job);
        emp.setSal(sal);
        emp.setHiredate(empHiredate);
        emp.setPhoto(upImg);
        emp.setDeptno(deptno);
        emp.setPhoto(fileName);

        Boolean b = empService.addEmpService(emp);

        if(b){
            //成功  跳转到显示页面  跳转到查询员工信息的处理器
            resp.sendRedirect("show");
        }else{
            req.setAttribute("saveError", "添加失败");
            req.getRequestDispatcher("pages/emp/addEmp.jsp").forward(req, resp);
        }


        //同步传输emp对象
//        req.setAttribute("emp",emp);
//        req.getRequestDispatcher("pages/main/index.jsp").forward(req, resp);

//        req.getSession().setAttribute("emp",emp);
//        resp.sendRedirect("show");
//        resp.sendRedirect("pages/main/index.jsp");

//        String jsonStr = JSON.toJSONString(emp);
//        PrintWriter writer = resp.getWriter();
//        if (b) {
//            writer.write(jsonStr);
//        } else {
//            writer.write("账号或密码错误");
//
//        }
//
//        writer.flush();
//        writer.close();
    }
    public String upload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part part = req.getPart("upImg");
        //获取键
        String name = part.getName();
        System.out.println("输入框的key = " + name);
        //获取值
        String oldFileName = part.getSubmittedFileName();
        System.out.println("源文件的名字 = " + oldFileName);
        //获取源文件名字的目的是为了得到文件后缀
        String fileTypeName = oldFileName.substring(oldFileName.lastIndexOf("."));
        //生成唯一字符串当做名字  UUID   时间戳
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + fileTypeName;
        System.out.println("文件的新名字 = " + fileName);
        //得到fileupload物理路径
        String path = req.getServletContext().getRealPath("/fileupload");
        System.out.println("上传文件物理路径 = " + path);
        part.write(path + "/" + fileName);
        System.out.println("上传成功");
//        req.setAttribute("fileName", fileName);
//        req.getRequestDispatcher("success.jsp").forward(req, resp);
        return fileName;

    }
}
