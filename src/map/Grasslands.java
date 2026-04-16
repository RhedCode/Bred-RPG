package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class Grasslands extends Map{
    private BufferedImage grassTile;

    public Grasslands(GamePanel gp)
    {
        this.gp = gp;
    }

    private void getImage()
    {
        try{
            grassTile = ImageIO.read(getClass().getResource("/resources/tiles/grass.png"));
        } catch (IOException e){}
    }

    public void draw(Graphics2D g2)
    {
        int i, j;

        getImage();
        for (i = 0; i < 28; i+=gp.pixelHeight)
        {
            y = i;
            
            for (j = 0; j < 28; j+=gp.pixelWidth)
            {
                x = j;
                g2.drawImage(grassTile, x, y, gp.pixelSize, gp.pixelSize, null);
            }
        }
    }
}
