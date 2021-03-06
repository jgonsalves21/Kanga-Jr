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

public class Level2 extends Levels implements ActionListener, MouseListener
{
	
	private Platform safeFloor;
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
	private Platform platform15;
	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private Enemy enemy4;
	private Enemy enemy5;
	private Enemy enemy6;
	private Enemy enemy7;
	private Enemy enemy8;
	private Enemy enemy9;
	private Enemy enemy10;
	private Timer timer;
	private boolean showAll;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	private ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	private ArrayList<Walls> walls = new ArrayList<Walls>();
	private boolean onGround = false;
	private double yVel = 0;
	
	private Hero hero;
	
	public Level2()
	{
		
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		addMouseListener(this);
		keySensing();
		
		timer = new Timer(16, this);
		timer.start();
		hero = new Hero();
		showAll=false;
		hero.setBounds(225,10,50,80);
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
		safeFloor = new Platform(0,630, 275, 90);
		lava = new Lava(300,630, 1280, 90);
		
		platform1 = new Platform(225, 580, 60, 20);
		platform2 = new Platform(0, 500, 60, 20);
		platform3 = new Platform(225, 420, 60, 20);
		platform4 = new Platform(0, 340, 60, 20);
		platform5 = new Platform(225, 260, 60, 20);
		platform6 = new Platform(0, 180, 60, 20);
		platform7 = new Platform(255, 90, 60, 20);
		platform8 = new Platform(425, 560, 160, 20);
		platform9 = new Platform(1210, 360, 70, 20);
		platform10 = new Platform(300, 500, 60, 20);
		platform11 = new Platform(425, 420, 100, 20);
		platform12 = new Platform(550, 340, 100, 20);
		platform13 = new Platform(665, 260, 100, 20);
		platform14 = new Platform(1050, 440, 100, 20);
		platform15 = new Platform(785, 199, 200, 1 );
		
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
		platforms.add(platform15);
		platforms.add(safeFloor);
		
		wall1 = new Walls(275, 110, 25, 610);
		wall2 = new Walls(785, 200, 200, 200);
		wall3 = new Walls(785, 495, 200, 400);
		walls.add(wall1);
		walls.add(wall2);
		walls.add(wall3);
		
	}
	public void addEnemy()
	{
		enemy1= new Enemy(450, 550);
		enemy1.setBounds(450, 300, 24, 30);
		enemy2= new Enemy(5, 105);
		enemy2.setBounds(5, 465, 24, 30);
		enemy3= new Enemy(5, 105);
		enemy3.setBounds(5, 300, 24, 30);
		enemy4= new Enemy(5, 105);
		enemy4.setBounds(5, 150, 24, 30);
		enemy5 = new Enemy(675, 750);
		enemy5.setBounds(675, 200, 24, 30);
		enemy6= new Enemy(1000, 1100);
		enemy6.setBounds(1000, 250, 24, 30);
		enemy7= new Enemy(850, 950);
		enemy7.setBounds(850, 150, 24, 30);
		enemy8= new Enemy(850, 950);
		enemy8.setBounds(850, 50, 24, 30);
		enemy9= new Enemy(1000, 1100);
		enemy9.setBounds(1000, 350, 24, 30);
		enemy10 = new Enemy(605, 705);
		enemy10.setBounds(605, 510, 24, 30);
		add(enemy1);
		add(enemy2);
		add(enemy3);
		add(enemy4);
		add(enemy5);
		add(enemy6);
		add(enemy7);
		add(enemy8);
		add(enemy9);
		add(enemy10);
		
		enemies.add(enemy1);
		enemies.add(enemy2);
		enemies.add(enemy3);
		enemies.add(enemy4);
		enemies.add(enemy5);
		enemies.add(enemy6);
		enemies.add(enemy7);
		enemies.add(enemy8);
		enemies.add(enemy9);
		enemies.add(enemy10);
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
			g2.fill(platform10);
			g2.fill(platform11);
			g2.fill(platform12);
			g2.draw(platform13);
			g2.draw(platform14);
			g2.fill(wall2);
			g2.fill(wall3);
			g2.setColor(Color.blue);
			g2.fill(platform9);
		}
		g2.setColor(Color.red);
		g2.fill(lava);
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
		else if(hero.getY() >= 600)
		{
			hero.setLocation(hero.getX(), 600);
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
	public void checkWin()
	{
		if(platform9.isTouched(hero) && enemies.size() <6)
		{
			JLabel gameOver = new JLabel("YOU WIN!");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(250, 50, 400, 50);
			add(gameOver);
			timer.stop();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
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
		moveEnemy(enemy9);
		enemy9.update();
		moveEnemy(enemy10);
		enemy10.update();
		for(Bullets bullet: bullets)
		{
			bullet.shoot();
			
		}
		checkEnemies();
		checkBullets();
		if(platform7.isTouched(hero))
			showAll=true;
		checkBounds();
		checkWin();
		if(lava.isTouched(hero))
		{
			JLabel gameOver = new JLabel("Game Over");
			gameOver.setFont(gameOver.getFont().deriveFont(40.0f));
			gameOver.setBounds(50, 50, 400, 50);
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
		if ((hero.getY() < 560) && !onGround)
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