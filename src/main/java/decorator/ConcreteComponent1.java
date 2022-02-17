package decorator;

/**
 * @author fwx
 * @date 2022/2/17
 */
public class ConcreteComponent1 extends Component {

    private String name = "肉夹馍面饼";

    private int price = 5;

    @Override
    public int cost() {
       return this.price;
    }
}
