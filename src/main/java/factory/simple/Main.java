package factory.simple;

/**
 * @author fwx
 * @date 2022/2/14
 * 工厂方法模式：
 * 任意定制交通工具
 * 任意定制生产工程
 * 适合横向扩展产品
 */
public class Main {
    public static void main(String[] args) {
        MoveAbleFactory c = new CarFactory();
        MoveAble car = c.create();
        car.go();
        MoveAbleFactory p = new PlaneFactory();
        MoveAble plane = p.create();
        plane.go();
    }
}
