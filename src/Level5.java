import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Level5 extends Levels implements ActionListener
{
	private Hero hero;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	private ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	private ArrayList<Walls> walls = new ArrayList<Walls>();
	private Timer timer;
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
	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private Enemy enemy4;
	private Enemy enemy5;
	private Enemy enemy6;
	private Enemy enemy7;
	private Enemy enemy8;
	private Walls wall1;
	private Walls wall2;
	private Walls wall3;
	private Walls wall4;
	private Walls wall5;
	private Walls wall6;
	private Lava lava;
	private boolean isJumping = false;
	private int jumpTime = 0;
	private boolean onPlatform = true;
	private int fallSpeed = 1;
	private int delay = 0;
	
	
	public Level5()
	{
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		timer = new Timer(16, this);
		timer.start();
		hero= new Hero();
		hero.setBounds(520, 280, 50, 80);
		add(hero);
		addPlatforms();
		addEnemy();
		keySensing();
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
		g2.fill(platform5);
		g2.fill(platform6);
		g2.fill(platform7);
		g2.fill(platform8);
		g2.fill(platform9);
		g2.fill(platform10);
		g2.fill(platform11);
		g2.fill(wall1);
		g2.fill(wall2);
		g2.fill(wall3);
		g2.fill(wall4);
		g2.fill(wall5);
		g2.fill(wall6);
		g2.setColor(Color.red);
		g2.fill(lava);
		g2.setColor(Color.blue);
		g2.fill(platform12);
	}
	
	public void addPlatforms()
	{
		lava = new Lava(0, 640, 1280, 20);
		platform1 = new Platform(300, 360, 480, 20);
		platform2 = new Platform(480, 250, 120, 20);
		platform3 = new Platform(780, 150, 250, 20);
		platform4 = new Platform(170, 150, 150, 20);
		platform5 = new Platform(1200, 250, 80, 20);
		platform6 = new Platform(0, 250, 60, 20);
		platform7 = new Platform(100, 560, 60, 20);
		platform8 = new Platform(1100, 560, 60, 20);
		platform9 = new Platform(300, 500, 100, 20);
		platform10 = new Platform(800, 500, 100, 20);
		platform11 = new Platform(500, 550, 100, 20);
		platform12 = new Platform(900, 350, 80, 20);
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
		wall1 = new Walls(300, 160, 20, 200);
		wall2 = new Walls(780, 160, 20, 220);
		wall3 = new Walls(580, 0, 20, 250);
		wall4 = new Walls(480, 0, 20, 250);
		wall5 = new Walls(1010, 150, 20, 250);
		wall6 = new Walls(160, 150, 20, 250);
		walls.add(wall1);
		walls.add(wall2);
		walls.add(wall3);
		walls.add(wall4);
		walls.add(wall5);
		walls.add(wall6);
	}
	public void checkWin()
	{
		if(platform12.isTouched(hero))
		{
			JLabel gameOver = new JLabel("YOU WON!");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(250, 0, 400, 200);
			add(gameOver);
			timer.stop();
		}
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
	public void addEnemy()
	{
		enemy1= new Enemy(330, 400);
		enemy1.setBounds(330, 300, 24, 30);
		enemy2= new Enemy(5, 105);
		enemy2.setBounds(5, 450, 24, 30);
		enemy3= new Enemy(5, 105);
		enemy3.setBounds(5, 100, 24, 30);
		enemy4= new Enemy(200, 300);
		enemy4.setBounds(200, 100, 24, 30);
		enemy5 = new Enemy(800, 850);
		enemy5.setBounds(800, 100, 24, 30);
		enemy6= new Enemy(1050, 1150);
		enemy6.setBounds(1050, 400, 24, 30);
		enemy7= new Enemy(450, 550);
		enemy7.setBounds(450, 450, 24, 30);
		enemy8= new Enemy(1050, 1100);
		enemy8.setBounds(1050, 150, 24, 30);
		add(enemy1);
		add(enemy2);
		add(enemy3);
		add(enemy4);
		add(enemy5);
		add(enemy6);
		add(enemy7);
		add(enemy8);
		enemies.add(enemy1);
		enemies.add(enemy2);
		enemies.add(enemy3);
		enemies.add(enemy4);
		enemies.add(enemy5);
		enemies.add(enemy6);
		enemies.add(enemy7);
		enemies.add(enemy8);
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
			if (enemies.get(i).isTouched(hero))
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
	public void updateEnemy()
	{
		moveEnemy(enemy1);
		enemy1.update();
		moveEnemy(enemy2);
		enemy2.update();
		moveEnemy(enemy3);
		enemy3.update();
		moveEnemy(enemy4);
		enemy4.update();
		moveEnemy(enemy5);
		enemy5.update();
		moveEnemy(enemy6);
		enemy6.update();
		moveEnemy(enemy7);
		enemy7.update();
		moveEnemy(enemy8);
		enemy8.update();

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
		if(lava.isTouched(hero))
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
	public Hero getHero() 
	{
		
		return hero;
	}

	@Override
	public ArrayList<Bullets> getBullets() 
	{
		
		return bullets;
	}

}
