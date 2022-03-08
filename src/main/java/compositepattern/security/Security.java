package compositepattern.security;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fwx
 * @date 2022/3/8
 * 安全式组合模式
 */
public class Security {
    public static void main(String[] args) {
        Composite c0 = new Composite();
        Composite c1 = new Composite();
        Component l1 = new Leaf("1");
        Component l2 = new Leaf("2");
        Component l3 = new Leaf("3");
        c0.add(l1);
        c0.add(c1);
        c1.add(l2);
        c1.add(l3);
        c0.operation();
    }




}
//抽象构件
interface Component{
    void operation();
}
//树枝构件
class Composite implements Component{
    private List<Component> children = new ArrayList<>();

    public void add(Component c) {
        children.add(c);
    }

    public void remove(Component c) {
        children.remove(c);
    }

    public Component getChild(int i) {
        return children.get(i);
    }
    @Override
    public void operation() {
        for (Component child : children) {
            child.operation();
        }
    }
}
//树叶构件
class Leaf implements Component{
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("树叶"+name+"被访问！");
    }
}
