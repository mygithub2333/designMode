package command;

/**
 * @author fwx
 * @date 2022/3/9
 * 命令模式
 */
public class Demo1 {

    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        System.out.println("客户访问调用者的call()方法...");
        invoker.call();
    }
}
//调用者
class Invoker{
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call(){
        System.out.println("调用者执行命令......");
        command.execute();
    }
}
//抽象命令
interface Command {
    void execute();
}
//具体命令
class ConcreteCommand implements Command{

    private Receiver receiver;

    public ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

//接收者
class Receiver{
    public void action(){
        System.out.println("接收者的action()方法被调用...");
    }
}