package templatemethod;

/**
 * @author fwx
 * @date 2022/3/8
 * 模板方法（Template Method）模式
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass concreteClass = new ConcreteClass();
        concreteClass.templateMethod();
    }

}
//抽象类
abstract class AbstractClass {
    //模板方法
    public void templateMethod(){
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    //具体方法
    public void specificMethod(){
        System.out.println("抽象类中的具体方法被调用...");
    }

    //抽象方法1
    public abstract void abstractMethod1();

    //抽象方法2
    public abstract void abstractMethod2();
}

//具体子类
class ConcreteClass extends AbstractClass{
    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用。。。");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用。。。");
    }
}
