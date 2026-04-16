package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import map.Grasslands;

public class GamePanel extends JPanel implements Runnable
{
    //SCREEN SETTINGS
    private final int pixelOrigSize = 16;
    private final int pixelScale = 3;
    public final int pixelSize = pixelOrigSize * pixelScale;
    public final int pixelWidth = 28;
    public final int pixelHeight = 20;
    public final int screenWidth = pixelSize * pixelWidth;
    public final int screenHeight =  pixelSize * pixelHeight;

    //WORLD SIZE
    public final int maxWorldCol = 74;
    public final int maxWorldRow = 74;
    private final int worldHeight = pixelSize * maxWorldRow;
    private final int worldWidth = pixelSize * maxWorldCol;

    //FPS
    private int FPS = 60;
    private double interval = 1000000000/FPS;

    //ANIMATIONS
    Thread animator;
    private volatile boolean running = false;
    private volatile boolean isOver = false;

    //INPUT
    InputHandler input = new InputHandler();
    Player player = new Player(this, input);

    //MAPS
    Grasslands grasslands = new Grasslands(this);

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
        this.setFocusable(true);
    }

    public void startGame()
    {
        if (animator == null)
        {
            animator = new Thread(this);
            animator.start();
        }
    }

    public void StopGame() 
    { running = false; }

    @Override
    public void run()
    {
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        running = true;
        while (animator != null && running)
        {
            //System.out.println("The Game loop is running!");
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / interval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1)
            {
                // 1. UPDATE INFORMATION
                gameUpdate();
                // 2. DRAW GRAPHICS FROM THE INFORMATION
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000)
            {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
        System.exit(0);
    }

    public void gameUpdate()
    {
        //System.out.println("Update is running!");
        if (!isOver)
        {
            player.gameUpdate(input);
        }
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);

        grasslands.draw(g2);
        player.draw(g2);
        //System.out.println("Paint component is running!");

        g2.dispose();
    }
}
