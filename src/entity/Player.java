package entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import main.GamePanel;
import main.InputHandler;

public class Player extends Entity{
    public BufferedImage up1, down1, left1, right1;
    public BufferedImage up2, down2, left2, right2;
    public BufferedImage up3, down3, left3, right3;
    public BufferedImage idle1, idle2, idle3; 

    public Player(GamePanel gp, InputHandler input)
    {
        this.gp = gp;
        this.input = input;

        setDefaultValues();
    }

    private void setDefaultValues()
    {
        name = "Player1";
        health = 100;
        level = 0;
        damage = 10;
        direction = "down";
        x = 100;
        y = 100;
        speed = 4;
    }

    public void getPlayerImage()
    {
        try {
            up1 = ImageIO.read(getClass().getResource("/resources/sprites/player/up1.png"));
            up2 = ImageIO.read(getClass().getResource("/resources/sprites/player/up2.png"));

            down1 = ImageIO.read(getClass().getResource("/resources/sprites/player/down1.png"));
            down2 = ImageIO.read(getClass().getResource("/resources/sprites/player/down2.png"));

            left1 = ImageIO.read(getClass().getResource("/resources/sprites/player/left1.png"));
            left2 = ImageIO.read(getClass().getResource("/resources/sprites/player/left2.png"));

            right1 = ImageIO.read(getClass().getResource("/resources/sprites/player/right1.png"));
            right2 = ImageIO.read(getClass().getResource("/resources/sprites/player/right2.png"));

        } catch(IOException e) {}
    }

    public void gameUpdate(InputHandler input)
    {
        if (input.upPressed == true)
        {
            direction = "up";
            y -= speed;
        }
        if (input.downPressed == true)
        {
            direction = "down";
            y += speed;
        }
        if (input.rightPressed == true)
        {
            direction = "right";
            x += speed;
        }
        if (input.leftPressed == true)
        {
            direction = "left";
            x -= speed;
        }


        if (!(input.upPressed == false &&
                input.downPressed == false &&
                input.rightPressed == false &&
                input.leftPressed == false))
        {
            spriteTimer++;

            if (spriteTimer > 8)
            {
                if (spriteCount == 1)
                    spriteCount = 2;
                else if (spriteCount == 2)
                    spriteCount = 1;
                spriteTimer = 0;
            }
        }
    }

    public void draw(Graphics2D g)
    {
        BufferedImage image = null;

        getPlayerImage();

        switch (direction)
        {
            case "up":
                if (spriteCount == 1)
                    image = up1;
                if (spriteCount == 2)
                    image = up2;
                break;
            case "down":
                if (spriteCount == 1)
                    image = down1;
                if (spriteCount == 2)
                    image = down2;
                break;
            case "left":
                if (spriteCount == 1)
                    image = left1;
                if (spriteCount == 2)
                    image = left2;
                break;
            case "right":
                if (spriteCount == 1)
                    image = right1;
                if (spriteCount == 2)
                    image = right2;
                break;
        } 

        g.drawImage(image, x, y, gp.pixelSize, gp.pixelSize, null);
    }
}
