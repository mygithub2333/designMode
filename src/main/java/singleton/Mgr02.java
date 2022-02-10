package singleton;

/**
 * @author fwx
 * @date 2022/2/9
 * 懒汉式
 * 虽然达到了按需初始化的目的，但是却带来线程不安全的问题
 */
public class Mgr02 {
    private static Mgr02 INSTANCE;

    private Mgr02() {
    }

    public static Mgr02 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0;i<100;i++){
            new Thread(()-> System.out.println(Mgr02.getInstance().hashCode())).start();
        }
    }
}
