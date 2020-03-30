package jiedui;
import java.util.Random;

public class xibaozt {
	static boolean[][] dot;
	static int rand;
 
	public void Init() {
		for(int i=1;i<dot.length;i++)
        {
            for(int j=1;j<dot[i].length-1;j++)
            {
            	rand = (int) (Math.random()*100);
                if (rand<50) {
                    dot[i][j] = false;
                }
                else
                    dot[i][j] = true;
            }
        }
	}
	
	 public xibaozt(boolean[][] state_one)
	    {
	        dot = state_one;
	    }
	
}
