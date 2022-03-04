package prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author fwx
 * @date 2022/3/1
 * 原型模式
 */
public class Demo3 {
    public static void main(String[] args) {
        ProtoTypeManager protoTypeManager = new ProtoTypeManager();
        Shape circle = protoTypeManager.getShape("Circle");
        circle.countArea();
        Shape square = protoTypeManager.getShape("Square");
        square.countArea();


    }

}

interface Shape extends Cloneable{
    Object clone(); //拷贝

    void countArea(); //计算面积
}
class Circle implements Shape{
    @Override
    public Circle clone() {
        Circle circle = null;

        try {
            circle = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝圆失败!!!");
        }
        return circle;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("这是一个圆,请输入圆的半径:");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该圆的面积="+Math.PI*r*r+"\n");
    }
}

class Square implements Shape{
    @Override
    public Object clone() {
        Square square = null;
        try {
            square = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝正方形失败");

        }
        return square;
    }

    @Override
    public void countArea() {
        int a = 0;
        System.out.println("这是一个正方形,请输入正方形的边长:");
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        System.out.println("该正方形的面积="+a*a+"\n");
    }
}

class ProtoTypeManager{
    private Map<String,Shape> map = new HashMap<>();

    public ProtoTypeManager() {
        addShape("Circle",new Circle());
        addShape("Square",new Square());
    }

    public void addShape(String key, Shape obj) {
        map.put(key, obj);
    }
    public Shape getShape(String key) {
        Shape temp = map.get(key);
        return (Shape) temp.clone();
    }
}
