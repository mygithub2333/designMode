package adapter;

/**
 * @author fwx
 * @date 2022/3/3
 */
public class TwoWayAdapterDemo {
    public static void main(String[] args)
    {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdaptee adaptee=new AdapteeRealize();
        TwoWayTarget target=new TwoWayAdapter(adaptee);
        target.request();
        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");
        target=new TargetRealize();
        adaptee=new TwoWayAdapter(target);
        adaptee.specificRequest();
    }
}

//目标接口
interface TwoWayTarget{
    void request();
}
//适配者接口
interface TwoWayAdaptee{
    void specificRequest();
}
//目标实现
class TargetRealize implements TwoWayTarget{
    @Override
    public void request() {
        System.out.println("目标代码被调用！");
    }
}
//适配者实现
class AdapteeRealize implements TwoWayAdaptee{
    @Override
    public void specificRequest() {
        System.out.println("适配者代码被调用！");
    }
}
//双向适配器
class TwoWayAdapter implements TwoWayTarget,TwoWayAdaptee{
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;
    public TwoWayAdapter(TwoWayTarget target)
    {
        this.target=target;
    }
    public TwoWayAdapter(TwoWayAdaptee adaptee)
    {
        this.adaptee=adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }

    @Override
    public void specificRequest() {
        target.request();
    }
}
