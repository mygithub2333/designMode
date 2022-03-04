package adapter;

/**
 * @author fwx
 * @date 2022/3/3
 */
public class ClassAdapter extends Adapter implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}

//目标接口
interface Target{
    void request();
}

//适配器接口
class Adapter{
    public void specificRequest(){
        System.out.println("适配者中的业务代码被调用！");
    }
}

class ClassAdapterTest{
    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}
