
import javax.swing.ActionMap;

import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import java.awt.CardLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;


public class Master extends JFrame implements ActionListener
{
	Hero hero = new Hero();
	public Master()
	{
		//Initial Setup
		setBounds(0,0, 1280, 720);
		CardLayout cl = new CardLayout();
		JPanel overall = new JPanel();
		overall.setLayout(cl);
		setLayout(cl);
		setFocusable(true);

		
		//JMenu Info
		JMenuBar menubar = new JMenuBar();
		JMenu levels = new JMenu("Levels");
		menubar.add(levels);
		JMenuItem level1 = new JMenuItem("Level 1");
		levels.add(level1);
		JMenuItem level2 = new JMenuItem("Level 2");
		levels.add(level2);
		JMenuItem level3 = new JMenuItem("Level 3");
		levels.add(level3);
		
		//CardLayout Info
		Level1 lvl1 = new Level1();
		overall.add(lvl1, "level 1");
		Level2 lvl2 = new Level2();
		overall.add(lvl2, "level 2");
		Level3 lvl3 = new Level3();
		overall.add(lvl3, "level 3");
		lvl3.setFocusable(true);
		
		// Action Listeners
		level1.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				ActionMap amap = lvl1.getActionMap();
				MoveRight moveR = new MoveRight(lvl1);
				amap.put("moveR", moveR);
				MoveLeft moveL = new MoveLeft(lvl1);
				amap.put("moveL", moveL);
				MoveUp moveU = new MoveUp(lvl1);
				amap.put("moveU", moveU);
				MoveDown moveD = new MoveDown(lvl1);
				amap.put("moveD", moveD);
				Reset reset = new Reset(lvl1);
				amap.put("reset", reset);
				cl.show(overall, "level 1");
				add(overall);
				
				
			}
			
		});
		
		level2.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				ActionMap amap = lvl2.getActionMap();
				MoveRight moveR = new MoveRight(lvl2);
				amap.put("moveR", moveR);
				MoveLeft moveL = new MoveLeft(lvl2);
				amap.put("moveL", moveL);
				Shoot shoot = new Shoot(lvl2);
				amap.put("shoot", shoot);
				MoveUp moveU = new MoveUp(lvl2);
				amap.put("moveU", moveU);
				MoveDown moveD = new MoveDown(lvl2);
				amap.put("moveD", moveD);
				Reset reset = new Reset(lvl2);
				amap.put("reset", reset);
				cl.show(overall, "level 2");
				add(overall);
				
				
			}
			
		});
		
		level3.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				ActionMap amap = lvl3.getActionMap();
				MoveRight moveR = new MoveRight(lvl3);
				amap.put("moveR", moveR);
				MoveLeft moveL = new MoveLeft(lvl3);
				amap.put("moveL", moveL);
				Shoot shoot = new Shoot(lvl3);
				amap.put("shoot", shoot);
				MoveUp moveU = new MoveUp(lvl3);
				amap.put("moveU", moveU);
				MoveDown moveD = new MoveDown(lvl3);
				amap.put("moveD", moveD);
				Reset reset = new Reset(lvl3);
				amap.put("reset", reset);
				cl.show(overall, "level 3");
				add(overall);
				
			}
			
		});
		
		this.setJMenuBar(menubar);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
			

	public static void main(String[] args) 
	{
		Master master = new Master();

	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
		
	}
	class MoveUp extends AbstractAction
	{
		Levels level;
		public MoveUp(Levels lvl)
		{
			level=lvl;
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			level.getHero().setDy(-5);
			
		}

	}
	class Reset extends AbstractAction
	{
		Levels level;
		public Reset(Levels lvl)
		{
			level=lvl;
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			level.getHero().setLocation(100, 100);
			
		}

	}
	class MoveDown extends AbstractAction
	{
		Levels level;
		public MoveDown(Levels lvl)
		{
			level=lvl;
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			level.getHero().setDy(5);
			
		}

	}
	
	class MoveRight extends AbstractAction
	{
		Levels level;
		public MoveRight(Levels lvl)
		{
			level=lvl;
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			level.getHero().setDx(5);
			
		}

	}
	class MoveLeft extends AbstractAction
	{
		Levels level;
		public MoveLeft(Levels lvl)
		{
			level=lvl;
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			level.getHero().setDx(-5);
			
		}

	}
	class Shoot extends AbstractAction
	{
		Levels level;
		public Shoot(Levels lvl)
		{
			level=lvl;
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
				Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
				Bullets nbullet = new Bullets(level.getHero().getX()+25, level.getHero().getY()+45, mouseLocation);
				nbullet.setBounds(level.getHero().getX()+25, level.getHero().getY()+45, 10, 10);
				level.getBullets().add(nbullet);
				level.add(nbullet);
			
		}

	}

}
