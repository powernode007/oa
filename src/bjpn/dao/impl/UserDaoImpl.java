package bjpn.dao.impl;






import bjpn.bean.User;
import bjpn.dao.UserDao;
import bjpn.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    //登录
    @Override
    public User loginUser(String usercode, String userpwd) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select * from login where usercode=? and userpwd=?";
            psta = conn.prepareStatement(sql);
            psta.setString(1, usercode);
            psta.setString(2, userpwd);
            resultSet = psta.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserid(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setUsercode(resultSet.getString(3));
                user.setUserpwd(resultSet.getString(4));
                user.setUserphoto(resultSet.getString(5));
                return user;
            }
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
