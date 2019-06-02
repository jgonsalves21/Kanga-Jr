import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Hero extends JComponent 
{
	private Ellipse2D.Double head;
	private Rectangle leftArm, rightArm, leftLeg, rightLeg, torso;
	private int dX = 0, dY=0;
	
	public Hero()
	{
		head = new Ellipse2D.Double(15,0,20,20);
		torso = new Rectangle(10,20,30,35);
		leftArm = new Rectangle(0,20,10,10);
		rightArm = new Rectangle(35,20,15,10);
		leftLeg = new Rectangle(10,55,10,35);
		rightLeg = new Rectangle(30,55,10,35);
		
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(head);
		g2.fill(torso);
		g2.fill(leftArm);
		g2.fill(rightArm);
		g2.fill(leftLeg);
		g2.fill(rightLeg);
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