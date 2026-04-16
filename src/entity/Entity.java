package entity;

import main.GamePanel;
import main.InputHandler;

public class Entity {
    public GamePanel gp;
    public InputHandler input;
    public String name;
    public String direction;
    public int health, level, damage;
    public int x, y;
    public int speed;
    public int spriteCount = 1;
    public int spriteTimer = 0; 
}
