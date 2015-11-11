package objects;

import game.Game;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Skull {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 122;
    public final int MIN_X = 50;
    public final int MAX_X = 140;
    public final int MIN_Y = -44;
    public final int MAX_Y = 90;

    private Random random;
    private int x;
    private int y;

    public final int VELOCITY = 18;
    public final int VELOCITY_X = 3;
    private BufferedImage image;
    private Player player;

    private int countOfTick;

    public Skull(Player player, int x, int y) {
        this.x = x;
        this.y = y;
        this.image = Assets.skull;
        this.random = new Random();
        this.player = player;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }


    public void tick(){
        this.y += VELOCITY;
        this.x += VELOCITY_X;
        if(this.y % 100 == 0){
            this.x -= VELOCITY_X;
        }

        this.countOfTick++;
    }

    public void render(Graphics g){
        if(countOfTick > 100) {
            g.drawImage(this.image, this.x, this.y, null);
        }
        int newX = random.nextInt((MIN_X + MAX_X) + 1) + MIN_X;
        int newY = random.nextInt((MIN_Y + MAX_Y)+ 1) + MIN_Y;

        if(this.y >= Game.HEIGHT * 2 && countOfTick % 220 == 0){
            this.x = newX;
            this.y = newY;
            this.createNewSkull(g);
        }
    }

    public void createNewSkull(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }
}
