package bjpn.service.impl;

import bjpn.bean.Emp;
import bjpn.dao.impl.EmpDaoImpl;
import bjpn.service.EmpService;
import bjpn.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDaoImpl empDao = new EmpDaoImpl();
    @Override
    public Boolean addEmpService(Emp emp) {

        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            conn.setAutoCommit(false);
            boolean b = empDao.addEmp(conn, emp);
            if (b) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Emp> showEmpService() {
        List<Emp> list = empDao.showEmp();
        return list;
    }
}
