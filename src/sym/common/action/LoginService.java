package sym.common.action;

import sym.common.bean.User;

import java.util.List;

/**
 * service抽象类
 */
public interface LoginService {
    boolean addUser(String username, String password, String phone, String sex, String birthday, String age) throws ClassNotFoundException;

    boolean dropUser(String username) throws ClassNotFoundException;

    boolean changeUser(String username, String password, String phone, String sex, String birthday, String age) throws ClassNotFoundException;

    boolean findUser(String username, String password) throws ClassNotFoundException;

    boolean findUser(String username) throws ClassNotFoundException;

    User showMessage(String username, String password) throws ClassNotFoundException;

    List<User> showAll() throws ClassNotFoundException;
}
