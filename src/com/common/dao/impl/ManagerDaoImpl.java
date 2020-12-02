package com.common.dao.impl;

import com.common.dao.ManagerDao;
import sym.inspur.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接类
 * 实现了数据库抽象类中的方法
 * 从数据库中取得数据并进行校验并返回到service层
 */
public class ManagerDaoImpl implements ManagerDao {
    //初始化
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    /**
     * 查找管理员方法
     *
     * @param key 管理员密钥
     * @return result
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public int findManager(int key) throws ClassNotFoundException {
        int result = 0;
        conn = ConnectionPool.getConn();
        String sql = "select *from manager";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (key == rs.getInt("secretKey")) {
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
     * 查找管理员方法
     *
     * @param secretKey 管理员密码
     * @return result
     * @throws ClassNotFoundException 类空异常
     */
    public int addManager(int secretKey) throws ClassNotFoundException {

        int result = 0;
        conn = ConnectionPool.getConn();
        String sql = "insert into manager (secretKey) values(?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, secretKey);
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
}
