
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Master extends JFrame
{
	public Master()
	{
		//Initial Setup
		setBounds(0,0, 1280, 720);
		CardLayout cl = new CardLayout();
		JPanel overall = new JPanel();
		overall.setLayout(cl);
		setLayout(cl);
		
		//JMenu Info
		JMenuBar menubar = new JMenuBar();
		JMenu levels = new JMenu("Levels");
		menubar.add(levels);
		JMenuItem level1 = new JMenuItem("Level 1");
		levels.add(level1);
		JMenuItem level2 = new JMenuItem("Level 2");
		levels.add(level2);
		
		//CardLayout Info
		Level1 lvl1 = new Level1();
		overall.add(lvl1, "level 1");
		Level2 lvl2 = new Level2();
		overall.add(lvl2, "level 2");
		
		// Action Listeners
		level1.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "level 1");
				add(overall);
				
			}
			
		});
		
		level2.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "level 2");
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

}
