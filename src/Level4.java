import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Level4  extends JPanel{

	private Rectangle safeFloor;
	private Lava lava;
	private Platform platform1;
	private Platform platform2;
	private Platform platform3;
	private Platform platform4;
	private Platform platform5;
	private Platform platform6;
	private Platform platform7;
	private Platform platform8;
	private Platform platform9;
	private Hero hero;
	private Walls wall1;
	
	public Level4()
	{
		setLayout(null);
		JLabel box = new JLabel("Level 4");
		box.setSize(100, 100);
		add(box);
		
		hero = new Hero();
		hero.setBounds(255,10,50,90);
		add(hero);
		
		safeFloor = new Rectangle(0,630, 300, 90);
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(safeFloor);
		
		g2.setColor(Color.red);
		//g2.fill(lava);
	}
}
