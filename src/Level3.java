import java.awt.Color;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.awt.event.KeyListener;
public class Level3 extends Levels//extends JPanel implements ActionListener, Level
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
	private Hero hero;
	private Platform safeFloor;
	private Walls wall1;
	private Lava lava;
	private Lava lava2;
	private ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private Enemy enemy4;
	private Enemy enemy5;
	private Timer timer;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	private boolean isJumping = false;
	private int jumpTime = 0;
	private boolean onPlatform = true;
	private int fallSpeed = 1;
	private int delay = 0;

	
	public Level3()
	{
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		keySensing();
	
		
		timer = new Timer(16, this);
		timer.start();
		hero = new Hero();
		hero.setBounds(1, 25, 50, 80);
		add(hero);
		addEnemies();
		addPlatforms();
		
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
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(platform1);
		g2.fill(platform2);
		g2.fill(platform3);
		g2.fill(platform4);
		g2.fill(platform6);
		g2.fill(platform7);
		g2.fill(platform8);
		g2.fill(platform9);
		g2.fill(platform10);
		g2.fill(platform11);
		g2.fill(platform12);
		g2.fill(platform13);
		g2.fill(platform14);
		g2.fill(wall1);
		g2.fill(safeFloor);
		g2.setColor(Color.red);
		g2.fill(lava);
		g2.fill(lava2);
		g2.setColor(Color.blue);
		g2.fill(platform5);
		
		
	}
	public void addPlatforms()
	{
		platform1 = new Platform(0, 110, 60, 20);
		platform2 = new Platform(140, 300, 60, 20);
		platform3 = new Platform(800, 600, 60, 20);
		platform4 = new Platform(350, 600, 60, 20);
		platform5 = new Platform(300, 300, 60, 20);
		platform6 = new Platform(500, 540, 60, 20);
		platform7 = new Platform(650, 580, 60, 20);
		platform8 = new Platform(950, 580, 60, 20);
		platform9 = new Platform(1210, 500, 60, 20);
		platform10 = new Platform(1050, 400, 110, 20);
		platform11 = new Platform(950, 325, 60, 20);
		platform12 = new Platform(800, 250, 60, 20);
		platform13 = new Platform(650, 200, 60, 20);
		platform14 = new Platform(1100, 540, 60, 20);
		platforms.add(platform1);
		platforms.add(platform2);
		platforms.add(platform3);
		platforms.add(platform4);
		platforms.add(platform5);
		platforms.add(platform6);
		platforms.add(platform7);
		platforms.add(platform8);
		platforms.add(platform9);
		platforms.add(platform10);
		platforms.add(platform11);
		platforms.add(platform12);
		platforms.add(platform13);
		platforms.add(platform14);
		
		wall1 = new Walls(200, 0, 20, 400);
		lava = new Lava(200, 400, 850, 20);
		lava2 = new Lava(300, 637, 970, 20);
		safeFloor = new Platform(0,637, 300, 20);
		
	}
	public void addEnemies()
	{
		enemy1 = new Enemy(350, 450);
		enemy1.setBounds(350, 550, 24, 30);
		add(enemy1);
		enemy2 = new Enemy(800, 900);
		enemy2.setBounds(800, 200, 24, 30);
		add(enemy2);
		/*enemy3 = new Enemy(650, 750);
		enemy3.setBounds(650, 150, 24, 30);
		add(enemy3);*/
		/*enemy4 = new Enemy(950, 1050);
		enemy4.setBounds(950, 300, 24, 30);
		add(enemy4);*/
		enemy5 = new Enemy(750, 950);
		enemy5.setBounds(750, 500, 24, 30);
		add(enemy5);
		enemies.add(enemy1);
		enemies.add(enemy2);
		//enemies.add(enemy3);
		//enemies.add(enemy4);
		enemies.add(enemy5);
		
	}
	public void movePlatform(Platform platform)
	{
		if (platform.getX() > 450)
			num1=-1;
		if(platform.getX() <300)
			num1=1;
		if (num1==1)
			platform.setDx(5);
		else platform.setDx(-5);
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
	
	public Hero getHero()
	{
		return hero;
	}
	public ArrayList<Bullets> getBullets()
	{
		return bullets;
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
		}
		else if(wall1.isTouched(hero))
		{
			if(hero.getX()<=200)
			{
				hero.setDx(-3);
				hero.setDy(3);
			}
			else
			{
				hero.setDx(3);
				hero.setDy(3);
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
		if(enemies.isEmpty() && platform5.isTouched(hero))
		{
			JLabel gameOver = new JLabel("YOU WON!");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(250, 50, 400, 200);
			add(gameOver);
			timer.stop();
		}
	}
	public void actionPerformed(ActionEvent e) 
	{
		
		movePlatform(platform5);
		moveEnemy(enemy1);
		enemy1.update();
		moveEnemy(enemy2);
		enemy2.update();
		//moveEnemy(enemy3);
		//enemy3.update();
		//moveEnemy(enemy4);
		//enemy4.update();
		moveEnemy(enemy5);
		enemy5.update();
		
		for(Bullets bullet: bullets)
		{
			bullet.shoot();
			
		}
		checkEnemies();
		
		if(lava.isTouched(hero))
		{
			JLabel gameOver = new JLabel("Game Over");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(250, 50, 400, 200);
			add(gameOver);
			timer.stop();
		}
		if(lava2.isTouched(hero))
		{
			JLabel gameOver = new JLabel("Game Over");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(250, 50, 400, 200);
			add(gameOver);
			timer.stop();
		}
		if((hero.getDy() == -5) || hero.getDy() == -3)
		{
			jumpTime ++;
			isJumping = true;
			if (jumpTime == 15)
			{
				jumpTime = 0;
				isJumping = false;
				
				fallSpeed = 1;
			}
			
		}
		for(Platform platform: platforms)
		{
			if(platform.isTouched(hero))
			{
				onPlatform = true;
				fallSpeed = 1;
				if(platform.getY() <= hero.getY())
					hero.setY(platform.getY() + 25);
				else if(platform.getY() >= hero.getY() + 60)
					hero.setY(platform.getY() - 80);
				else if(platform.getX() >= hero.getX())
				{
					hero.setDx(0);
				}
				else if(platform.getX() <= hero.getX())
				{
					hero.setDx(0);
				}
			}
			else
			{
				onPlatform = false;
			}				
		}
		if ((hero.getY() < 550) && !(isJumping) && !onPlatform)
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
		platform5.update();
		repaint(platform5);
		revalidate();
		repaint();
		
	}

	

	

	

}
