package state;

/**
 * @author fwx
 * @date 2022/3/9
 * 状态模式
 */
public class Demo1 {
    public static void main(String[] args) {
        Context context = new Context();
        context.handle();
        context.handle();
    }
}
//环境类
class Context{
    private State state;

    public Context() {
        state = new ConcreteStateA();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle(){
        this.state.Handle(this);
    }
}

//抽象状态类
abstract class State{
   abstract void Handle(Context context);
}

//具体状态A类
class ConcreteStateA extends State{
    @Override
    void Handle(Context context) {
        System.out.println("当前状态是A.");
        context.setState(new ConcreteStateB());
    }
}

//具体状态B类
class ConcreteStateB extends State{
    @Override
    void Handle(Context context) {
        System.out.println("当前状态是B.");
        context.setState(new ConcreteStateA());
    }
}