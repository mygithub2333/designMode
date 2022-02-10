package singleton;

/**
 * @author fwx
 * @date 2022/2/9
 * 枚举实现单例模式
 * 不仅可以解决线程同步，还可以防止反序列化(反射)
 */
public enum Mgr05 {

    INSTANCE;

    public void m(){}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr05.INSTANCE.hashCode())).start();
        }
    }
}
