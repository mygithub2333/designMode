package decorator;

/**
 * @author fwx
 * @date 2022/2/17
 */
public class ConcreteComponent2 extends Component {
    private String name = "杂粮煎饼";
    private int price = 4;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ConcreteComponent2{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public int cost() {
        System.out.println(this.name);
       return this.price;
    }
}
