package factory.simple;

/**
 * @author fwx
 * @date 2022/2/14
 * 飞机工厂类
 */
public class PlaneFactory implements MoveAbleFactory {

    /**
     * 生产MoveAble
     * @return MoveAble
     */
    @Override
    public MoveAble create(){
        System.out.println("a plane is created");
        return new Plane();
    }

}
