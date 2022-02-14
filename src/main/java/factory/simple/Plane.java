package factory.simple;

/**
 * @author fwx
 * @date 2022/2/14
 * 飞机实体
 */
public class Plane implements MoveAble {
    @Override
    public void go() {
        System.out.println("plane flying ......");
    }
}
