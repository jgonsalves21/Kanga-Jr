
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.util.ArrayList;


public class Master extends JFrame
{
	public Master()
	{
		setLayout(null);
		setBounds(0,0, 1280, 720);
		CardLayout cl = new CardLayout();
		JPanel overall = new JPanel();
		overall.setLayout(cl);
		
		Level1 lvl1 = new Level1();
		lvl1.setBounds(0, 0, 1280, 720);
		add(lvl1);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
			

	public static void main(String[] args) 
	{
		Master master = new Master();

	}

}
