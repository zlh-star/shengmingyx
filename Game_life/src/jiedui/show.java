package jiedui;
import java.awt.Color;
import javax.swing.JPanel;

public class show {
	static boolean [][] state_one;
    static JPanel[][] jPanel;
    //初始化类
    public show(boolean [][] state,JPanel[][] jpanel_one)
    {
        state_one = state;
        jPanel = jpanel_one;
    }
    //设置各种颜色
    public static void paint()
    {
            
        //循环判断状态设置颜色
        for(int i=1;i<state_one.length;i++)
        {
            for(int j=1;j<state_one[i].length-1;j++)
            {
                if (state_one[i][j]) {
                jPanel[i][j].setBackground(Color.black);
                }
                else{
                    jPanel[i][j].setBackground(Color.white);
                }
            }
        }
    }

}
