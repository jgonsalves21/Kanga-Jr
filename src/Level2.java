import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Level2 extends JPanel
{
	
	private Rectangle safeFloor;
	private Lava lava;
	
	private Walls wall1;
	private Walls wall2;
	private Walls wall3;
	private Platform platform1;
	private Platform platform2;
	private Platform platform3;
	private Platform platform4;
	private Platform platform5;
	private Platform platform6;
	private Platform platform7;
	private Platform platform8;
	private Platform platform9;
	private Platform platform10;
	private Platform platform11;
	private Platform platform12;
	private Platform platform13;
	private Platform platform14;
	
	private Hero hero;
	
	public Level2()
	{
		setLayout(null);
		JLabel box = new JLabel("Level 2");
		box.setSize(100, 100);
		add(box);
		
		hero = new Hero();
		hero.setBounds(255,10,50,90);
		add(hero);
		
		safeFloor = new Rectangle(0,630, 100, 90);
		lava = new Lava(100,630, 1280, 90);
		wall1 = new Walls(275, 110, 25, 610);
		
		platform1 = new Platform(225, 580, 60, 20);
		platform2 = new Platform(0, 500, 60, 20);
		platform3 = new Platform(225, 420, 60, 20);
		platform4 = new Platform(0, 340, 60, 20);
		platform5 = new Platform(225, 260, 60, 20);
		platform6 = new Platform(0, 180, 60, 20);
		platform7 = new Platform(255, 100, 60, 10);
		
		if (platform7.isTouched(hero))
		{
			platform8 = new Platform(425, 580, 100, 20);
			platform9 = new Platform(1210, 360, 70, 20);
			platform10 = new Platform(300, 500, 60, 20);
			platform11 = new Platform(425, 420, 100, 20);
			platform12 = new Platform(550, 340, 100, 20);
			platform13 = new Platform(665, 260, 100, 20);
			platform14 = new Platform(1050, 440, 100, 20);
			wall2 = new Walls(785, 200, 200, 200);
			wall3 = new Walls(785, 495, 200, 400);
		}
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(safeFloor);
		g2.fill(wall1);
		g2.fill(platform1);
		g2.fill(platform2);
		g2.fill(platform3);
		g2.fill(platform4);
		g2.fill(platform5);
		g2.fill(platform6);
		g2.fill(platform7);
		if (platform7.isTouched(hero))
		{
			g2.fill(platform8);
			g2.fill(platform9);
			g2.fill(platform10);
			g2.fill(platform11);
			g2.fill(platform12);
			g2.draw(platform13);
			g2.draw(platform14);
			g2.fill(wall2);
			g2.fill(wall3);
		}
		g2.setColor(Color.red);
		g2.fill(lava);
	}
}
