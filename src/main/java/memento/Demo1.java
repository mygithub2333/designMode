package memento;

/**
 * @author fwx
 * @date 2022/3/14
 * 备忘录（Memento）模式
 */
public class Demo1 {

    public static void main(String[] args) {
        Originator or = new Originator();
        Caretaker cr = new Caretaker();
        or.setState("S0");
        System.out.println("初始状态："+or.getState());
        cr.setMemento(or.createMemento());//保存状态
        or.setState("S1");
        System.out.println("新的状态："+or.getState());
        or.restoreMemento(cr.getMemento());//恢复状态
        System.out.println("恢复状态："+or.getState());
    }
}

//备忘录
class Memento{
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

//发起人
class Originator{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void restoreMemento(Memento m){
        this.setState(m.getState());
    }
}

//管理者
class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
