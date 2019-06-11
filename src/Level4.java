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

public class Level4  extends Levels implements ActionListener
{

	private Rectangle safeFloor;
	private Lava lava1;
	private Lava lava2;
	private Platform platform1;
	private Platform platform2;
	private Platform platform3;
	private Platform platform4;
	private Platform platform5;
	private Platform platform6;
	private Platform platform7;
	private Timer timer;
	private boolean showAll;
	private Hero hero;
	private Walls wall1;
	private Walls wall2;
	private Walls wall3;
	private Walls wall4;
	private Enemy enemy1;
	private Enemy enemy2;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	private ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	private ArrayList<Walls> walls = new ArrayList<Walls>();
	private boolean isJumping = false;
	private int jumpTime = 0;
	private boolean onPlatform = true;
	private int fallSpeed2 = 1;
	private int delay = 0;
	
	public Level4()
	{
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		keySensing();
		
		timer = new Timer(16, this);
		timer.start();
		hero = new Hero();
		showAll=false;
		hero.setBounds(0,550,50,80);
		add(hero);
		addPlatform();
		addEnemy();
	}	
	
	public void keySensing()
	{
		int mapName = WHEN_IN_FOCUSED_WINDOW;
		InputMap imap= getInputMap(mapName);
		KeyStroke right = KeyStroke.getKeyStroke('d');
		imap.put(right, "moveR");
		KeyStroke left = KeyStroke.getKeyStroke('a');
		imap.put(left, "moveL");
		KeyStroke space = KeyStroke.getKeyStroke(' ');
		imap.put(space, "shoot");
		KeyStroke up = KeyStroke.getKeyStroke('w');
		imap.put(up, "moveU");
		KeyStroke down = KeyStroke.getKeyStroke('s');
		imap.put(down, "moveD");
		KeyStroke reset = KeyStroke.getKeyStroke('r');
		imap.put(reset, "reset");
	}
	
	public void addPlatform()
	{
		safeFloor = new Rectangle(0,630, 1280, 90);
		lava1 = new Lava(300,0,60,370);
		lava2 = new Lava(300,525,60,160);
		
		wall1 = new Walls(650,150,30,530);
		wall2 = new Walls(360,0,10,370);
		wall3 = new Walls(360,525,10,160);
		wall4 = new Walls(500,360,10,150);
		walls.add(wall1);
		walls.add(wall2);
		walls.add(wall3);
		walls.add(wall4);
		
		platform1 = new Platform(360,360,150,10);
		platform2 = new Platform(600,550,50,10);
		platform3 = new Platform(500,475,50,10);
		platform4 = new Platform(600,400,50,10);
		platform5 = new Platform(360,250,50,10);
		platform6 = new Platform(480,200,50,10);
		platform7 = new Platform(600,150,50,10);
		
		platforms.add(platform1);
		platforms.add(platform2);
		platforms.add(platform3);
		platforms.add(platform4);
		platforms.add(platform5);
		platforms.add(platform6);
		platforms.add(platform7);
	}
	
	public void addEnemy()
	{
		enemy1 = new Enemy(400,590);
		enemy1.setBounds(400,580,24,30);
		add(enemy1);
		
		enemy2 = new Enemy(370,480);
		enemy2.setBounds(420,320,24,30);
		add(enemy2);
		
	}
	
	public void moveEnemy(Enemy enemy)
	{
		if (enemy.getX() > enemy.getRight())
			enemy.changeDirection();
		if(enemy.getX() <enemy.getLeft())
			enemy.changeDirection();
		if (enemy.getDirection()==1)
			enemy.setDx(5);
		else enemy.setDx(-5);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(safeFloor);
		
		g2.fill(wall1);
		g2.fill(wall2);
		g2.fill(wall3);
		g2.fill(wall4);
		
		g2.fill(platform1);
		g2.fill(platform2);
		g2.fill(platform3);
		g2.fill(platform4);
		g2.fill(platform5);
		g2.fill(platform6);
		g2.fill(platform7);
		g2.setColor(Color.red);
		g2.fill(lava1);
		g2.fill(lava2);
		
	
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
			fallSpeed2 = 1;
		}
		for(Walls wall: walls)
		{
			if(wall.isTouched(hero))
			{
				if (wall.getLength() == 25)
				{
					if(hero.getX()<=wall.getX())
					{
						hero.setLocation((int)(wall.getX() - 50), hero.getY());
					}
					else if(hero.getY() <= wall.getY())
					{
						hero.setDy(-3);
					}
					else if(hero.getX() >= wall.getX())
					{
						hero.setLocation((int)(wall.getX() + 25), hero.getY());
					}
				}
				else 
				{
					if(hero.getX()<=wall.getX())
					{
						hero.setLocation((int)(wall.getX() - 50), hero.getY());
					}
					else if(hero.getY() <= wall.getY())
					{
						hero.setDy(-3);
					}
					else if(hero.getX() >= wall.getX())
					{
						hero.setLocation((int)(wall.getX() + 200), hero.getY());
					}
				}
			}
			
		}
		
	}
	public void checkEnemies()
	{
		for (Enemy enemy: enemies)
		{
			for(Bullets bullet : bullets)
			{
				if (enemy.isShot(bullet))
				{
					remove(enemy);
					remove(bullet);
					enemy.Kill();
					break;
				}
			}
			if (enemy.isTouched(hero))
			{
				JLabel gameOver = new JLabel("Game Over");
				gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
				gameOver.setBounds(250, 50, 400, 200);
				add(gameOver);
				timer.stop();
			}
			
		}
		for (int i= enemies.size()-1; i>=0; i--)
		{
			if(!enemies.get(i).lifeStatus())
				enemies.remove(i);
		}
		//if(platform9.isTouched(hero) && (enemies.size() <5))
		{
			JLabel gameOver = new JLabel("YOU WON!");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(250, 50, 400, 200);
			add(gameOver);
			timer.stop();
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		moveEnemy(enemy1);
		enemy1.update();
		moveEnemy(enemy2);
		enemy2.update();
		repaint();
		for(Bullets bullet: bullets)
		{
			bullet.shoot();
			
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
			fallSpeed2 = 1;
		}
		System.out.println(hero.getDy());
	}
	for(Platform platform: platforms)
	{
		if(platform.isTouched(hero))
		{
			onPlatform = true;
			fallSpeed2 = 1;
			if(platform.getY() <= hero.getY())
				hero.setY(platform.getY() + 25);
			else if(platform.getY() >= hero.getY())
				hero.setY(platform.getY() - 90);
			else if(platform.getX() >= hero.getX())
				hero.setDx(0);
			else if(platform.getX() <= hero.getX())
				hero.setDx(0);
		}
		else
		{
			onPlatform = false;
		}				
	}
	if ((hero.getY() < 550) && !(isJumping) && !onPlatform)
	{
		hero.setDy(fallSpeed2);
		delay ++;
		if (delay %2 == 0)
		{
			fallSpeed2++;
		}
	}
	hero.update();
	revalidate();
	repaint();
	
	
}
	@Override
	public Hero getHero() {
		return hero;
	}
	@Override
	public ArrayList<Bullets> getBullets() {
		return bullets;
	}
}
