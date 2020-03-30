package jiedui;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jiedui.xibaozt;
import jiedui.suanfa;
import jiedui.show;
import jiedui.window;
import jiedui.main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class main extends Thread {
	static main start;
    static xibaozt init_data;
    static suanfa judge;
    static show set_color;
    static window frame;
    //存放细胞状态
    static boolean[][] state_one;
    static JPanel[][] jPanel;
    //初始化GUI界面
    public main(int row,int col)
    {
        state_one = new boolean[row][col];
        frame = new window(row,col);
        jPanel = frame.jPanel;
    }
    
    //主函数
    public static void main(String[] args)
    {
        //创建游戏对象
            start = new main(30,30);
            init_data = new xibaozt(state_one);
            judge = new suanfa(state_one, jPanel);
            set_color = new show(state_one, jPanel);
    }
}


