import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Walls extends Rectangle
{
	private int length;
	
	
	public Walls(int x,int y,int l,int w)
	{
		length = l;
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
	
	public int getLength()
	{
		return length;
	}

}

