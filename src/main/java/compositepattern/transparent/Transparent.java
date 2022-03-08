package compositepattern.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fwx
 * @date 2022/3/8
 * 透明式的组合模式
 */
public class Transparent {
    public static void main(String[] args) {
        //树枝角色
        Component c0 = new Composite();
        Component c1 = new Composite();
        //树叶角色
        Component leaf1 = new Leaf("1");
        Component leaf2 = new Leaf("2");
        Component leaf3 = new Leaf("3");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operation();
    }
}

//抽象构件
interface Component{
    void add(Component c);

    void remove(Component c);

    Component getChild(int i);

    void operation();
}

//树叶构件
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {

    }

    @Override
    public void remove(Component c) {

    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("树叶"+name+"被访问！");
    }
}

//树枝构件
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
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
