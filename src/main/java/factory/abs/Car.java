package factory.abs;

import factory.simple.MoveAble;

/**
 * @author fwx
 * @date 2022/2/15
 * 汽车实体
 */
public class Car extends Vehicle {
    @Override
    public void go() {
        System.out.println("car gogogo......");
    }
}
