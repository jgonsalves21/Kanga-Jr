import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Platform extends Rectangle
{
	
	public Platform(int x,int y,int l,int w)
	{
		setLocation(x,y);
		setSize(l, w);
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
}
