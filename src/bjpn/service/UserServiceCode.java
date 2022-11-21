package bjpn.service;




import bjpn.util.Result;

import javax.servlet.http.HttpSession;


public interface UserServiceCode {
    Result login(String code, HttpSession session);

}
