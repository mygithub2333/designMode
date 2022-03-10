package command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fwx
 * @date 2022/3/9
 * 在软件开发中，有时将命令模式与前面学的组合模式联合使用，这就构成了宏命令模式，也叫组合命令模式
 */
public class Demo3 {
    public static void main(String[] args) {
        AbstractCommand cmd1 = new ConcreteCommand1();
        AbstractCommand cmd2 = new ConcreteCommand2();
        CompositeInvoker ir1 = new CompositeInvoker();
        CompositeInvoker ir2 = new CompositeInvoker();
        ir1.add(ir2);
        ir1.add(cmd1);
        ir2.add(cmd2);
        System.out.println("客户访问调用者的execute()方法...");
        ir1.execute();
    }
}
//抽象命令
interface AbstractCommand {
    void execute();
}
//树叶构件：具体命令1
class ConcreteCommand1 implements AbstractCommand{

    private CompositeReceiver receive;

    public ConcreteCommand1() {
        receive = new CompositeReceiver();
    }

    @Override
    public void execute() {
        receive.action1();
    }
}
//树叶构件：具体命令1
class ConcreteCommand2 implements AbstractCommand{

    private CompositeReceiver receive;

    public ConcreteCommand2() {
        receive = new CompositeReceiver();
    }

    @Override
    public void execute() {
        receive.action2();
    }
}
//树枝构件: 调用者
class CompositeInvoker implements AbstractCommand{
    private List<AbstractCommand> children = new ArrayList<>();

    public void add(AbstractCommand c){
        children.add(c);
    }

    public void remove(AbstractCommand c){
        children.remove(c);
    }

    public AbstractCommand getChild(int i){
        return children.get(i);
    }

    @Override
    public void execute() {
        for (AbstractCommand child : children) {
            child.execute();
        }
    }
}
class CompositeReceiver {
    public void action1(){
        System.out.println("接收者的action1()方法被调用...");
    }
    public void action2(){
        System.out.println("接收者的action2()方法被调用...");
    }
}
