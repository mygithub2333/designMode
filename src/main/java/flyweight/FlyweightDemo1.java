package flyweight;

import java.util.HashMap;

/**
 * @author fwx
 * @date 2022/3/7
 * 享元模式
 */
public class FlyweightDemo1 {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight a = flyweightFactory.getFlyweight("a");
        Flyweight b = flyweightFactory.getFlyweight("b");
        Flyweight c = flyweightFactory.getFlyweight("c");
        Flyweight d = flyweightFactory.getFlyweight("d");
        Flyweight e = flyweightFactory.getFlyweight("e");
        a.operation(new UnsharedConcreteFlyweight("第一次调用a"));
        b.operation(new UnsharedConcreteFlyweight("第一次调用b"));
        c.operation(new UnsharedConcreteFlyweight("第一次调用c"));
        d.operation(new UnsharedConcreteFlyweight("第一次调用d"));
        e.operation(new UnsharedConcreteFlyweight("第一次调用e"));
    }
}
//非享元角色
class UnsharedConcreteFlyweight {
    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
//抽象享元角色
interface Flyweight {
    void operation(UnsharedConcreteFlyweight state);
}
//具体享元角色
class ConcreteFlyweight implements Flyweight{

    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元单元"+key+"被创建");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight state) {
        System.out.println("具体享元单元"+key+"被调用");
        System.out.println("非享元信息是"+state.getInfo());
    }
}

//享元工厂角色
class FlyweightFactory{

    private HashMap<String,Flyweight> flyweights = new HashMap<String,Flyweight>();

    public Flyweight getFlyweight(String key){
        Flyweight flyweight = flyweights.get(key);
        if (flyweight != null){
            System.out.println("具体享元"+key+"已经存在，被成功获取");
        }else {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key,flyweight);
        }
        return flyweight;
    }
}