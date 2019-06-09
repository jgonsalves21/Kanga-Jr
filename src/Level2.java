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

public class Level2 extends Levels implements ActionListener
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
	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private Enemy enemy4;
	private Enemy enemy5;
	private Timer timer;
	private boolean showAll;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	private ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	private ArrayList<Walls> walls = new ArrayList<Walls>();
	
	private Hero hero;
	
	public Level2()
	{
		
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		keySensing();
		
		timer = new Timer(16, this);
		timer.start();
		hero = new Hero();
		showAll=false;
		hero.setBounds(255,10,50,90);
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
		safeFloor = new Rectangle(0,630, 100, 90);
		lava = new Lava(100,630, 1280, 90);
		
		platform1 = new Platform(225, 580, 60, 20);
		platform2 = new Platform(0, 500, 60, 20);
		platform3 = new Platform(225, 420, 60, 20);
		platform4 = new Platform(0, 340, 60, 20);
		platform5 = new Platform(225, 260, 60, 20);
		platform6 = new Platform(0, 180, 60, 20);
		platform7 = new Platform(255, 100, 60, 10);
		platform8 = new Platform(425, 580, 100, 20);
		platform9 = new Platform(1210, 360, 70, 20);
		platform10 = new Platform(300, 500, 60, 20);
		platform11 = new Platform(425, 420, 100, 20);
		platform12 = new Platform(550, 340, 100, 20);
		platform13 = new Platform(665, 260, 100, 20);
		platform14 = new Platform(1050, 440, 100, 20);
		
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
		
		wall1 = new Walls(275, 110, 25, 610);
		wall2 = new Walls(785, 200, 200, 200);
		wall3 = new Walls(785, 495, 200, 400);
		walls.add(wall1);
		walls.add(wall2);
		walls.add(wall3);
		
	}
	public void addEnemy()
	{
		enemy1= new Enemy(400, 500);
		enemy1.setBounds(400, 300, 24, 30);
		enemies.add(enemy1);
		add(enemy1);
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
		g2.fill(platform1);
		g2.fill(platform2);
		g2.fill(platform3);
		g2.fill(platform4);
		g2.fill(platform5);
		g2.fill(platform6);
		g2.fill(platform7);
		if (showAll)
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
		else if(hero.getY() >= 550)
		{
			hero.setLocation(hero.getX(), 550);
		}
		for(Walls wall: walls)
		{
			if(wall.isTouched(hero))
			{
				if(hero.getX()<=wall.getX())
				{
					hero.setDx(-3);
					hero.setDy(-3);
				}
				else if(hero.getY() <= wall.getY())
				{
					hero.setDy(-3);
				}
				else if(hero.getX() >= wall.getX())
				{
					hero.setDx(3);
				}
			}
			
		}
		for(Platform platform: platforms)
		{
			if(platform.isTouched(hero))
			{
				if(platform == platform1)
					break;
				if(platform==platform2)
				{
					hero.setDx(-3);
					hero.setDy(-3);
				}
				if(platform.getY() >= hero.getY())
					hero.setDy(-3);
				if(platform.getY() <= hero.getY())
					hero.setDy(3);
				if(platform.getX() >= hero.getX())
					hero.setDx(-3);
				if(platform.getX() <= hero.getX())
					hero.setDx(3);
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

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		moveEnemy(enemy1);
		enemy1.update();
		for(Bullets bullet: bullets)
		{
			bullet.shoot();
			
		}
		checkEnemies();
		if(platform7.isTouched(hero))
			showAll=true;
		checkBounds();
		if(lava.isTouched(hero))
		{
			JLabel gameOver = new JLabel("Game Over");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(50, 50, 400, 200);
			add(gameOver);
			timer.stop();
		}
		hero.update();
		revalidate();
		repaint();
		
		
	}

	@Override
	public Hero getHero() 
	{
		// TODO Auto-generated method stub
		return hero;
	}

	@Override
	public ArrayList<Bullets> getBullets() 
	{
		// TODO Auto-generated method stub
		return bullets;
	}
}
