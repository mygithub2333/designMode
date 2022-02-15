package factory.simple;

/**
 * @author fwx
 * @date 2022/2/14
 * 汽车工厂类
 */
public class CarFactory implements MoveAbleFactory {

    /**
     * 生产MoveAble
     * @return MoveAble
     */
    @Override
    public MoveAble create(){
        //before processing  比如 记录日志
        System.out.println("a car is created");
        return new Car();
    }

}
