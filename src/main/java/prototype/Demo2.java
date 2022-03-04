package prototype;

/**
 * @author fwx
 * @date 2022/3/1
 * 原型模式
 */
public class Demo2 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Citation obj1 = new Citation("张三", "同学：在2016学年第一学期中表现优秀，被评为三好学生。", "韶关学院");
        obj1.display();
        Citation obj2 = obj1.clone();
        obj2.setName("李四");
        obj2.display();
    }
}
//奖状
class Citation implements Cloneable{
    String name;
    String info;
    String college;

    public Citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("奖状创建成功");
    }

   public void display(){
       System.out.println(name+info+college);
   }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        System.out.println("奖状拷贝成功");
        return (Citation)super.clone();
    }
}