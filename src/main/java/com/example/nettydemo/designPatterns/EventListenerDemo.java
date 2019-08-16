package com.example.nettydemo.designPatterns;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Vector;

/**
 * @Classname EventListenerDemo
 * @Description 监听者模式
 * @Date 2019/8/16 10:16
 * @Author lyn
 */
public class EventListenerDemo {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addListener(new MonitorListener() {

            @Override
            public void handleEvent(PrintEvent event) {
                // TODO Auto-generated method stub
                event.doEvent();
                if(event.getSource().equals("openWindows")) {
                    System.out.println("doOpen");
                }
                if(event.getSource().equals("closeWindows")){
                    System.out.println("doClose");
                }
            }
        });

        /*
         * 传入openWindows事件，通知所有的事件监听器
         * 对open事件感兴趣的listener将会执行
         */
        eventSource.notifyListenerEvents(new PrintEvent("openWindows"));
    }

}

//所有事件监听器接口都要继承这个标签接口
interface MonitorListener extends EventListener {

    public void handleEvent(PrintEvent event);
}

//事件对象
class PrintEvent extends EventObject {
    private static final long serialVersionUID = 1L;

    public PrintEvent(Object source) {
        super(source);
    }

    public void doEvent() {
        //getSource The object on which the Event initially occurred.
        System.out.println("通知一个事件源 source: " + this.getSource());
    }

}

/*
 事件源
 事件源是是事件对象的入口，包含监听器的注册、撤销、通知
 */
class EventSource {
    //监听器列表，如果监听事件源的事件，注册监听器可以加入此列表
    private Vector<MonitorListener> listenerList = new Vector<>();

    //注册监听器
    public void addListener(MonitorListener eventListener) {
        listenerList.add(eventListener);
    }

    //删除监听器
    public void removeListener(MonitorListener eventListener) {
        int i = listenerList.indexOf(eventListener);
        if(i >= 0) {
            listenerList.remove(eventListener);
        }
    }

    //接受外部事件，通知所有的监听器
    public void notifyListenerEvents(PrintEvent event) {
//		Iterator<MonitorListener> iterator = listenerList.iterator();
//		while(iterator.hasNext()) {
//			MonitorListener monitorListener = (MonitorListener)iterator.next();
//			monitorListener.handleEvent(event);
//		}
        for(MonitorListener moniterListener : listenerList) {
            moniterListener.handleEvent(event);
        }
    }
}
