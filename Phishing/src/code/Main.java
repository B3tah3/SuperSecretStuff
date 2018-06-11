package code;
import java.awt.AWTException;


public class Main {
	
	Frame f;
	
	public static void main(String[] args) throws AWTException 
	{
		Frame f = new Frame();
		while(true)
		{
			f.toFront();
			f.requestFocus();
			f.validate();
			f.setVisible(true);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			f.repaint();		
		}
	}
}
