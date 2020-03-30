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
    static xibaozt cs;
    static suanfa jud;
    static show ld;
    static window wind;
    static boolean[][] state_one;
    static JPanel[][] jPanel;

    public main(int row,int col)
    {
        state_one = new boolean[row][col];
        wind = new window(row,col);
        jPanel = wind.jPanel;
    }
    
    //初始函数
    public static void main(String[] args)
    {

            start = new main(30,30);
            cs = new xibaozt(state_one);
            jud = new suanfa(state_one, jPanel);
            ld = new show(state_one, jPanel);
    }
}


