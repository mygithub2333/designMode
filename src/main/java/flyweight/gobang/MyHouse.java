package flyweight.gobang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author fwx
 * @date 2022/3/7
 */
public class MyHouse extends MouseAdapter {
    MyJpanel mj;

    public MyHouse(MyJpanel mj) {
        super();
        this.mj = mj;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //点击事件的处理
        //重置
    if (mj.winner!=0){
        mj.setMap(new int[16][16]);
        mj.winner=0;
        mj.pj.repaint();
        return;
    }
    int map[][] = mj.map;
        Point p = e.getPoint();
        //点击之后map值发生改变
        int x = (int)p.getX()/(750/15);
        int y = (int)p.getY()/(750/15);
        System.out.println("x="+p.getX()+" y="+p.getY());
        System.out.println("x="+x+" y="+y);
        //改变棋子的颜色
        if (map[y][x] == 0){
            map[y][x] = mj.flag;
        }

        //改变顺序
        if(mj.flag == 1){
            mj.flag = 2;
        }else if (mj.flag == 2){
            mj.flag = 1;
        }
        //判断输赢
        MyHouse myHouse = new MyHouse(mj);
        if (myHouse.isWin(y,x,map)){
            if (map[y][x]==1){
                mj.winner=1;
                mj.pj.repaint();
                //弹出获胜信息
                JOptionPane.showMessageDialog(mj,"白子胜");
                //重置棋子颜色为黑色
                mj.flag=2;
            }
            if (map[y][x]==2){
                mj.winner=2;
                mj.pj.repaint();
                JOptionPane.showMessageDialog(mj,"黑子胜");
                mj.flag=2;
            }
        }

        //重置绘图
        mj.setMap(map);
        mj.pj.repaint();
    }


    public boolean isWin(int x,int y,int map[][]){
        // 对胜负判断
        // 4个方向 左右 上下 左斜 右斜
        // 对一个棋子的一个方向的10颗棋子进行判断 是否满足5子连续
        // 左右

        int num = 1;
        for (int i = 0; i < 14; i++) {
            if (map[x][i] != 0) {
                if (map[x][i] == map[x][i + 1]) {
                    num++;
                    if (num >= 5) {
                        System.out.println("win");
                        return true;
                    }
                } else {
                    num = 1;
                }
            }
        }

        // 上下
        num = 1;
        for (int i = 0; i < 14; i++) {
            if (map[i][y] != 0) {
                if (map[i][y] == map[i + 1][y]) {
                    num++;
                    if (num >= 5) {
                        System.out.println("win");
                        return true;
                    }
                } else {
                    num = 1;
                }
            }
        }

        num=1;
        // 右斜 x-1 j+1
        for (int i = 0; i < map.length*2-1; i++) {
            for (int j = 1; j < map.length ; j++) {
                if (((i - j) >= 0) && ((i - j) < map.length)) {
                    if(map[j][i-j]!=0){
                        if(map[j][i-j]==map[j-1][i-j+1]){
                            num++;
                            if (num >= 5) {
                                System.out.println("win");
                                return true;
                            }
                        }else{
                            num=1;
                        }
                    }
                }
            }
        }

        num=1;
        //左斜 x+1 y+1
        for (int i = -map.length; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                if(((i+j)>=0)&&((i+j)<map.length)){
                    if(map[j][j+i]!=0){
                        if(map[j][i+j]==map[j+1][i+j+1]){
                            num++;
                            if (num >= 5) {
                                System.out.println("win");
                                return true;
                            }
                        }else{
                            num=1;
                        }
                    }
                }
            }
        }

        return false;
    }
}
