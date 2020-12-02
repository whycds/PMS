package com.common.dao;
/**
 * 数据库抽象类
 */
public interface ManagerDao {
    int findManager(int key) throws ClassNotFoundException;

    int addManager(int secretKey) throws ClassNotFoundException;
}
