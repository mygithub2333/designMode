package facadeandmediate.facade;

/**
 * @author fwx
 * @date 2022/2/16
 * 承包者
 */
public class Contractor {
    private Cement cement = new Cement();

    private Brick brick = new Brick();

    private Worker worker = new Worker();

    public void cement(){
        cement.cement();
    }

    public void brick(){
        brick.brick();
    }

    public void worker(){
        worker.worker();
    }

}
