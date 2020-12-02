package plugin.common.dao;

import plugin.common.bean.plugin;

import java.util.List;

/**
 * 数据库抽象类
 */
public interface PluginDao {
    int addPlugin(String name, String type, String date, int price, String author) throws ClassNotFoundException;

    int dropPlugin(String name) throws ClassNotFoundException;

    int changePlugin(String oldName, String name, String type, String changeDate, int price, String author) throws ClassNotFoundException;

    plugin findPlugin(String name) throws ClassNotFoundException;

    List<plugin> showAll() throws ClassNotFoundException;
}
