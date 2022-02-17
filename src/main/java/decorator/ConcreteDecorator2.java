package decorator;

/**
 * @author fwx
 * @date 2022/2/17
 */
public class ConcreteDecorator2 extends Decorator {

    private String name = "里脊";

    private final int price = 2;

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public int cost() {
        return super.cost()+price;
    }
}
