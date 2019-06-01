import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Level1 extends JPanel
{
	private Rectangle floor;
	private Platform platform1;
	private Platform platform2;
	private Platform platform3;
	private Platform platform4;
	private Platform platform5;
	private Platform platform6;
	private Platform platform7;
	private Platform platform8;
	private Platform platform9;
	private Rectangle rect;
	private Hero hero;
	
	public Level1()
	{
		setLayout(null);
		JLabel box = new JLabel("Level 1");
		box.setSize(100, 100);
		add(box);
		
		floor = new Rectangle(0,630, 1280, 90);
		
		platform1 = new Platform(150, 550, 200, 25);
		platform2 = new Platform(430, 500, 200, 25);
		platform3 = new Platform(710, 450, 200, 25);
		platform4 = new Platform(990, 400, 200, 25);
		platform5 = new Platform(1200, 350, 100, 25);
		
		hero = new Hero();
		hero.setBounds(1200, 260, 50, 90);
		add(hero);
		
		if (platform5.isTouched(hero))
		{
			platform6 = new Platform(990, 300, 200, 25);
			platform7= new Platform(710, 250, 200, 25);
			platform9 = new Platform(430, 200, 200, 25);
			platform8 = new Platform(150, 150, 200, 25);
			
		}
		
		setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(floor);
		g2.fill(platform1);
		g2.fill(platform2);
		g2.fill(platform3);
		g2.fill(platform4);
		g2.fill(platform5);
		if (platform5.isTouched(hero))
		{
			g2.fill(platform6);
			g2.fill(platform7);
			g2.fill(platform8);
			g2.fill(platform9);
		}
	}
}
