package singleton;

/**
 * @author fwx
 * @date 2022/2/9
 * 静态持有者模式（静态内部类）
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Mgr04 {

    private Mgr04() {
    }

    private static class Mgr04Holder{
        private final static Mgr04 INSTANCE = new Mgr04();
    }

    public static Mgr04 getInstance(){
       return Mgr04Holder.INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()-> System.out.println(Mgr04.getInstance().hashCode())).start();
        }
    }
}
