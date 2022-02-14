package factory.simple;

/**
 * @author fwx
 * @date 2022/2/14
 * 简单工厂模式：
 * 任意定制交通工具
 * 任意定制生产工程
 * 适合横向扩展
 */
public class Main {
    public static void main(String[] args) {
        MoveAble car = CarFactory.createCar();
        car.go();
        MoveAble plane = PlaneFactory.createPlane();
        plane.go();
    }
}
