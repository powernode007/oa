package bjpn.dao.impl;

import bjpn.bean.Emp;
import bjpn.bean.User;
import bjpn.dao.EmpDao;
import bjpn.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public boolean addEmp(Connection conn, Emp emp) {
        PreparedStatement psta = null;
        try {
            String sql = "insert into emp (emp_name,emp_job,emp_photo,emp_hiredate,emp_sal,dept_no) values(?,?,?,?,?,?)";
            psta = conn.prepareStatement(sql);
            psta.setString(1, emp.getName());
            psta.setString(2, emp.getJob());
            psta.setString(3, emp.getPhoto());
            psta.setString(4, emp.getHiredate());
            psta.setString(5, emp.getSal());
            psta.setString(6, emp.getDeptno());
            int i = psta.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePsta(psta);
        }

        return false;

    }

    @Override
    public List<Emp> showEmp() {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            List<Emp> list = new ArrayList<>();
            conn = DBUtil.getConn();
            String sql = "select * from emp";
            psta = conn.prepareStatement(sql);
            System.out.println("查询执行的sql:" + psta);
            resultSet = psta.executeQuery();
            while (resultSet.next()) {
                Emp emp = new Emp();
//                user.setUserid(userid);
//                user.setUsername(username);
//                user.setUsercode(usercode);
//                user.setUserpwd(userpwd);
                emp.setEmpno(resultSet.getInt(1));
                emp.setName(resultSet.getString(2));
                emp.setJob(resultSet.getString(3));
                emp.setPhoto(resultSet.getString(4));
                emp.setHiredate(resultSet.getString(5));
                emp.setSal(resultSet.getString(6));
                emp.setDeptno(resultSet.getString(7));
                list.add(emp);

            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePsta(psta);
            DBUtil.closeConn(conn);

        }
        return null;
    }
}
