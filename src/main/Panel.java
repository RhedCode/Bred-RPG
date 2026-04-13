package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Panel extends JPanel
{
    //SCREEN SETTINGS
    final int pixelSize = 32;

    final int pixelX = 1920;
    final int pixelY = 1080;

    final int screenX = pixelX/pixelSize; 
    final int screenY = pixelY/pixelSize;

    final int screenWidth = pixelSize * screenX;
    final int screenHeight =  pixelSize * screenY;

    public Panel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
