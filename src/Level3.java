import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
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
	private int num1 =1;
	private int num2 =1;
	private Hero hero;
	private Rectangle safeFloor;
	private Walls wall1;
	private Lava lava;
	private ArrayList <Enemy> enemies = new ArrayList<Enemy>();
	private Enemy enemy1;
	
	public Level3()
	{
		setLayout(null);
		Timer timer = new Timer(16, this);
		timer.start();
		hero = new Hero();
		hero.setBounds(350, 420, 50, 90);
		add(hero);
		/**
		for (int i=0; i<2; i++)
		{
			enemies.add(new Enemy());
		}
		
		enemies.get(0).setBounds(350, 600, 24, 30);
		add(enemies.get(0));
		enemies.get(1).setBounds(600, 600, 24, 30);
		add(enemies.get(1));**/
		enemy1 = new Enemy();
		enemy1.setBounds(350, 600, 24, 30);
		add(enemy1);
		
		platform1 = new Platform(0, 110, 60, 20);
		platform2 = new Platform(140, 300, 60, 20);
		platform3 = new Platform(200, 550, 60, 20);
		platform4 = new Platform(350, 510, 60, 20);
		platform5 = new Platform(300, 300, 60, 20);
		platform6 = new Platform(500, 510, 60, 20);
		platform7 = new Platform(650, 550, 60, 20);
		platform8 = new Platform(950, 550, 60, 20);
		platform9 = new Platform(1210, 500, 60, 20);
		platform10 = new Platform(1100, 400, 60, 20);
		platform11 = new Platform(950, 300, 60, 20);
		platform12 = new Platform(800, 200, 60, 20);
		platform13 = new Platform(650, 100, 60, 20);
		
		Bullets bullet = new Bullets();
		bullet.setBounds(800, 300, 20, 20);
		add(bullet);
		
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
			num1=-1;
		if(platform5.getX() <300)
			num1=1;
		if (num1==1)
			platform5.setDx(5);
		else platform5.setDx(-5);
		
		if (enemy1.getX() > 450)
			num2=-1;
		if(enemy1.getX() <350)
			num2=1;
		if (num2==1)
			enemy1.setDx(5);
		else enemy1.setDx(-5);
		
		enemy1.update();
		
		platform5.update();
		repaint(platform5);
		revalidate();
		repaint();
		
	}

	

}

