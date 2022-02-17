package decorator;

/**
 * @author fwx
 * @date 2022/2/17
 */
public class ConcreteDecorator1 extends Decorator {

    private final int price = 5;

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public int cost() {
        return super.cost()+price;
    }
}
