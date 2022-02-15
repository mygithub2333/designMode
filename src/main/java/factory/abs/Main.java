package factory.abs;

import factory.simple.CarFactory;
import factory.simple.MoveAble;
import factory.simple.PlaneFactory;

/**
 * @author fwx
 * @date 2022/2/15
 * 抽象工厂模式：
 * 任意定制交通工具
 * 任意定制生产工程
 * 任意定制产品族（适合纵向扩展产品族）
 */
public class Main {
    public static void main(String[] args) {
        ModernFactory modernFactory = new ModernFactory();
        modernFactory.createVehicle().go();
        modernFactory.createFood().printName();
        modernFactory.createWeapon().shoot();
        MagicFactory magicFactory = new MagicFactory();
        magicFactory.createVehicle().go();
        magicFactory.createFood().printName();;
        magicFactory.createWeapon().shoot();
    }
}
