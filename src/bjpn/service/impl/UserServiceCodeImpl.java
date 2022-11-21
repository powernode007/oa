package bjpn.service.impl;


import bjpn.dao.UserDao;
import bjpn.dao.impl.UserDaoImpl;
import bjpn.service.UserServiceCode;
import bjpn.util.Result;
import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpSession;

public class UserServiceCodeImpl implements UserServiceCode {
   private UserDao dao=new UserDaoImpl();



    //登录



    @Override
    public Result login(String code, HttpSession session) {
        String realCode = (String)session.getAttribute("code");
        Result result=null;
        if(!StrUtil.equals(code, realCode)){
            result = new Result("验证码错误", -1, null);

        }else{
            result = new Result(null);
        }

        return result;
    }

}
