import java.awt.Graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Bullets extends JComponent
{
	private Ellipse2D.Double circle;
	private int dX, dY, startX, startY;
	private Point mouseLocation;
	
	public Bullets(int sX, int sY, Point mL)
	{
		circle = new Ellipse2D.Double(0,0,10, 10);
		dX=0;
		dY=-5;
		startX=sX;
		startY=sY;
		mouseLocation=mL;
	}
	public boolean isTouched(Hero hero)
	{
		if (hero.getX() <= (getX() + getWidth()))
		{
			if ((hero.getX() + hero.getWidth()) >= getX())
			{
				if (hero.getY() <= (getY() + getHeight()))
				{
					if ((hero.getY() + hero.getHeight()) >= getY())
					{
						return true;
					}
				}
			}
		}
		return false;
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
		if (mouseLocation.getX()>startX)
			setLocation(getX()+5, getY());
		else
			setLocation(getX()-5, getY());
	}
	

}
