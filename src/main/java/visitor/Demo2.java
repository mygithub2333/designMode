package visitor;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author fwx
 * @date 2022/3/11
 * 利用“访问者（Visitor）模式”模拟艺术公司与造币公司的功能。
 * 分析：艺术公司利用“铜”可以设计出铜像，利用“纸”可以画出图画；造币公司利用“铜”可以印出铜币，利用“纸”可以印出纸币。
 * 对“铜”和“纸”这两种元素，两个公司的处理方法不同，所以该实例用访问者模式来实现比较适合。
 */
public class Demo2 {
    public static void main(String[] args) {
        new MaterialWin();
    }
}
//窗体类
class MaterialWin extends JFrame implements ItemListener {
    private static final long serialVersionUID = 1L;
    JPanel CenterJP;
    SetMaterial os;    //材料集对象
    Company visitor1, visitor2;    //访问者对象
    String[] select;
    MaterialWin() {
        super("利用访问者模式设计艺术公司和造币公司");
        JRadioButton Art;
        JRadioButton mint;
        os = new SetMaterial();
        os.add(new Cuprum());
        os.add(new Paper());
        visitor1 = new ArtCompany();//艺术公司
        visitor2 = new Mint(); //造币公司
        this.setBounds(10, 10, 750, 350);
        this.setResizable(false);
        CenterJP = new JPanel();
        this.add("Center", CenterJP);
        JPanel SouthJP = new JPanel();
        JLabel yl = new JLabel("原材料有：铜和纸，请选择生产公司：");
        Art = new JRadioButton("艺术公司", true);
        mint = new JRadioButton("造币公司");
        Art.addItemListener(this);
        mint.addItemListener(this);
        ButtonGroup group = new ButtonGroup();
        group.add(Art);
        group.add(mint);
        SouthJP.add(yl);
        SouthJP.add(Art);
        SouthJP.add(mint);
        this.add("South", SouthJP);
        select = (os.accept(visitor1)).split(" ");    //获取产品名
        showPicture(select[0], select[1]);    //显示产品
    }
    //显示图片
    void showPicture(String cuprum, String paper) {
        CenterJP.removeAll();    //清除面板内容
        CenterJP.repaint();    //刷新屏幕
        String FileName1 = "src/main/java/visitor/Picture/" + cuprum + ".jpg";
        String FileName2 = "src/main/java/visitor/Picture/" + paper + ".jpg";
        JLabel lb = new JLabel(new ImageIcon(FileName1), JLabel.CENTER);
        JLabel rb = new JLabel(new ImageIcon(FileName2), JLabel.CENTER);
        CenterJP.add(lb);
        CenterJP.add(rb);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void itemStateChanged(ItemEvent arg0) {
        JRadioButton jc = (JRadioButton) arg0.getSource();
        if (jc.isSelected()) {
            if (Objects.equals(jc.getText(), "造币公司")) {
                select = (os.accept(visitor2)).split(" ");
            } else {
                select = (os.accept(visitor1)).split(" ");
            }
            showPicture(select[0], select[1]);    //显示选择的产品
        }
    }
}
//抽象访问者:公司
interface Company {
    String create(Paper element);
    String create(Cuprum element);
}
//具体访问者：艺术公司
class ArtCompany implements Company {
    @Override
    public String create(Paper element) {
        return "讲学图";
    }
    @Override
    public String create(Cuprum element) {
        return "朱熹铜像";
    }
}
//具体访问者：造币公司
class Mint implements Company {
    @Override
    public String create(Paper element) {
        return "纸币";
    }
    @Override
    public String create(Cuprum element) {
        return "铜币";
    }
}
//抽象元素：材料
interface Material {
    String accept(Company visitor);
}
//具体元素：纸
class Paper implements Material {
    @Override
    public String accept(Company visitor) {
        return (visitor.create(this));
    }
}
//具体元素：铜
class Cuprum implements Material {
    @Override
    public String accept(Company visitor) {
        return (visitor.create(this));
    }
}
//对象结构角色:材料集
class SetMaterial {
    private List<Material> list = new ArrayList<>();
    public String accept(Company visitor) {
        Iterator<Material> i = list.iterator();
        StringBuilder tmp = new StringBuilder();
        while (i.hasNext()) {
            tmp.append(i.next().accept(visitor)).append(" ");
        }
        return tmp.toString(); //返回某公司的作品集
    }
    public void add(Material element) {
        list.add(element);
    }
    public void remove(Material element) {
        list.remove(element);
    }
}
