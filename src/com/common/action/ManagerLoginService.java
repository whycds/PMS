package com.common.action;

/**
 * service抽象类
 */
public interface ManagerLoginService {
    boolean findManager(int key) throws ClassNotFoundException;

    boolean addManager(int key) throws ClassNotFoundException;
}
