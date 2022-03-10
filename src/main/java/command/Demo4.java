package command;

import javax.swing.*;

/**
 * @author fwx
 * @date 2022/3/9
 * 用命令模式实现客户去餐馆吃早餐的实例。
 * 客户去餐馆可选择的早餐有肠粉、河粉和馄饨等，
 * 客户可向服务员选择以上早餐中的若干种，服务员将客户的请求交给相关的厨师去做。
 * 这里的点早餐相当于“命令”，服务员相当于“调用者”，厨师相当于“接收者”，所以用命令模式实现比较合适。
 * 首先，定义一个早餐类（Breakfast），它是抽象命令类，有抽象方法 cooking()，说明要做什么；
 * 再定义其子类肠粉类（ChangFen）、馄饨类（HunTun）和河粉类（HeFen），它们是具体命令类，实现早餐类的 cooking() 方法，
 * 但它们不会具体做，而是交给具体的厨师去做；
 * 具体厨师类有肠粉厨师（ChangFenChef）、馄饨厨师（HunTunChef）和河粉厨师（HeFenChef），他们是命令的接收者。
 */
public class Demo4 {

    public static void main(String[] args) {
        Breakfast4 food1= new ChangFen4();
        Waiter4 fwy = new Waiter4();
        fwy.setChangFen(food1);
        fwy.chooseChangFen();
       /* Breakfast food1 = new ChangFen();
        Breakfast food2 = new HunTun();
        Breakfast food3 = new HeFen();
        Waiter fwy = new Waiter();
        fwy.setChangFen(food1);//设置肠粉菜单
        fwy.setHunTun(food2);  //设置河粉菜单
        fwy.setHeFen(food3);   //设置馄饨菜单
        fwy.chooseChangFen();  //选择肠粉
        fwy.chooseHeFen();     //选择河粉
        fwy.chooseHunTun();    //选择馄饨*/
    }
}

//调用者：服务员
class Waiter4{
    private Breakfast4 changFen,hunTun,heFen;

    public void setChangFen(Breakfast4 changFen) {
        this.changFen = changFen;
    }

    public void setHunTun(Breakfast4 hunTun) {
        this.hunTun = hunTun;
    }

    public void setHeFen(Breakfast4 heFen) {
        this.heFen = heFen;
    }

    public void chooseChangFen(){
        changFen.cooking();
    }

    public void chooseHunTun(){
        hunTun.cooking();
    }

    public void chooseHeFen(){
        heFen.cooking();
    }
}
//抽象命令：早餐
interface Breakfast4{
    void cooking();
}
//具体命令：肠粉
class ChangFen4 implements Breakfast4{

    private ConcreteChef4 receive;

    public ChangFen4() {
        receive = new ConcreteChef4();
        receive.CookingChangFen();
    }

    @Override
    public void cooking() {
        receive.cooking();
    }
}
//具体命令：馄饨
class HunTun4 implements Breakfast4{

    private ConcreteChef4 receive;

    public HunTun4() {
        receive = new ConcreteChef4();
        receive.CookingHunTun();
    }

    @Override
    public void cooking() {
        receive.cooking();
    }
}

//具体命令：河粉
class HeFen4 implements Breakfast4{

    private ConcreteChef4 receive;

    public HeFen4() {
        receive = new ConcreteChef4();
        receive.CookingHeFen();
    }

    @Override
    public void cooking() {
        receive.cooking();
    }
}

interface Chef4{
    void cooking();
}


class ConcreteChef4 extends JFrame implements Chef4{
    JLabel l = new JLabel();

    public void CookingChangFen(){
        this.setTitle("煮肠粉");
        l.setIcon(new ImageIcon("src/main/java/command/ChangFen.jpg"));
        this.add(l);
        this.setLocation(30, 30);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void CookingHunTun(){
        this.setTitle("煮馄饨");
        l.setIcon(new ImageIcon("src/main/java/command/HunTun.jpg"));
        this.add(l);
        this.setLocation(30, 30);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void CookingHeFen(){
        this.setTitle("煮河粉");
        l.setIcon(new ImageIcon("src/main/java/command/HeFen.jpg"));
        this.add(l);
        this.setLocation(30, 30);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void cooking() {
        this.setVisible(true);
    }
}