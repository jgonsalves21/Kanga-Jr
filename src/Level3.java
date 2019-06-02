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
	
	Hero hero;
	private Rectangle safeFloor;
	private Walls wall1;
	private Lava lava;
	
	public Level3()
	{
		setLayout(null);
		Timer timer = new Timer(500, this);
		timer.start();
		hero = new Hero();
		hero.setBounds(0, 20, 50, 90);
		add(hero);
		
		platform1 = new Platform(0, 110, 60, 20);
		platform2 = new Platform(140, 300, 60, 20);
		platform3 = new Platform(200, 550, 60, 20);
		platform4 = new Platform(350, 500, 60, 20);
		platform5 = new Platform(600, 300, 60, 20);
		
		wall1 = new Walls(200, 0, 20, 400);
		lava = new Lava(100, 400, 1000, 20);
		safeFloor = new Rectangle(0,640, 1280, 20);
		
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(platform1);
		g2.fill(platform2);
		g2.fill(platform3);
		g2.fill(platform4);
		g2.fill(platform5);
		
		g2.fill(wall1);
		g2.fill(safeFloor);
		
		
		g2.setColor(Color.red);
		g2.fill(lava);
	}

	
	
	public void actionPerformed(ActionEvent e) 
	{
		hero.setDx(5);
		hero.update();
		repaint();
		revalidate();
		
	}

	

}
