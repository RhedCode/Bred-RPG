package main;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.*;
import javax.sound.sampled.*;

public class Main 
{
    public static void main(String[] args) 
    {
        JFrame window = new JFrame();
        Panel panel = new Panel();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("My Game");
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}