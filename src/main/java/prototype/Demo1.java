package prototype;

/**
 * @author fwx
 * @date 2022/3/1
 * 原型模式
 */
class RealizeType implements Cloneable{
    public RealizeType() {
        System.out.println("具体原型创建成功");
    }

    @Override
    protected RealizeType clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (RealizeType)super.clone();
    }
}

public class Demo1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        RealizeType o1 = new RealizeType();
        RealizeType o2 = o1.clone();
        System.out.println(o1);
        System.out.println(o2);
        System.out.println("o1==o2?"+(o1==o2));
    }

}
