import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Platform extends Rectangle
{
	private int dX;
	private int dY;
	private int direction;
	
	public Platform(int x,int y,int l,int w)
	{
		setLocation(x,y);
		setSize(l, w);
		dX=0;
		dY=0;
		direction=1;
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
	public void setDx(int x)
	{
		dX=x;
	}
	public void setDy(int y)
	{
		dY=y;
	}
	
	public void update()
	{
		
		setLocation((int)getX()+dX, (int)getY()+dY);
	}
	
}

