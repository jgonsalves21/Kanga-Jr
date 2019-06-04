import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Level3 extends JPanel implements ActionListener
{
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
	private int num =1;
	Hero hero;
	private Rectangle safeFloor;
	private Walls wall1;
	private Lava lava;
	
	public Level3()
	{
		setLayout(null);
		Timer timer = new Timer(50, this);
		timer.start();
		hero = new Hero();
		hero.setBounds(30, 20, 50, 90);
		add(hero);
		
		platform1 = new Platform(0, 110, 60, 20);
		platform2 = new Platform(140, 300, 60, 20);
		platform3 = new Platform(200, 550, 60, 20);
		platform4 = new Platform(350, 500, 60, 20);
		platform5 = new Platform(600, 300, 60, 20);
		platform6 = new Platform(500, 500, 60, 20);
		platform7 = new Platform(650, 550, 60, 20);
		platform8 = new Platform(950, 550, 60, 20);
		platform9 = new Platform(1210, 500, 60, 20);
		platform10 = new Platform(1100, 400, 60, 20);
		platform11 = new Platform(950, 300, 60, 20);
		platform12 = new Platform(800, 200, 60, 20);
		platform13 = new Platform(650, 100, 60, 20);
		
		wall1 = new Walls(200, 0, 20, 400);
		lava = new Lava(100, 400, 1000, 20);
		safeFloor = new Rectangle(0,640, 1280, 20);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(platform1);
		g2.fill(platform2);
		g2.fill(platform3);
		g2.fill(platform4);
		g2.fill(platform5);
		g2.fill(platform6);
		g2.fill(platform7);
		g2.fill(platform8);
		g2.fill(platform9);
		g2.fill(platform10);
		g2.fill(platform11);
		g2.fill(platform12);
		g2.fill(platform13);
		g2.fill(wall1);
		g2.fill(safeFloor);
		
		
		g2.setColor(Color.red);
		g2.fill(lava);
	}

	
	
	public void actionPerformed(ActionEvent e) 
	{
		if (platform5.getX() > 450)
			num=-1;
		if(platform5.getX() <300)
			num=1;
		if (num==1)
			platform5.setDx(5);
		else platform5.setDx(-5);
		
		
		
		
		platform5.update();
		
		repaint(platform5);
		repaint();
	}

	

}
