package bjpn.dao;

import bjpn.bean.User;



public interface UserDao {
    //登录方法
    User loginUser(String useode, String userpwd);

}
