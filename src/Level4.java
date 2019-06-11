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

	private Platform safeFloor;
	private Lava lava1;
	private Lava lava2;
	private Platform platform1;
	private Platform platform2;
	private Platform platform3;
	private Platform platform4;
	private Platform platform5;
	private Platform platform6;
	private Platform platform7;
	private Platform platform8;
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
	private int fallSpeed;
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
		hero.setBounds(0,50,50,80);
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
		safeFloor = new Platform(0,630, 1280, 90);
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
		platform8 = new Platform(1180,150,100,10);
		
		platforms.add(platform1);
		platforms.add(platform2);
		platforms.add(platform3);
		platforms.add(platform4);
		platforms.add(platform5);
		platforms.add(platform6);
		platforms.add(platform7);
		platforms.add(platform8);
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
	
	public void updateEnemy()
	{
		moveEnemy(enemy1);
		enemy1.update();
		moveEnemy(enemy2);
		enemy2.update();
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
		g2.fill(platform8);
		g2.setColor(Color.red);
		g2.fill(lava1);
		g2.fill(lava2);
		
	
	}
	
	public void checkWin()
	{
		if(platform8.isTouched(hero))
		{
			JLabel gameOver = new JLabel("YOU WON!");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(100, 0, 400, 200);
			add(gameOver);
			timer.stop();
		}
	}
	
	public void checkBounds()
	{
		if (hero.getX() <= 0)
		{
				hero.setDx(3);
		}
		else if(hero.getX() >= 1200)
		{
			hero.setDx(-3);
		}
		if (hero.getY() <= 0)
		{
				hero.setDy(3);
		}
		else if(hero.getY() >= 680)
		{
			hero.setLocation(hero.getX(), 680);
		}
		for (Walls wall : walls)
		{
			if (wall.isTouched(hero))
			{
				if(hero.getX()< wall.getX())
				{
						hero.setDx(-3);
				}
				else hero.setDx(3);
					
			}
		}
	}
	
	public void checkEnemies()
	{
		for (int i=enemies.size()-1; i>=0; i--)
		{
			for(int j = bullets.size()-1; j>=0; j--)
			{
				if (enemies.get(i).isShot(bullets.get(j)))
				{
					
					remove(enemies.get(i));
					remove(bullets.get(j));
					bullets.remove(j);
					enemies.remove(i);
					break;
				}
			}
			
		}
		for (int i=enemies.size()-1; i>=0; i--)
		{
			if(enemies.get(i).isTouched(hero))
			{
				JLabel gameOver = new JLabel("Game Over");
				gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
				gameOver.setBounds(150, 0, 400, 50);
				add(gameOver);
				timer.stop();
			}
		}
		for(int j = bullets.size()-1; j>=0; j--)
		{
			if(bullets.get(j).getX() <=0)
			{
				remove(bullets.get(j));
				bullets.remove(j);
				
			}
				
			else if(bullets.get(j).getX() >=1250)
			{
				remove(bullets.get(j));
				bullets.remove(j);
			}
				
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		updateEnemy();
		
		for (Bullets bullet: bullets)
		{
			bullet.shoot();
		}
		
		checkEnemies();
		if(lava1.isTouched(hero) || lava2.isTouched(hero))
		{
			JLabel gameOver = new JLabel("Game Over");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(50, 50, 400, 50);
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
			}
		}
		int fallSpeed = 1;
		for(Platform platform: platforms)
		{
			if(platform.isTouched(hero))
			{
				onPlatform = true;
				fallSpeed = 1;
				delay = 0;
				if(platform.getY() <= hero.getY())
					hero.setDy(3);
				else if(platform.getY() >= hero.getY() - 80)
					hero.setY(platform.getY() - 80);
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
		if ((hero.getY() < 660) && !(isJumping) && !(onPlatform))
		{
			hero.setDy(fallSpeed);
			delay ++;
			if (delay %2 == 0)
			{
				fallSpeed++;
			}
		}
		checkWin();
		checkBounds();
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
