
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
		JMenuItem level5 = new JMenuItem("Level 5");
		levels.add(level5);
		JMenuItem home = new JMenuItem("Home");
		levels.add(home);
		
		//CardLayout Info
		//Level1 lvl1 = new Level1();
		//overall.add(lvl1, "level 1");
		
		
		
		KangaIntro intro = new KangaIntro();
		overall.add(intro, "home");
		cl.show(overall, "home");
		add(overall);
		// Action Listeners
		home.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(overall, "home");
				add(overall);
				
				
			}
			
		});
		level1.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Level1 lvl1 = new Level1();
				overall.add(lvl1, "level 1");
				cl.show(overall, "level 1");
				add(overall);
				
				
			}
			
		});
		
		level2.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Level2 lvl2 = new Level2();
				overall.add(lvl2, "level 2");
				cl.show(overall, "level 2");
				add(overall);
				
				
			}
			
		});
		
		level3.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Level3 lvl3 = new Level3();
				overall.add(lvl3, "level 3");
				
				cl.show(overall, "level 3");
				add(overall);
				
			}
			
		});
		level5.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Level5 lvl5 = new Level5();
				overall.add(lvl5, "level5");
				cl.show(overall, "level5");
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

}

