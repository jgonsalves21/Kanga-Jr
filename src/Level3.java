import java.awt.Color;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Level3 extends Levels implements ActionListener,  MouseListener
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
	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private Enemy enemy4;
	private Enemy enemy5;
	private Timer timer;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	private ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	private ArrayList<Walls> walls = new ArrayList<Walls>();
	private boolean onGround = false;
	private double yVel = 0;

	
	public Level3()
	{
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		keySensing();
		addMouseListener(this);
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
		InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "rightpressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "rightreleased");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "leftpressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "leftreleased");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "uppressed");
        

        am.put("rightpressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) 
            {
                hero.setDx(8);
            }
        });

        am.put("rightreleased", new AbstractAction() {
            public void actionPerformed(ActionEvent e) 
            {
                hero.setDx(0);
            }
        });
        am.put("leftpressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) 
            {
                hero.setDx(-8);
            }
        });

        am.put("leftreleased", new AbstractAction() {
            public void actionPerformed(ActionEvent e) 
            {
                hero.setDx(0);
            }
        });
        am.put("uppressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) 
            {
            	System.out.println(onGround);
            	if(onGround) {
	            	onGround = false;
	                yVel = -15;
            	}
                
            }
        });
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
		safeFloor = new Platform(0,637, 300, 20);
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
		platforms.add(safeFloor);
		
		wall1 = new Walls(200, 0, 20, 400);
		walls.add(wall1);
		lava = new Lava(200, 400, 850, 20);
		lava2 = new Lava(300, 637, 970, 20);
		
		
	}
	public void addEnemies()
	{
		enemy1 = new Enemy(350, 450);
		enemy1.setBounds(350, 500, 24, 30);
		add(enemy1);
		enemy2 = new Enemy(800, 900);
		enemy2.setBounds(800, 210, 24, 30);
		add(enemy2);
		enemy3 = new Enemy(650, 750);
		enemy3.setBounds(650, 160, 24, 30);
		add(enemy3);
		enemy4 = new Enemy(950, 1050);
		enemy4.setBounds(950, 290, 24, 30);
		add(enemy4);
		enemy5 = new Enemy(750, 950);
		enemy5.setBounds(750, 500, 24, 30);
		add(enemy5);
		enemies.add(enemy1);
		enemies.add(enemy2);
		enemies.add(enemy3);
		enemies.add(enemy4);
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
				hero.setLocation(hero.getX(),0);
		}
		else if(hero.getY() >= 560)
		{
			hero.setLocation(hero.getX(), 560);
		}
		
		for(Walls wall: walls)
		{
			if(wall.isTouched(hero))
			{
				if (wall.getLength() == 25)
				{
					if(hero.getX()<=wall.getX())
					{
						hero.setLocation((int)(wall.getX() - 51), hero.getY());
					}
					else if(hero.getY() <= wall.getY())
					{
						onGround = true;
					}
					else if(hero.getX() >= wall.getX())
					{
						hero.setLocation((int)(wall.getX() + 26), hero.getY());
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
						onGround = true;
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
			for(int i = bullets.size()-1; i>=0; i--)
			{
				if (enemy.isShot(bullets.get(i)))
				{
					remove(enemy);
					remove(bullets.get(i));
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
	}
	public int checkBullets()
	{
		if(bullets.isEmpty()==true)
		{
			return 0;
		}

		for (int i= bullets.size()-1; i>=0; i--)
		{
			for(Walls wall: walls)
			{
				if(wall.isShot(bullets.get(i)))
				{
					remove(bullets.get(i));
					bullets.remove(bullets.get(i));
					return 0;
				}
			}

		}
		if(bullets.isEmpty()==true)
		{
			return 0;
		}
		for (int i= bullets.size()-1; i>=0; i--)
		{
			for(Platform platform: platforms)
			{
				if(platform.isShot(bullets.get(i)))
				{
					remove(bullets.get(i));
					bullets.remove(bullets.get(i));
					return 0;
				}
			}

		}
		return 0;		
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		
		movePlatform(platform5);
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
		
		for(Bullets bullet: bullets)
		{
			bullet.shoot();
			
		}
		checkEnemies();
		checkBullets();
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
		onGround=false;
		for(Platform platform: platforms)
		{
			
			if(platform.isTouched(hero) && yVel >= 0)
			{
				
				if(platform.getY() >= hero.getY() + 70)
				{
					hero.setY(platform.getY() - 80);
					onGround = true;
				}
				else if(platform.getX() >= hero.getX()-5)
				{
					hero.setDx(0);
					hero.setLocation((int)(platform.getX()-55), hero.getY());
				}
					
				else if(platform.getX() <= hero.getX())
					hero.setDx(0);
			}
			else if ((platform.isTouched(hero) && yVel <= 0))
			{
				if((platform.getY() + 1 <= hero.getY()) && (platform.getY() + 20 >= hero.getY()))
				{
					yVel = 0;
				}
					
			}
		}
		
		if(onGround) 
		{
			yVel = 0;
		}
		if ((hero.getY() < 550) && !onGround)
		{
			yVel += 1;
			
		}
		if(yVel > 10)
			yVel=10;
		hero.setDy(yVel);
		System.out.println(onGround);
		checkBounds();
		hero.update();
		revalidate();
		repaint();
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
		Bullets nbullet = new Bullets(hero.getX()+25, hero.getY()+45, mouseLocation);
		nbullet.setBounds(hero.getX()+25, hero.getY()+45, 10, 10);
		bullets.add(nbullet);
		add(nbullet);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	

	

}

