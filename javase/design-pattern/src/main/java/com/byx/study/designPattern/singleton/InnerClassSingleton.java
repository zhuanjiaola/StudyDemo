package com.byx.study.designPattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author wang zhen xing
 * @date 2020/12/4 14:06
 * 静态内部类的方法 也属于懒加载机制
 * 利用 JVM 类加载机制 来保证线程安全
 */
public class InnerClassSingleton implements Serializable {

    private static final long serialVersionUID = -5543902001068530677L;

    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        // 防止反射攻击
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单例不允许多个实例！");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

    // 防止反序列化破坏单例
    Object readResolve() throws ObjectStreamException {
        return InnerClassHolder.instance;
    }


}
