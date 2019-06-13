import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class KangaIntro extends JPanel implements ActionListener
{
	private ImageIcon image1;
	private Ellipse2D.Double head;
	private Rectangle leftArm, rightArm, leftLeg, rightLeg, torso;
	private Timer timer;
	private ArrayList<Bullets> bullets = new ArrayList<Bullets>();
	public KangaIntro()
	{
		this.setLayout(null);
		timer = new Timer(16, this);
		JLabel title = new JLabel("Kanga Platform Destroyer");
		title.setFont(title.getFont().deriveFont(60.0f));
		title.setBounds(260, 20, 800, 100);
		add(title);
		head = new Ellipse2D.Double(600, 150, 70, 70);
		torso = new Rectangle(560, 220, 150, 200);
		leftArm = new Rectangle(485, 220, 100, 50);
		rightArm = new Rectangle(685, 220, 100, 50);
		leftLeg= new Rectangle(560, 420, 50, 100);
		rightLeg= new Rectangle(660, 420, 50, 100);
		
		
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;	
		g2.fill(head);
		g2.fill(torso);
		g2.fill(leftArm);
		g2.fill(rightArm);
		g2.fill(leftLeg);
		g2.fill(rightLeg);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		revalidate();
		repaint();
		
	}
}
