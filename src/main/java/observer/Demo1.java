package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fwx
 * @date 2022/3/10
 * 观察者模式
 */
public class Demo1 {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer o1 = new ConcreteObserver1();
        Observer o2 = new ConcreteObserver2();
        subject.add(o1);
        subject.add(o2);
        subject.notifyObserver();
    }
}
//抽象目标
abstract class Subject{

    //聚合观察者对象
    protected List<Observer> observers = new ArrayList<>();

    //增加观察者方法
    public void add(Observer observer){
        observers.add(observer);
    }
    //删除观察者方法
    public void remove(Observer observer){
        observers.remove(observer);
    }

    public abstract void notifyObserver();//通知观察者方法

}
//具体目标
class ConcreteSubject extends Subject{
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变");
        System.out.println("----------------");
        for (Observer observer : observers) {
            observer.response();//观察者做出反应
        }
    }
}
//抽象观察者
interface Observer{
    void response();
}
//具体观察者1
class ConcreteObserver1 implements Observer{
    @Override
    public void response() {
        System.out.println("具体观察者1做出反应");
    }
}
//具体观察者2
class ConcreteObserver2 implements Observer{
    @Override
    public void response() {
        System.out.println("具体观察者2做出反应");
    }
}