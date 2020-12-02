package sym.common.dao.impl;

import sym.common.bean.User;
import sym.common.dao.UserDao;
import sym.inspur.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库连接类
 * 实现了数据库抽象类中的方法
 * 从数据库中取得数据并进行校验并返回到service层
 */
public class UserDaoImpl implements UserDao {
    //初始化
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    /**
     * 增加用户方法
     *
     * @param username 用户名
     * @param password 密码
     * @param phone    手机号
     * @param sex      性别
     * @param birthday 生日
     * @param age      年龄
     * @return result
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public int addUser(String username, String password, String phone, String sex, String birthday, String age) throws ClassNotFoundException {
        int result = 0;

        //连接数据库
        conn = ConnectionPool.getConn();
        //初始化sql语句
        String sql = "insert into user (username,password,phone,sex,birthday,age) values(?,?,?,?,?,?)";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, phone);
            stmt.setString(4, sex);
            stmt.setString(5, birthday);
            stmt.setString(6, age);

            //提交
            stmt.executeUpdate();
            result = 1;
            System.out.println("注册成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return result;
    }

    /**
     * 删除用户方法
     *
     * @param username 用户名
     * @return result
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public int dropUser(String username) throws ClassNotFoundException {
        int result = 0;
        conn = ConnectionPool.getConn();
        String sql = "delete from user where username = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.executeUpdate();
            result = 1;
            System.out.println("删除成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return result;
    }

    /**
     * 更改用户方法
     *
     * @param username 用户名
     * @param password 密码
     * @param phone    手机号
     * @param sex      性别
     * @param birthday 生日
     * @param age      年龄
     * @return result
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public int changeUser(String username, String password, String phone, String sex, String birthday, String age) throws ClassNotFoundException {
        int result = 0;
        conn = ConnectionPool.getConn();
        String sql = "update user set password = ?, sex = ?, phone = ?, birthday = ?, age = ? where username = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, password);
            stmt.setString(2, sex);
            stmt.setString(3, phone);
            stmt.setString(4, birthday);
            stmt.setString(5, age);
            stmt.setString(6, username);
            stmt.executeUpdate();
            result = 1;
            System.out.println("更改成功");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return result;
    }

    /**
     * 查找用户方法
     *
     * @param username 用户名
     * @param password 密码
     * @return result
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public int findUser(String username, String password) throws ClassNotFoundException {

        int result = 0;
        conn = ConnectionPool.getConn();
        String sql = "select *from user";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    result = 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return result;
    }

    /**
     * 查找用户方法
     *
     * @param username 用户名
     * @return result
     * @throws ClassNotFoundException 类空异常
     */
    public int findUser(String username) throws ClassNotFoundException {

        int result = 0;
        conn = ConnectionPool.getConn();
        String sql = "select *from user";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (username.equals(rs.getString("username"))) {
                    result = 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return result;
    }

    /**
     * 显示用户方法
     *
     * @param username 用户名
     * @param password 密码
     * @return User
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public User show(String username, String password) throws ClassNotFoundException {
        conn = ConnectionPool.getConn();
        String sql = "select *from user";
        User user = new User();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    String sex = rs.getString("sex");
                    String phone = rs.getString("phone");
                    String birthday = rs.getString("birthday");
                    int age = rs.getInt("age");

                    user.setUsername(username);
                    user.setPassword(password);
                    user.setSex(sex);
                    user.setPhone(phone);
                    user.setBirthday(birthday);
                    user.setAge(age);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return user;
    }

    /**
     * 查看所有用户方法
     *
     * @return List<User>
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public List<User> showAll() throws ClassNotFoundException {
        List<User> users = new ArrayList<>();
        conn = ConnectionPool.getConn();
        String sql = "select *from user";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setSex(rs.getString(3));
                user.setPhone(rs.getString(4));
                String birthday = rs.getString(5);
                user.setBirthday(birthday);
                user.setAge(rs.getInt(6));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return users;
    }
}
