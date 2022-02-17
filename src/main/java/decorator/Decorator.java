package decorator;

/**
 * @author fwx
 * @date 2022/2/17
 */
public abstract class Decorator extends Component {
    protected Component component = null;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public int cost() {
        return component.cost();
    }
}
