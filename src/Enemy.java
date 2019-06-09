import javax.swing.JComponent;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;


public class Enemy extends JComponent
{
	private Rectangle head, leg1, leg2, leg3, eye1, eye2;
	private int dX, dY, leftBound, rightBound;
	private int direction;
	private boolean isAlive;
	
	public Enemy(int left, int right)
	{
		head = new Rectangle(0, 0, 24, 24);
		leg1 = new Rectangle(0, 24, 6, 6);
		leg2 = new Rectangle(9, 24, 6, 6);
		leg3 = new Rectangle(18, 24, 6, 6);
		eye1 = new Rectangle(6, 6, 4, 4);
		eye2 = new Rectangle(14, 6, 4, 4);
		leftBound=left;
		rightBound=right;
		direction=1;
		isAlive=true;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(head);
		g2.fill(leg1);
		g2.fill(leg2);
		g2.fill(leg3);
		g2.setColor(Color.white);
		g2.fill(eye1);
		g2.fill(eye2);
	}
	
	public void setDx(int x)
	{
		dX=x;
	}
	public void setDy(int y)
	{
		dY=y;
	}
	public boolean isShot(Bullets bullet)
	{
		if (bullet.getX() <= (getX() + getWidth()))
		{
			if ((bullet.getX() + bullet.getWidth()) >= getX())
			{
				if (bullet.getY() <= (getY() + getHeight()))
				{
					if ((bullet.getY() + bullet.getHeight()) >= getY())
					{
						return true;
					}
				}
			}
		}
		return false;
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
	public void changeDirection()
	{
		direction*=-1;
	}
	public int getDirection()
	{
		return direction;
	}
	public int getLeft()
	{
		return leftBound;
	}
	public int getRight()
	{
		return rightBound;
	}
	public void update()
	{
		setLocation((int)getX()+dX, (int)getY()+dY);
	}
	public void Kill()
	{
		isAlive=false;
	}
	public boolean lifeStatus()
	{
		return isAlive;
	}

}
