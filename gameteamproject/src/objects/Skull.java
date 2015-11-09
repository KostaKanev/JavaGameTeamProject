package objects;

import game.Game;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Skull {
    public final static int WIDTH = 100;
    public final static int HEIGHT = 122;
    private Random random;
    private int x;
    private int y;

    public final int VELOCITY = 18;

    private BufferedImage image;
    private Player player;

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
    }

    public void render(Graphics g){
        g.drawImage(this.image,this.x ,this.y , null);

        int newX = random.nextInt((50 + 150) + 1) + 50;
        int newY = random.nextInt((-44 + 90)+ 1) + -44;

        if(this.y >= Game.HEIGHT * 6){
            this.x = newX;
            this.y = newY;
            this.createNewSkull(g);
        }
    }

    public void createNewSkull(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }
}
