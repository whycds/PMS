package com.common.action.impl;

import com.common.action.ManagerLoginService;
import com.common.dao.impl.ManagerDaoImpl;

/**
 * service
 * 服务层
 * 实现了service接口
 * 返回到servlet控制器从数据库拿到的结果
 */
public class ManagerLoginServiceImpl implements ManagerLoginService {
    /**
     * 查找管理员方法
     *
     * @param key 管理员密钥
     * @return bool
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public boolean findManager(int key) throws ClassNotFoundException {
        boolean bool = false;
        int result = new ManagerDaoImpl().findManager(key);
        if (result == 1) {
            bool = true;
        }
        return bool;
    }

    /**
     * 管理员添加方法
     *
     * @param key 管理员密钥
     * @return bool
     * @throws ClassNotFoundException 类空异常
     */
    @Override
    public boolean addManager(int key) throws ClassNotFoundException {
        boolean bool = false;
        int result = new ManagerDaoImpl().addManager(key);
        if (result == 1) {
            bool = true;
        }
        return bool;
    }
}
