package plugin.common.action;

import plugin.common.bean.plugin;

import java.util.List;

/**
 * service抽象类
 */
public interface PluginService {
    boolean addPlugin(String name, String type, String date, int price, String author) throws ClassNotFoundException;

    boolean dropPlugin(String name) throws ClassNotFoundException;

    boolean changePlugin(String oldName, String name, String type, String changeDate, int price, String author) throws ClassNotFoundException;

    plugin findPlugin(String name) throws ClassNotFoundException;

    List<plugin> showAll() throws ClassNotFoundException;
}
