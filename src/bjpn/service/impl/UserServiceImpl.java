package bjpn.service.impl;


import bjpn.bean.User;
import bjpn.dao.UserDao;
import bjpn.dao.impl.UserDaoImpl;
import bjpn.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User loginUserService(String usercode, String userpwd) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.loginUser(usercode, userpwd);
        return user;
    }
}
