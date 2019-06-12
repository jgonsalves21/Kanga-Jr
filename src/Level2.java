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

public class Level1 extends Levels implements ActionListener
{
	private Platform safeFloor;
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
	private boolean onGround = false;
	private double yVel = 0;
	
	public Level1()
	{
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		hero = new Hero();
		hero.setBounds(1, 560, 50, 80);
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
		g2.fill(safeFloor);
		g2.fill(platform1);
		g2.fill(platform2);
		g2.fill(platform3);
		g2.fill(platform4);
		g2.fill(platform5);
		if(allPlatforms)
		{
			g2.fill(platform6);
			g2.fill(platform7);
			g2.fill(platform8);
			g2.fill(platform9);
		}
		
		
		g2.setColor(Color.red);
		g2.fill(lava);
	}
	public void addPlatform()
	{
		safeFloor = new Platform(0,630, 150, 90);
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
		platforms.add(safeFloor);
		platform6 = new Platform(950, 250, 170, 25);
		platform7= new Platform(710, 200, 140, 25);
		platform9 = new Platform(430, 150, 170, 25);
		platform8 = new Platform(150, 100, 170, 25);
		
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
		else if(hero.getY() >= 550)
		{
			hero.setLocation(hero.getX(), 550);

		}
		
	}
	public void checkAll()
	{
		if(allPlatforms)
		{
			platforms.add(platform6);
			platforms.add(platform7);
			platforms.add(platform8);
			platforms.add(platform9);
			platforms.add(safeFloor);
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
		
		
		checkWin();
		onGround = false;
		if(platform5.isTouched(hero))
			allPlatforms=true;
		checkAll();
		for(Platform platform: platforms)
		{
			if(platform.isTouched(hero) && yVel >= 0)
			{
				
				
				if(platform.getY() >= hero.getY() + 60)
				{
					onGround = true;
					hero.setY(platform.getY() - 80);
				}
				else if(platform.getX() >= hero.getX())
					hero.setDx(0);
				else if(platform.getX() <= hero.getX())
					hero.setDx(0);
			}
			else if ((platform.isTouched(hero) && yVel <= 0))
			{
				if((platform.getY() + 20 <= hero.getY()) && (platform.getY() + 25 >= hero.getY()))
				{
					yVel = 0;
				}
					
			}				
		}
		
		if(onGround) {
			yVel = 0;
		}
		if ((hero.getY() < 550) && !onGround)
		{
			yVel += 1;
			
		}
		hero.setDy(yVel);
		checkBounds();
		hero.update();
		revalidate();
		repaint();
	}

	@Override
	public Hero getHero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bullets> getBullets() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
