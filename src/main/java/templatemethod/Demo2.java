package templatemethod;

/**
 * @author fwx
 * @date 2022/3/8
 * 含钩子方法的模板方法模式
 */
public class Demo2 {
    public static void main(String[] args) {
        HookAbstractClass hookAbstractClass = new HookConcreteClass();
        hookAbstractClass.TemplateMethod();
    }

}

//含钩子方法的抽象类
abstract class HookAbstractClass {
    //模板方法
    public void TemplateMethod() {
        abstractMethod1();
        HookMethod1();
        if (HookMethod2()) {
            SpecificMethod();
        }
        abstractMethod2();
    }
    //具体方法
    public void SpecificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }
    //钩子方法1
    public void HookMethod1() {
    }
    //钩子方法2
    public boolean HookMethod2() {
        return true;
    }
    //抽象方法1
    public abstract void abstractMethod1();
    //抽象方法2
    public abstract void abstractMethod2();
}
//含钩子方法的具体子类
class HookConcreteClass extends HookAbstractClass {
    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }
    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
    @Override
    public void HookMethod1() {
        System.out.println("钩子方法1被重写...");
    }
    @Override
    public boolean HookMethod2() {
        return true;
    }
}