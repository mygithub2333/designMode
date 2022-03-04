package adapter;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author fwx
 * @date 2022/3/3
 */
public class ClassAdapterDemo {

    public static void main(String[] args) {
        System.out.println("适配器模式测试：");
        List<Motor> list = ReadXML.getObject();
        for (Motor motor : list) {
            motor.drive();
        }
    }
}

//目标：发动机
interface Motor{
  void drive();
}

//适配者1：电能发动机
class ElectricMotor{
    public void electricDrive(){
        System.out.println("电能发动机驱动汽车！");
    }
}

//适配者2：光能发动机
class OpticalMotor{
    public void opticalDrive(){
        System.out.println("光能发动机驱动汽车！");
    }
}

//电能适配器
class ElectricAdapter implements Motor{

    private ElectricMotor electricMotor;

    public ElectricAdapter()
    {
        electricMotor=new ElectricMotor();
    }
    @Override
    public void drive() {
        electricMotor.electricDrive();
    }
}

//光能适配器
class OpticalAdapter implements Motor
{
    private OpticalMotor opticalMotor;
    public OpticalAdapter()
    {
        opticalMotor=new OpticalMotor();
    }
    @Override
    public void drive()
    {
        opticalMotor.opticalDrive();
    }
}

class ReadXML{
    public static List<Motor> getObject(){
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("F:/my-space/designMode/src/main/java/adapter/config.xml"));
            NodeList nl=doc.getElementsByTagName("className");
            List<Motor> list = new ArrayList<>();
            for(int i = 0;i<nl.getLength();i++){
                Node classNode = nl.item(i).getFirstChild();
                String cName="adapter."+classNode.getNodeValue();
                Class<?> c=Class.forName(cName);
                Motor obj= (Motor) c.newInstance();
                list.add(obj);
            }
           /* Node classNode=nl.item(1).getFirstChild();
            String cName="adapter."+classNode.getNodeValue();
            Class<?> c=Class.forName(cName);
            Object obj=c.newInstance();*/
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

