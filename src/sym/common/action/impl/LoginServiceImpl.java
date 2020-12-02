package sym.common.action.impl;

import sym.common.action.LoginService;
import sym.common.bean.User;
import sym.common.dao.impl.UserDaoImpl;

import java.util.List;

/**
 * service
 * 服务层
 * 实现了service接口
 * 返回到servlet控制器从数据库拿到的结果
 */
public class LoginServiceImpl implements LoginService {
    /**
     * 增加用户方法
     *
     * @param username 用户名
     * @param password 密码
     * @param phone    手机号
     * @param sex      性别
     * @param birthday 生日
     * @param age      年龄
     * @return bool
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public boolean addUser(String username, String password, String phone, String sex, String birthday, String age) throws ClassNotFoundException {
        boolean bool = false;
        int result = new UserDaoImpl().addUser(username, password, phone, sex, birthday, age);
        if (result == 1) {
            bool = true;
        }
        return bool;
    }

    /**
     * 删除用户方法
     *
     * @param username 用户名
     * @return bool
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public boolean dropUser(String username) throws ClassNotFoundException {
        boolean bool = false;
        int result = new UserDaoImpl().dropUser(username);
        if (result == 1) {
            bool = true;
        }
        return bool;
    }

    /**
     * 改变用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @param phone    手机号
     * @param sex      性别
     * @param birthday 生日
     * @param age      年龄
     * @return bool
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public boolean changeUser(String username, String password, String phone, String sex, String birthday, String age) throws ClassNotFoundException {
        boolean bool = false;
        int result = new UserDaoImpl().changeUser(username, password, phone, sex, birthday, age);
        if (result == 1) {
            bool = true;
        }
        return bool;
    }

    /**
     * 查找用户方法
     *
     * @param username 用户名
     * @param password 密码
     * @return bool
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public boolean findUser(String username, String password) throws ClassNotFoundException {
        boolean bool = false;
        int result = new UserDaoImpl().findUser(username, password);
        if (result == 1) {
            bool = true;
        }
        return bool;
    }


    /**
     * 查找用户方法
     *
     * @param username 用户名
     * @return bool
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public boolean findUser(String username) throws ClassNotFoundException {
        boolean bool = false;
        int result = new UserDaoImpl().findUser(username);
        if (result == 1) {
            bool = true;
        }
        return bool;
    }

    /**
     * 展示用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return User
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public User showMessage(String username, String password) throws ClassNotFoundException {
        return new UserDaoImpl().show(username, password);
    }

    /**
     * 展示所有用户
     *
     * @return List<User>
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public List<User> showAll() throws ClassNotFoundException {
        return new UserDaoImpl().showAll();
    }
}
