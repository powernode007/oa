package bjpn.dao;

import bjpn.bean.Emp;
import bjpn.bean.User;

import java.sql.Connection;
import java.util.List;

public interface EmpDao  {
    boolean addEmp(Connection conn, Emp emp);
    //展示的方法
    List<Emp> showEmp();
}
