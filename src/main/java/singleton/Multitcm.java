package singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fwx
 * @date 2022/3/1
 *单例模式可扩展为有限的多例（Multitcm）模式，这种模式可生成有限个实例并保存在 ArrayList 中，客户需要时可随机获取
 */
public class Multitcm {

    private static List<Multitcm> list = new ArrayList<>();

    private final static int n = 10;

    static {
        for (int i = 0;i<n;i++){
            list.add(new Multitcm(i));
        }
    }

    private Multitcm(int n){
    }
    public static Multitcm getRandomInstance(){
        double random = Math.random();
        int value = (int)(random*n);
        System.out.println(value);
        return list.get(value);
    }

}
class Main {
    public static void main(String[] args) {
        Multitcm randomInstance1 = Multitcm.getRandomInstance();
        Multitcm randomInstance = Multitcm.getRandomInstance();
        System.out.println(randomInstance);
        System.out.println(randomInstance1);
        System.out.println(randomInstance==randomInstance1);
    }
}