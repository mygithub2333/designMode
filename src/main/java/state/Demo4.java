package state;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fwx
 * @date 2022/3/10
 * 在有些情况下，可能有多个环境对象需要共享一组状态，这时需要引入享元模式，将这些具体状态对象放在集合中供程序共享
 * 分析：共享状态模式的不同之处是在环境类中增加了一个 HashMap 来保存相关状态，当需要某种状态时可以从中获取
 */
public class Demo4 {
    public static void main(String[] args) {
        ShareContext context = new ShareContext(); //创建环境
        context.Handle(); //处理请求
        context.Handle();
        context.Handle();
        context.Handle();
    }
}

class ShareContext{
    private ShareState state;
    private Map<String,ShareState> stateMap = new HashMap<>();

    public ShareState getState(String key) {
        return stateMap.get(key);
    }

    public void setState(ShareState state) {
        this.state = state;
    }

    public ShareContext() {
        state = new ConcreteState1();
        stateMap.put("1",state);
        state = new ConcreteState2();
        stateMap.put("2",state);
        state = getState("1");
    }

    //对请求做处理
    public void Handle() {
        state.Handle(this);
    }
}

abstract class ShareState{
    abstract void Handle(ShareContext context);
}

class ConcreteState1 extends ShareState{
    @Override
    public void Handle(ShareContext context) {
        System.out.println("当前状态是： 状态1");
        context.setState(context.getState("2"));
    }
}

class ConcreteState2 extends ShareState{
    @Override
    public void Handle(ShareContext context) {
        System.out.println("当前状态是： 状态2");
        context.setState(context.getState("1"));
    }
}

