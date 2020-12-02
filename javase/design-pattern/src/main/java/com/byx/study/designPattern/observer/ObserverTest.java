package com.byx.study.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wang zhen xing
 * @date 2020/11/27 13:26
 * 观察者模式
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Task1 task1 = new Task1();
        subject.add(task1);
        Task2 task2 = new Task2();
        subject.add(task2);

        subject.notifyObserver("xxxx ");
        System.out.println("--------------------");
        subject.remove(task1);
        subject.notifyObserver("yyyy");

    }

}

class Subject {
    private List<Observer> container = new ArrayList<>();

    public void add(Observer observer) {
        container.add(observer);
    }

    public void remove(Observer observer) {
        container.remove(observer);
    }

    public void notifyObserver(Object object) {
        for (Observer item : container) {
            item.update(object);
        }
    }

}

interface Observer {
    void update(Object object);
}

class Task1 implements Observer {
    @Override
    public void update(Object object) {
        System.out.println("Task1 received: " + object);
    }
}

class Task2 implements Observer {
    @Override
    public void update(Object object) {
        System.out.println("Task2 received: " + object);
    }
}

class Task3 implements Observer {
    @Override
    public void update(Object object) {
        System.out.println("Task3 received: " + object);
    }
}