package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fwx
 * @date 2022/3/15
 * 代理模式（动态代理）
 */
public class Demo2 {

    public static void main(String[] args) {
        JdkFuDao jdkFuDao = new JdkFuDao();
        IPerson instance = jdkFuDao.getInstance(new ZhaoLiu());
        instance.findTeacher();
    }
}
//辅导班类
class JdkFuDao implements InvocationHandler{

    private IPerson iPerson;

    public IPerson getInstance(IPerson iPerson){
        this.iPerson = iPerson;
        Class<?> aClass = iPerson.getClass();
        return (IPerson)Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.iPerson,args);
        after();
        return result;
    }

    private void after(){
        System.out.println("双方同意，开始辅导");
    }

    private void before(){
        System.out.println("这里是C语言中文网辅导班，已经收集到您的需求，开始挑选老师");
    }

}
//角色：赵六
class ZhaoLiu implements IPerson{
    @Override
    public void findTeacher() {
        System.out.println("符合赵六的要求");
    }
}

//顶层接口 IPerson
interface IPerson{
    void findTeacher(); //找老师
}