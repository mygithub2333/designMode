package factory.simple;

/**
 * @author fwx
 * @date 2022/2/14
 * 飞机工厂类
 */
public class PlaneFactory {

    /**
     * 生产MoveAble
     * @return MoveAble
     */
    public static MoveAble create(){
        System.out.println("a plane is created");
        return new Plane();
    }

}
