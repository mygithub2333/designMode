package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fwx
 * @date 2022/3/11
 * 迭代器（Iterator）模式
 */
public class Demo1 {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("中山大学");
        ag.add("华南理工");
        ag.add("韶关学院");
        System.out.println("聚合的内容有：");
        Iterator it = ag.getIterator();
        while (it.hasNext()) {
            Object ob = it.next();
            System.out.println(ob.toString());
        }
        Object ob = it.first();
        System.out.println("\nFirst：" + ob.toString());
    }
}
//抽象聚合
interface Aggregate{

    void add(Object o);

    void remove(Object o);

    Iterator getIterator();

}
//具体聚合
class ConcreteAggregate implements Aggregate{
    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object o) {
        list.add(o);
    }

    @Override
    public void remove(Object o) {
        list.remove(o);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}
//抽象迭代器
interface Iterator {
    Object first();

    Object next();

    boolean hasNext();

}
//具体迭代器
class ConcreteIterator implements Iterator{
    private List<Object> list;

    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        index = 0;
        return list.get(index);
    }

    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }
}