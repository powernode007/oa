package bjpn.dao.impl;


import bjpn.bean.Dept;
import bjpn.dao.DeptDao;
import bjpn.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public List<Dept> getAllDept(Connection conn) {
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try{
            String sql = "select *  from dept";
            psta = conn.prepareStatement(sql);
            resultSet =psta.executeQuery();
            List<Dept> deptList = new ArrayList<>();
            while(resultSet.next()){
               Dept dept = new Dept();
               dept.setDeptNo(resultSet.getInt(1));
               dept.setDeptName(resultSet.getString(2));
               dept.setDeptLoc(resultSet.getString(3));
               deptList.add(dept);
            }
            return deptList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePsta(psta);
        }
        return null;
    }
}
