package memento;

/**
 * @author fwx
 * @date 2022/3/14
 * 在前面介绍的备忘录模式中，有单状态备份的例子，也有多状态备份的例子。
 * 下面介绍备忘录模式如何同原型模式混合使用。
 * 在备忘录模式中，通过定义“备忘录”来备份“发起人”的信息，
 * 而原型模式的 clone() 方法具有自备份功能，
 * 所以，如果让发起人实现 Cloneable 接口就有备份自己的功能，这时可以删除备忘录类
 */
public class Demo3 {

    public static void main(String[] args) {
        OriginatorPrototype or = new OriginatorPrototype();
        PrototypeCaretaker cr = new PrototypeCaretaker();
        or.setState("S0");
        System.out.println("初始状态:" + or.getState());
        cr.setMemento(or.createMemento()); //保存状态
        or.setState("S1");
        System.out.println("新的状态:" + or.getState());
        or.restoreMemento(cr.getMemento()); //恢复状态
        System.out.println("恢复状态:" + or.getState());
    }

}
//发起人原型
class OriginatorPrototype implements Cloneable{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public OriginatorPrototype createMemento(){
        return this.clone();
    }
    public void restoreMemento(OriginatorPrototype opt) {
        this.setState(opt.getState());
    }

    @Override
    public OriginatorPrototype clone() {
        try {
            return (OriginatorPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

//原型管理者
class PrototypeCaretaker {
    private OriginatorPrototype originatorPrototype;

    public void setMemento(OriginatorPrototype originatorPrototype){
        this.originatorPrototype = originatorPrototype;
    }

    public OriginatorPrototype getMemento(){
        return originatorPrototype;
    }
}
