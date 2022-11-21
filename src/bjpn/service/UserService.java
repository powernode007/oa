package bjpn.service;


import bjpn.bean.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    User loginUserService(String usercode, String userpwd);
}
