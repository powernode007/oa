package bjpn.service.impl;


import bjpn.bean.Dept;
import bjpn.dao.DeptDao;
import bjpn.dao.impl.DeptDaoImpl;
import bjpn.service.DeptService;
import bjpn.util.DBUtil;

import java.sql.Connection;
import java.util.List;

public class DeptServiceImpl implements DeptService {
    DeptDao deptDao = new DeptDaoImpl();
    @Override
    public List<Dept> findAllDeptService() {
        Connection conn = null;
        try{
            conn = DBUtil.getConn();
            List<Dept> deptList = deptDao.getAllDept(conn);
            return deptList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
        return null;
    }
}
