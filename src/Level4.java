import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Level4  extends Levels implements ActionListener, MouseListener
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
	private boolean onGround = false;
	private double yVel = 0;
	
	public Level4()
	{
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		keySensing();
		addMouseListener(this);
		
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
		
		platforms.add(platform1);
		platforms.add(platform2);
		platforms.add(platform3);
		platforms.add(platform4);
		platforms.add(platform5);
		platforms.add(platform6);
		platforms.add(platform7);
		platforms.add(safeFloor);
	}
	
	public void addEnemy()
	{
		enemy1 = new Enemy(400,590);
		enemy1.setBounds(400,580,24,30);
		add(enemy1);
		
		enemy2 = new Enemy(370,480);
		enemy2.setBounds(420,320,24,30);
		add(enemy2);
		
		enemies.add(enemy1);
		enemies.add(enemy2);
		
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
		g2.setColor(Color.red);
		g2.fill(lava1);
		g2.fill(lava2);
		
	
	}
	
	public void checkWin()
	{
		//if(platform1.isTouched(hero))
		{
			JLabel gameOver = new JLabel("YOU WON!");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(250, 0, 400, 200);
			add(gameOver);
			timer.stop();
		}
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
				if (wall.getLength() == 20)
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
						hero.setLocation((int)(wall.getX() - 20), hero.getY());
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
					bullets.remove(i);
					enemy.Kill();
					break;
				}
			}
			if (enemy.isTouched(hero))
			{
				JLabel gameOver = new JLabel("Game Over");
				gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
				gameOver.setBounds(250, 50, 400, 50);
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
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		checkBounds();
		updateEnemy();
		
		for(Bullets bullet: bullets)
		{
			bullet.shoot();
			
		}
		checkEnemies();
		checkBullets();
		//checkWin();
		if(lava1.isTouched(hero) || lava2.isTouched(hero))
		{
			JLabel gameOver = new JLabel("Game Over");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(250, 50, 400, 50);
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
	public Hero getHero() {
		return hero;
	}
	@Override
	public ArrayList<Bullets> getBullets() {
		return bullets;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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

