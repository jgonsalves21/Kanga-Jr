import java.awt.Graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Bullets extends JComponent
{
	private Ellipse2D.Double circle;
	private int dX, dY;
	
	public Bullets()
	{
		circle = new Ellipse2D.Double(0,0,10, 10);
		dX=0;
		dY=0;
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(circle);
		
	}
	
	public void setDx(int x)
	{
		dX=x;
	}
	public void setDy(int y)
	{
		dY=y;
	}
	public void shoot()
	{
		setLocation((int)getX()+dX, (int)getY()+dY);
	}
	

}
