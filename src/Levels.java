import java.awt.Color;


import java.awt.Graphics;
import java.awt.Graphics2D;
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
public abstract class Levels extends JPanel implements ActionListener
{
	public Levels()
	{
		
	}
	
	public abstract Hero getHero();
	public abstract ArrayList<Bullets> getBullets();
	
	

}
