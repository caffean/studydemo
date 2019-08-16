package com.example.nettydemo.designPatterns;

import java.util.Observable;
import java.util.Observer;

/**
 * @Classname ObserverDemo
 * @Description 观察者模式
 * 简单情形：有A、B、C、D等四个独立的对象，其中B、C、D这三个对象想在A对象发生改变的第一时间知道这种改变，以便做出相应的响应或者对策。
 * 观察者与被观察者也不是对立的，一个对象可以观察其他对象，也可以被其他对象观察。
 * 观察者模式需要用到的Java类
　　1. java.util.Observable
　　　　-able一般可能...的单词后缀，Observable就是可以被观察的，程序中的被观察者类，需要继承这个类。
　　2. java.util.Observer
　　　　这个是观察者，是接口。程序中的观察者类，需要实现这个接口中的update()方法。
 * @Date 2019/8/16 9:45
 * @Author lyn
 */
public class ObserverDemo {

    public static void main(String[] args) throws InterruptedException {
        NumObservable number = new NumObservable();    //被观察者对象
        number.addObserver(new NumObserver());    //给number这个被观察者添加观察者(当然可以有多个观察者)
        number.setData(1);
        Thread.sleep(100);
        number.setData(2);
        Thread.sleep(100);
        number.setData(3);
    }
}
//被观察者类
class NumObservable extends Observable {
    int data = 0;
    public void setData(int i) {
        data = i;
        setChanged();    //标记此 Observable对象为已改变的对象
        notifyObservers();    //通知所有观察者
    }
}
//观察者类
class NumObserver implements Observer {

    public void update(Observable o, Object arg) {    //有被观察者发生变化，自动调用对应观察者的update方法
        NumObservable myObserable=(NumObservable) o;     //获取被观察者对象
        System.out.println("Data has changed to " +myObserable.data);
    }
}
