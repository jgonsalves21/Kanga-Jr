import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
	private boolean isJumping = false;
	private int jumpTime = 0;
	private int jumpTime2 = 0;
	private boolean onPlatform = true;
	private int fallSpeed = 1;
	private int delay = 0;
	private int jumpSpeed = -20;
	private boolean onGround = false;
	private double yVel = 0;
	
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
		/**
		int mapName = WHEN_IN_FOCUSED_WINDOW;
		InputMap imap= getInputMap(mapName);
		KeyStroke right = KeyStroke.getKeyStroke('d');
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "pressed");
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "released");
		KeyStroke left = KeyStroke.getKeyStroke('a');
		imap.put(left, "moveL");
		KeyStroke up = KeyStroke.getKeyStroke('w');
		imap.put(up, "moveU");
		KeyStroke down = KeyStroke.getKeyStroke('s');
		imap.put(down, "moveD");
		KeyStroke reset = KeyStroke.getKeyStroke('r');
		imap.put(reset, "reset");**/
		InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "rightpressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "rightreleased");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "leftpressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "leftreleased");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "uppressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "upreleased");

        am.put("rightpressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) 
            {
                hero.setDx(5);
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
                hero.setDx(-5);
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
	                yVel = -20;
	                /*
	                jumpTime++;
	                jumpTime2= jumpTime%6;                
	                jumpSpeed ++;
	                if(jumpTime2 ==10)
	                {
	                	jumpTime = 0;
	                	jumpSpeed = -5;
	                	delay = 0;
	                }
	                */
            	}
                
            }
        });
        am.put("upreleased", new AbstractAction() {
            public void actionPerformed(ActionEvent e) 
            {
            	/*
                jumpSpeed=-5;
                jumpTime=0;
                delay=0;
                isJumping=false;
                */
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
		
			g2.fill(platform6);
			g2.fill(platform7);
			g2.fill(platform8);
			g2.fill(platform9);
		
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
		
		platform6 = new Platform(950, 250, 170, 25);
		platform7= new Platform(710, 200, 140, 25);
		platform9 = new Platform(430, 150, 170, 25);
		platform8 = new Platform(150, 100, 170, 25);
		platforms.add(platform6);
		platforms.add(platform7);
		platforms.add(platform8);
		platforms.add(platform9);
		platforms.add(safeFloor);
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
		for(Platform platform: platforms)
		{
			if(platform.isTouched(hero) && yVel >= 0)
			{
				fallSpeed = 1;
				delay = 0;
				onGround = true;
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
		
		if(onGround) {
			yVel = 0;
		}
		if ((hero.getY() < 550) && !onGround)
		{
			yVel += 1;
			
			/*
			hero.setDy(fallSpeed);
			delay ++;
			if (delay %2 == 0)
			{
				fallSpeed++;
			}
			*/
		}
		hero.setDy(yVel);
		System.out.println(onGround);
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

