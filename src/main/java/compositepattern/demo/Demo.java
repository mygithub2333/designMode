package compositepattern.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fwx
 * @date 2022/3/8
 * 用组合模式实现当用户在商店购物后，显示其所选商品信息，并计算所选商品总价的功能。
 *
 * 说明：假如李先生到韶关“天街e角”生活用品店购物，
 * 用 1 个红色小袋子装了 2 包婺源特产（单价 7.9 元）、1 张婺源地图（单价 9.9 元）；
 * 用 1 个白色小袋子装了 2 包韶关香藉（单价 68 元）和 3 包韶关红茶（单价 180 元）；
 * 用 1 个中袋子装了前面的红色小袋子和 1 个景德镇瓷器（单价 380 元）；
 * 用 1 个大袋子装了前面的中袋子、白色小袋子和 1 双李宁牌运动鞋（单价 198 元）。
 */
public class Demo {
    public static void main(String[] args) {
        float s = 0;
        Bags BigBag, mediumBag, smallRedBag, smallWhiteBag;
        Goods sp;
        BigBag = new Bags("大袋子");
        mediumBag = new Bags("中袋子");
        smallRedBag = new Bags("红色小袋子");
        smallWhiteBag = new Bags("白色小袋子");
        sp = new Goods("婺源特产", 2, 7.9f);
        smallRedBag.add(sp);
        sp = new Goods("婺源地图", 1, 9.9f);
        smallRedBag.add(sp);
        sp = new Goods("韶关香菇", 2, 68);
        smallWhiteBag.add(sp);
        sp = new Goods("韶关红茶", 3, 180);
        smallWhiteBag.add(sp);
        sp = new Goods("景德镇瓷器", 1, 380);
        mediumBag.add(sp);
        mediumBag.add(smallRedBag);
        sp = new Goods("李宁牌运动鞋", 1, 198);
        BigBag.add(sp);
        BigBag.add(smallWhiteBag);
        BigBag.add(mediumBag);
        System.out.println("您选购的商品有：");
        BigBag.show();
        s = BigBag.calculation();
        System.out.println("要支付的总价是：" + s + "元");


    }
}

//抽象构件：物品
interface Articles {
    float calculation();//计算

    void show();
}

//树叶构件：商品

class Goods implements Articles{
    private String name;//名字
    private int quantity;//数量
    private float unitPrice;//单价

    public Goods(String name, int quantity, float unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public float calculation() {
        return quantity*unitPrice;
    }

    @Override
    public void show() {
        System.out.println(name + "(数量：" + quantity + "，单价：" + unitPrice + "元)");
    }
}

//树枝构件：袋子
class Bags implements Articles{
    private String name;//名字
    private List <Articles> bags = new ArrayList<>();

    public Bags(String name) {
        this.name = name;
    }

    public void add(Articles a){
        bags.add(a);
    }

    public void remove(Articles a){
        bags.remove(a);
    }

    public Articles getChild(int i){
        return bags.get(i);
    }

    @Override
    public float calculation() {
        float sum = 0;
        for (Articles bag : bags) {
            sum+=bag.calculation();
        }
        return sum;
    }

    @Override
    public void show() {
        for (Articles bag : bags) {
            bag.show();
        }
    }
}
