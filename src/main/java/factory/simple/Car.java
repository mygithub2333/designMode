package factory.simple;

/**
 * @author fwx
 * @date 2022/2/14
 * 汽车实体
 */
public class Car implements MoveAble {
    @Override
    public void go() {
        System.out.println("car gogogo......");
    }
}
