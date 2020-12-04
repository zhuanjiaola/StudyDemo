package com.byx.study.designPattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author wang zhen xing
 * @date 2020/12/4 14:01
 * 饿汉模式 类加载后进行实例化
 */
public class HungrySingleton implements Serializable {

    private static final long serialVersionUID = 2461063811474478878L;
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        // 防止反射攻击
        if (instance != null) {
            throw new RuntimeException("单例不允许多个实例！");
        }
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    // 防止反序列化破坏单例
    Object readResolve() throws ObjectStreamException {
        return instance;
    }

}
