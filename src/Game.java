import java.awt.event.ActionEvent; 

import java.awt.event.ActionListener; 

import java.awt.event.KeyEvent; 

import java.awt.event.KeyListener; 

import java.util.ArrayList; 

  

import javax.swing.JFrame; 

import javax.swing.Timer; 

  

public class Game extends JFrame implements ActionListener 

{ 

  

    private int x = 200; 

    private int y = 200; 

    private int jumpSpeed = -10; 

    private int fallSpeed = 1; 

    private static int acceleration = 1; 

    private int startHeight; 

    private int count = 0; 

    private boolean isJumping = false; 

    private boolean maxJump = false; 

    private Hero man = new Hero(); 

    //private ArrayList<Ball> balls = new ArrayList<Ball>(); 

     

    public Game() 

    { 

        setBounds(100, 100, 800, 800); 

        setTitle("Game"); 

        setLayout(null); 

        setFocusable(true); 

         

        Timer t1 = new Timer(20, this); 

        t1.start(); 

         

        man.setBounds(x, y, 200, 200); 

        add(man); 

         

        addKeyListener(new KeyListener() 

            { 

             

            public void keyPressed(KeyEvent e) 

            { 

                    if((e.getKeyCode() == e.VK_UP) && (!maxJump)) 

                    { 

                        fallSpeed = 1; 

                        isJumping = true; 

                        man.setDy(jumpSpeed); 

                         jumpSpeed = jumpSpeed + acceleration; 

                         count++; 

                         if (count == 11) 

                         { 

                             jumpSpeed = -10; 

                             count = 0; 

                             maxJump = true; 

                             isJumping = false; 

                         } 

                    } 

                    if(e.getKeyCode() == e.VK_DOWN) 

                    { 

                        man.setDy(10);                         

                    } 

                    if(e.getKeyCode() == e.VK_LEFT) 

                    { 

                        man.setDx(-10);                         

                    } 

                    if(e.getKeyCode() == e.VK_RIGHT) 

                    { 

                        man.setDx(10);                     

                    } 
                    /**

                    if(e.getKeyCode() == e.VK_SPACE) 

                    { 

                        Bullets ball = new Bullets(man.getX() + 100, man.getY()); 

                        bullets.add(ball); 

                        add(ball); 

                    } **/

                     

                } 

                 

                public void keyReleased(KeyEvent e) 

                { 

                    if(e.getKeyCode() == e.VK_UP) 

                    { 

                        isJumping = false; 

                        maxJump = false; 

                    } 

                    if(e.getKeyCode() == e.VK_DOWN) 

                    { 

                        man.setDy(0); 

                         

                    } 

                    if(e.getKeyCode() == e.VK_LEFT) 

                    { 

                        man.setDx(0);                         

                    } 

                    if(e.getKeyCode() == e.VK_RIGHT) 

                    { 

                        man.setDx(0);                         

                    } 

                    if(e.getKeyCode() == e.VK_SPACE) 

                    { 

         

                    }     

                } 

  

                @Override 

                public void keyTyped(KeyEvent arg0) { 

                 

                     

                } 

            }); 

        setVisible(true); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    } 

     

  

    @Override 

    public void actionPerformed(ActionEvent arg0)  

    { 

        if (man.getX() < -25) 

        { 

            man.setLocation(-25, man.getY()); 

        } 

        else if (man.getX() > 675) 

        { 

            man.setLocation(675, man.getY()); 

        } 

        else if (man.getY() < 0) 

        { 

            man.setLocation(man.getX(), 0); 

        } 

        else if (man.getY() > 550) 

        { 

            man.setLocation(man.getX(), 550); 

        } 

        else if ((man.getY() < 500) && !isJumping) 

        { 

            man.setDy(fallSpeed); 

            fallSpeed += acceleration; 

            if (man.getY() > 550) 

            { 

                man.setDy(0); 

                fallSpeed = 1; 

            } 

        } 

         

         

         

        man.update(); 

         
/**
        for (Ball b : balls) 

        { 

             

                b.update(); 

             

        } 

         

        for (int i = 0; i<balls.size(); i++) 

        { 

            if ((balls.get(i)).getX() > 800) 

            { 

                remove(balls.get(i)); 

                balls.remove(i); 

                i--; 

            } 

        } **/

             

         

        repaint(); 

    } 

     

     

     

    public static void main(String[] args) 

    { 

        Game game1 = new  Game(); 

    } 

     

} 