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
		
		safeFloor = new Rectangle(0,630, 330, 90);
		wall1 = new Walls(300,430,30,200);
		platform1 = new Platform(530, 300, 20, 20);
		lava = new Lava(330,630,400,90);
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(safeFloor);
		g2.fill(wall1);
		g2.fill(platform1);
		g2.setColor(Color.red);
		g2.fill(lava);
		
	
	}
}
