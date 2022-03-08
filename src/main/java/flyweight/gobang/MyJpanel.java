package flyweight.gobang;

import javax.swing.*;

/**
 * @author fwx
 * @date 2022/3/7
 */
public class MyJpanel extends JFrame {

    PicJpanel pj;

    int map[][] = new int[16][16]; // 棋盘

    int flag = 2; // 1为白 2为黑 黑白交替默认为黑

    int winner = 0;//规定赢者

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public MyJpanel() {
        init();
    }

    private void init(){
        //窗体的常用设置
        this.setSize(750,780);//设置窗体的大小，宽度和高度，单位是像素
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗体关闭时主线程自动关闭
        this.setLocationRelativeTo(null);//设置窗体出现的位置在显示器正中间
        this.setResizable(false);//设置窗体固定大小
        this.setLayout(null);//不启用布局管理器，改为手动布局
        this.setTitle("画图");

        //添加面板到窗体

        pj = new PicJpanel(this);
        pj.addMouseListener(new MyHouse(this));//给面板添加一个鼠标监听事件
        this.add(pj);

        this.setVisible(true);
    }
}
