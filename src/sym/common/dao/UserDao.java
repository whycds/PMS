package sym.common.dao;

import sym.common.bean.User;

import java.util.List;

/**
 * 数据库抽象类
 */
public interface UserDao {
    int addUser(String username, String password, String phone, String sex, String birthday, String age) throws ClassNotFoundException;

    int dropUser(String username) throws ClassNotFoundException;

    int changeUser(String username, String password, String phone, String sex, String birthday, String age) throws ClassNotFoundException;

    int findUser(String username, String password) throws ClassNotFoundException;

    int findUser(String username) throws ClassNotFoundException;

    User show(String username, String password) throws ClassNotFoundException;

    List<User> showAll() throws ClassNotFoundException;
}
