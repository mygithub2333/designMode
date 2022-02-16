package facadeandmediate.facade;

/**
 * @author fwx
 * @date 2022/2/16
 * 门面：直接访问承包者，访问相应方法，不需要去访问各个系统，可以选择性的暴露子系统的接口方法
 */
public class Main {

    public static void main(String[] args) {
        Contractor contractor = new Contractor();
        contractor.brick();
        contractor.cement();
        contractor.worker();
    }

}
