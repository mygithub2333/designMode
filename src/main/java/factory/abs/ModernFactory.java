package factory.abs;

/**
 * @author fwx
 * @date 2022/2/15
 * 实际工厂（现代工厂）
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new Ak47();
    }
}
