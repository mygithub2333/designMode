package bridge;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;

/**
 * @author fwx
 * @date 2022/3/4
 * 女士皮包有很多种，可以按用途分、按皮质分、按品牌分、按颜色分、按大小分等，存在多个维度的变化，所以采用桥接模式来实现女士皮包的选购比较合适。
 */
public class BridgeDemo2 {

    public static void main(String[] args) {
        Color color = (Color) ReadXml.getObject("color");
        Bag bag = (Bag) ReadXml.getObject("bag");
        bag.setColor(color);
        String name = bag.getName();
        show(name);
    }

    public static void show(String name){
        JFrame jf = new JFrame("桥接模式测试");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JLabel l = new JLabel(new ImageIcon("src/main/java/bridge/"+name+".jpg"));
        p.setLayout(new GridLayout(1,1));
        p.setBorder(BorderFactory.createTitledBorder("女士皮包"));
        p.add(l);
        contentPane.add(p,BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



//实现化角色：颜色
interface Color{
    String getColor();
}

//具体实现化角色：黄色
class Yellow implements Color{
    @Override
    public String getColor() {
        return "yellow";
    }
}

//具体实现化角色：红色
class Red implements Color{
    @Override
    public String getColor() {
        return "red";
    }
}

//抽象化角色：包
abstract class Bag{
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String getName();
}

//扩展抽象化角色：挎包
class HandBag extends Bag{
    @Override
    public String getName() {
        return color.getColor()+"HandBag";
    }
}

//扩展抽象化角色：钱包
class Wallet extends Bag{
    @Override
    public String getName() {
        return color.getColor()+"Wallet";
    }
}

class ReadXml{
    public static Object getObject(String args){
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            Document parse = dBuilder.parse("src/main/java/bridge/config.xml");
            NodeList className = parse.getElementsByTagName("className");
            Node node = null;
            if (args.equals("color")){
                node = className.item(0).getFirstChild();
            }else if (args.equals("bag")){
                node = className.item(1).getFirstChild();
            }
            String cName ="bridge." + node.getNodeValue();
            Class<?> aClass = Class.forName(cName);
            Object o = aClass.newInstance();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}