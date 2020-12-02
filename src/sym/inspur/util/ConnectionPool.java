package sym.inspur.util;

import java.sql.*;

/**
 * @author why
 * @Desc 链接数据库关闭数据库公共类
 */
public class ConnectionPool {
    //注册驱动
    static String driver = "com.mysql.cj.jdbc.Driver";
    //连接数据库url
    static String url = "jdbc:mysql://localhost:3306/PMS?serverTimezone=UTC";
    //用户名
    static String username = "root";
    //密码
    static String password = "!Why2803261838";
    //创建数据库连接对象
    private static Connection conn;

    /**
     * 连接数据库
     *
     * @return conn
     */
    public static Connection getConn() throws ClassNotFoundException {
        try {
            Class.forName(driver);
            if (conn == null || conn.isClosed()) {
                //实例化连接对象
                conn = DriverManager.getConnection(url, username, password);
            }
            if (conn != null) {
                System.out.println("Connect database success");
            } else {
                System.out.println("Connect database fail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库
     *
     * @param stmt
     * @param conn
     */
    public static void close(PreparedStatement stmt, Connection conn) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库
     *
     * @param stmt
     * @param rs
     * @param conn
     */
    public static void close(PreparedStatement stmt, ResultSet rs, Connection conn) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
