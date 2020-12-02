package plugin.common.dao.impl;

import plugin.common.bean.plugin;
import plugin.common.dao.PluginDao;
import sym.inspur.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库连接类
 * 实现了数据库抽象类中的方法
 * 从数据库中取得数据并进行校验并返回到service层
 */
public class PluginDaoImpl implements PluginDao {

    //初始化
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    /**
     * 增加插件方法
     *
     * @param name       插件名称
     * @param type       插件种类
     * @param changeDate 更新日期
     * @param price      价格
     * @param author     作者
     * @return result
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public int addPlugin(String name, String type, String changeDate, int price, String author) throws ClassNotFoundException {
        int result = 0;
        //不确定
//        plugin plugin = new plugin();
//        plugin.setName(name);
        conn = ConnectionPool.getConn();
        String sql = "insert into plugin (pluginName,pluginType,changeDate,price,author) values(?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.setString(3, changeDate);
            stmt.setInt(4, price);
            stmt.setString(5, author);
            stmt.executeUpdate();
            result = 1;
            System.out.println("添加成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return result;
    }

    /**
     * 删除插件方法
     *
     * @param name 插件名称
     * @return result
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public int dropPlugin(String name) throws ClassNotFoundException {
        int result = 0;
//        plugin plugin = new plugin();
//        plugin.setName(name);
        conn = ConnectionPool.getConn();
        String sql = "delete from plugin where pluginName = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
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
     * 查找插件方法
     *
     * @param name 插件名
     * @return plugin
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public plugin findPlugin(String name) throws ClassNotFoundException {
        plugin plugin = new plugin();
        plugin.setName(name);
        conn = ConnectionPool.getConn();
        String sql = "select *from plugin";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (name.equals(rs.getString("pluginName"))) {
                    plugin.setType(rs.getString("pluginType"));
                    plugin.setUpdate(rs.getDate("changeDate"));
                    plugin.setPrice(rs.getInt("price"));
                    plugin.setAuthor(rs.getString("author"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return plugin;
    }

    /**
     * 更新插件方法
     *
     * @param oldName    更新前插件名称
     * @param name       更新后插件名称
     * @param type       更新后插件种类
     * @param changeDate 更新后更新时间
     * @param price      更新后价格
     * @param author     更新后作者
     * @return result
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public int changePlugin(String oldName, String name, String type, String changeDate, int price, String author) throws ClassNotFoundException {
        int result = 0;
        conn = ConnectionPool.getConn();
        String sql = "update plugin set pluginName = ?, pluginType = ?, changeDate = ?, price = ?, author = ? where pluginName = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.setString(3, changeDate);
            stmt.setInt(4, price);
            stmt.setString(5, author);
            stmt.setString(6, oldName);
            stmt.executeUpdate();
            result = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return result;
    }

    /**
     * 查找所有插件方法
     *
     * @return List<plugin>
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public List<plugin> showAll() throws ClassNotFoundException {
        List<plugin> plugins = new ArrayList<>();
        conn = ConnectionPool.getConn();
        String sql = "select *from plugin";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                plugin plugin = new plugin();
                plugin.setName(rs.getString(1));
                plugin.setType(rs.getString(2));
                plugin.setUpdate(rs.getDate(3));
                plugin.setPrice(rs.getInt(4));
                plugin.setAuthor(rs.getString(5));
                plugins.add(plugin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.close(stmt, rs, conn);
        }
        return plugins;
    }

}
