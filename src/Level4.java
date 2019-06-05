import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Level4  extends JPanel{

	private Rectangle safeFloor;
	private Lava lava;
	private Lava lava2;
	private Platform platform1;
	private Platform platform2;
	private Platform platform3;
	private Platform platform4;
	private Platform platform5;
	private Hero hero;
	private Walls wall1;
	private Walls wall2;
	
	public Level4()
	{
		setLayout(null);
		JLabel box = new JLabel("Level 4");
		box.setSize(100, 100);
		add(box);
		
		hero = new Hero();
		hero.setBounds(255,10,50,90);
		add(hero);
		
		safeFloor = new Rectangle(0,630, 330, 90);
		wall1 = new Walls(300,430,30,200);
		platform1 = new Platform(530, 300, 20, 20);
		lava = new Lava(330,630,370,90);
		platform2 = new Platform(730,630,115,90);
		wall2 = new Walls(700,430,30,230);
		lava2 = new Lava(815,630,350,90);
		platform3 = new Platform(1165,630,200,90);
		platform4 = new Platform(700,225,450,20);
		platform5 = new Platform(475,500,100,20);
		
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(safeFloor);
		g2.fill(wall1);
		g2.fill(platform1);
		g2.fill(platform2);
		g2.fill(wall2);
		g2.fill(platform3);
		g2.fill(platform4);
		g2.fill(platform5);
		//if(platform )
		g2.setColor(Color.red);
		g2.fill(lava);
		g2.fill(lava2);
		
	
	}
}
