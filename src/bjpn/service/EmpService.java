package bjpn.service;

import bjpn.bean.Emp;
import bjpn.bean.User;

import java.util.List;

public interface EmpService {
    Boolean addEmpService(Emp emp);
    //展示的方法
    List<Emp> showEmpService();
}
