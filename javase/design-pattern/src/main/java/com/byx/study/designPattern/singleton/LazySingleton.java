package com.byx.study.designPattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author wang zhen xing
 * @date 2020/12/4 13:51
 * 懒汉模式 调用方法时才创建
 */
public class LazySingleton implements Serializable {

    private static final long serialVersionUID = -4305636652692787108L;
    private static volatile LazySingleton instance;

    private LazySingleton() {
        // 防止反射攻击
        if (instance != null) {
            throw new RuntimeException("单例不允许多个实例！");
        }
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    // 防止反序列化破坏单例
    Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

}
