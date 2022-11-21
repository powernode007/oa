package bjpn.dao;


import bjpn.bean.Dept;

import java.sql.Connection;
import java.util.List;

public interface DeptDao {
    //查询所有部门信息
    List<Dept> getAllDept(Connection conn);
}
