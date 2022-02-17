package decorator;

/**
 * @author fwx
 * @date 2022/2/17
 * 装饰器模式
 */
public class Main {

    public static void main(String[] args) {
        //肉夹馍
        Component concreteComponent1 = new ConcreteComponent1();
        System.out.println("面饼价格："+concreteComponent1.cost());
        Decorator decorator1 = new ConcreteDecorator1(concreteComponent1);
        System.out.println("加热狗总计："+decorator1.cost()+"元");
        ConcreteDecorator2 decorator2 = new ConcreteDecorator2(decorator1);
        System.out.println("再加里脊总计："+decorator2.cost()+"元");

        //杂粮煎饼
        Component concreteComponent2 = new ConcreteComponent2();
        System.out.println("杂粮煎饼价格："+concreteComponent2.cost());
        Decorator decorator11 = new ConcreteDecorator1(concreteComponent2);
        System.out.println("加热狗总计："+decorator11.cost()+"元");
        ConcreteDecorator2 decorator22 = new ConcreteDecorator2(decorator11);
        System.out.println("再加里脊总计："+decorator22.cost()+"元");


    }
}
