
package jiedui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jiedui.main;
import jiedui.window.myThread;
import jiedui.window.continue_one;
import jiedui.window.start;
import jiedui.window.stop;

import javax.swing.JLabel;
import java.awt.FlowLayout;


public class window {
	JFrame win;
	static int speed = 1500;
	static int xibao = 0;
	static int step = 0;
	static JPanel[][] jPanel;
	static int pattern = 1;//moshi1
	static JPanel panel_1;
    static JLabel number;
    static JLabel st;
    static boolean end = true;
    myThread thread = null;
    static main star;
	
	public window (int row,int col) {
		win = new JFrame("game of life");
		jPanel = new JPanel[row][col];
        win.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        win.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        number = new JLabel("Number of remaining lives: "+xibao+"               ");
        panel.add(number);
        
        st = new JLabel("step: "+step);
        panel.add(st);

        panel.setBackground(Color.white);
        panel_1 = new JPanel();
        win.getContentPane().add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(30, 30, 2, 2));
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                jPanel[i][j] = new JPanel();
                jPanel[i][j].setBackground(Color.white);
                panel_1.add(jPanel[i][j]);
            }
        }
        
        win.setLocation(450, 150);
        win.setSize(600, 600); 
        JMenuBar menuBar = new JMenuBar();
        win.setJMenuBar(menuBar);
        JMenu choice = new JMenu("game");
        menuBar.add(choice);
        
        JMenuItem start = new JMenuItem("start");
        choice.add(start);
        start.addActionListener(new start());
        
        JMenuItem continue_one = new JMenuItem("continue");
        choice.add(continue_one);
        continue_one.addActionListener(new continue_one());
        
        JMenuItem stop = new JMenuItem("stop");
        choice.add(stop);
        stop.addActionListener(new stop());
        
        win.setVisible(true);
	}

	class myThread extends Thread{
        public myThread()    {    
        }
        public void run(){
            while(end)
            {
                xibao = 0;
                star.jud.judge();
                try {
                    sleep(speed);
                } catch (InterruptedException e) {
                  
                    e.printStackTrace();
                }
                
                for (int m = 1; m < star.state_one.length - 1; m++)
                {
                    for (int n = 1; n < star.state_one[m].length - 1; n++) 
                    {
                        if (star.state_one[m][n]==true) {
                            xibao ++;
                        }
                    }
                }
                step++;
                number.setText("Number of remaining lives: "+xibao+"               ");
                st.setText("step: "+step);
                
                star.ld.paint();
                
                if (xibao==0) {
                    end = false;
                    JOptionPane.showMessageDialog(null, "生命演化结束：\n"
                            + "        所用步数为"+step);
                }
                
            }
        }
    }

	class start implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
         
            if (pattern==1) {
                star.cs.Init();
            }
         
            star.ld.paint();
            xibao = 0;
            step = 0;
            end = true;

            if (thread != null)  
                thread.stop();  
            thread = new myThread();  
            thread.start();  
        }
    }
	
	 class continue_one implements ActionListener
     {

         @Override
         public void actionPerformed(ActionEvent e) {

             if(thread!=null)
                 thread.stop();
             thread = new myThread();
             thread.start();
         }
         
     }
	 
	 class stop implements ActionListener
     {
         @Override
         public void actionPerformed(ActionEvent e) {

             if (thread != null)  
                 thread.stop();  
             thread = null;  
         }
         
     }
}
