package plugin.common.action.impl;

import plugin.common.action.PluginService;
import plugin.common.bean.plugin;
import plugin.common.dao.impl.PluginDaoImpl;

import java.util.List;

/**
 * service
 * 服务层
 * 实现了service接口
 * 返回到servlet控制器从数据库拿到的结果
 */
public class PluginServiceImpl implements PluginService {

    /**
     * 增加插件方法
     *
     * @param name       插件名称
     * @param type       插件种类
     * @param changeDate 更新日期
     * @param price      价格
     * @param author     作者
     * @return bool
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public boolean addPlugin(String name, String type, String changeDate, int price, String author) throws ClassNotFoundException {
        boolean bool = false;
        int result = new PluginDaoImpl().addPlugin(name, type, changeDate, price, author);
        if (result == 1) {
            bool = true;
        }
        return bool;
    }

    /**
     * 删除插件方法
     *
     * @param name 插件名称
     * @return bool
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public boolean dropPlugin(String name) throws ClassNotFoundException {
        boolean bool = false;
        int result = new PluginDaoImpl().dropPlugin(name);
        if (result == 1) {
            bool = true;
        }
        return bool;
    }

    /**
     * 更新插件方法
     *
     * @param oldName    更新前插件名称
     * @param name       更新后插件名称
     * @param type       更新后插件种类
     * @param changeData 更新后更新时间
     * @param price      更新后价格
     * @param author     更新后作者
     * @return bool
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public boolean changePlugin(String oldName, String name, String type, String changeData, int price, String author) throws ClassNotFoundException {
        boolean bool = false;
        int result = new PluginDaoImpl().changePlugin(oldName, name, type, changeData, price, author);
        if (result == 1) {
            bool = true;
        }
        return bool;
    }

    /**
     * 查找插件
     *
     * @param name 插件名称
     * @return plugin
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public plugin findPlugin(String name) throws ClassNotFoundException {
        return new PluginDaoImpl().findPlugin(name);
    }

    /**
     * 查找所有插件
     *
     * @return List<plugin>
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public List<plugin> showAll() throws ClassNotFoundException {
        return new PluginDaoImpl().showAll();
    }
}
