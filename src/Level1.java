import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Level1 extends Levels implements ActionListener
{
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
	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	private Timer timer;
	private boolean allPlatforms;
	private boolean isJumping = false;
	private int jumpTime = 0;
	private boolean onPlatform = true;
	private int fallSpeed = 1;
	private int delay = 0;

	
	public Level1()
	{
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		hero = new Hero();
		hero.setBounds(1, 260, 50, 80);
		add(hero);
		addPlatform();
		timer = new Timer(16, this);
		timer.start();
		keySensing();
		allPlatforms=false;
		
		
		
		
		
		
		setVisible(true);
	}
	
	public void keySensing()
	{
		int mapName = WHEN_IN_FOCUSED_WINDOW;
		InputMap imap= getInputMap(mapName);
		KeyStroke right = KeyStroke.getKeyStroke('d');
		imap.put(right, "moveR");
		KeyStroke left = KeyStroke.getKeyStroke('a');
		imap.put(left, "moveL");
		KeyStroke up = KeyStroke.getKeyStroke('w');
		imap.put(up, "moveU");
		KeyStroke down = KeyStroke.getKeyStroke('s');
		imap.put(down, "moveD");
		KeyStroke reset = KeyStroke.getKeyStroke('r');
		imap.put(reset, "reset");
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(safeFloor);
		g2.fill(platform1);
		g2.fill(platform2);
		g2.fill(platform3);
		g2.fill(platform4);
		g2.fill(platform5);
		
			g2.fill(platform6);
			g2.fill(platform7);
			g2.fill(platform8);
			g2.fill(platform9);
		
		g2.setColor(Color.red);
		g2.fill(lava);
	}
	public void addPlatform()
	{
		safeFloor = new Rectangle(0,630, 150, 90);
		lava = new Lava(150,630, 1130, 90);
		platform1 = new Platform(150, 550, 180, 25);
		platform2 = new Platform(430, 500, 180, 25);
		platform3 = new Platform(710, 450, 170, 25);
		platform4 = new Platform(990, 400, 180, 25);
		platform5 = new Platform(1200, 325, 100, 25);
		platforms.add(platform1);
		platforms.add(platform2);
		platforms.add(platform3);
		platforms.add(platform4);
		platforms.add(platform5);
		
		platform6 = new Platform(950, 250, 170, 25);
		platform7= new Platform(710, 200, 140, 25);
		platform9 = new Platform(430, 150, 170, 25);
		platform8 = new Platform(150, 100, 170, 25);
		platforms.add(platform6);
		platforms.add(platform7);
		platforms.add(platform8);
		platforms.add(platform9);
	}
	public void checkBounds()
	{
		if (hero.getX() <= 0)
		{
			hero.setLocation(0, hero.getY());
		}
		else if(hero.getX() >= 1200)
		{
			hero.setLocation(1200, hero.getY());
		}
		if (hero.getY() <= 0)
		{
				hero.setDy(3);
		}
		else if(hero.getY() >= 550)
		{
			hero.setLocation(hero.getX(), 550);
			fallSpeed = 1;
			delay = 0;
		}
		
	}
	public void checkWin()
	{
		if(platform8.isTouched(hero))
		{
			if(platform8.getY() >= hero.getY() + 75)
			{
				JLabel gameOver = new JLabel("YOU WON!");
				gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
				gameOver.setBounds(350, 0, 400, 200);
				add(gameOver);
				timer.stop();
				System.out.print(jumpTime);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(lava.isTouched(hero))
		{
			JLabel gameOver = new JLabel("Game Over");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(350, 0, 400, 200);
			add(gameOver);
			timer.stop();
		}
		
		if((hero.getDy() == -5) || hero.getDy() == -3)
		{
			jumpTime ++;
			isJumping = true;
			if (jumpTime == 25)
			{
				jumpTime = 0;
				isJumping = false;
				System.out.println("you made it");
				fallSpeed = 1;
				delay = 0;
			}
			System.out.println(hero.getDy());
		}
		checkWin();
		for(Platform platform: platforms)
		{
			if(platform.isTouched(hero))
			{
				fallSpeed = 1;
				delay = 0;
				if(platform.getY() <= hero.getY())
					hero.setDy(5);
				else if(platform.getY() >= hero.getY() + 60)
					hero.setY(platform.getY() - 80);
				else if(platform.getX() >= hero.getX())
					hero.setDx(0);
				else if(platform.getX() <= hero.getX())
					hero.setDx(0);
			}
			else
			{
			
			}				
		}
		if ((hero.getY() < 550) && !(isJumping))
		{
			hero.setDy(fallSpeed);
			delay ++;
			if (delay %2 == 0)
			{
				fallSpeed++;
			}
		}

		checkBounds();
		hero.update();
		revalidate();
		repaint();
	}
	@Override
	public Hero getHero() {
		// TODO Auto-generated method stub
		return hero;
	}
	@Override
	public ArrayList<Bullets> getBullets() {
		// TODO Auto-generated method stub
		return null;
	}
}
