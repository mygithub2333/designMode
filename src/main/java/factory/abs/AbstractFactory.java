package factory.abs;

/**
 * @author fwx
 * @date 2022/2/15
 * 抽象工厂
 */
public abstract class AbstractFactory {

    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();
}
