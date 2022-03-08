package flyweight.gobang;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author fwx
 * @date 2022/3/7
 */
public class PicJpanel extends JPanel {
    MyJpanel mj;

    public PicJpanel(MyJpanel mj){
        //设定面板在窗体中的位置以及高度和宽度
        this.setBounds(0,0,mj.getWidth(),mj.getHeight());
        this.mj=mj;
    }
    /**
     * 画组件
     */
    @Override
    protected void paintComponent(Graphics g) {
        //设置一个背景
        try {
            BufferedImage bj = ImageIO.read(new File("src/main/java/flyweight/gobang/bjtp.png"));
            g.drawImage(bj,0,0,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.setColor(Color.BLACK);
        //通过循环画格子
        for (int i = 0;i<15;i++){
            for (int j = 0;j<15;j++){
                g.drawRect(50*i,50*j,50,50);
                //1为白
                if (mj.map[i][j] == 1){
                    g.setColor(Color.WHITE);
                    g.fillOval(50*j,50*i,50,50);
                }
                g.setColor(Color.BLACK);
                //2为黑
                if (mj.map[i][j] == 2){
                    g.setColor(Color.BLACK);
                    g.fillOval(50*j,50*i,50,50);
                }
            }
        }
    }
}
