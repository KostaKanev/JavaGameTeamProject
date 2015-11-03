package game;

import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Coins {
    private Random random;
    public static int x;
    public static int y;
    public static int width;
    public static int height;
    private int velosity;

    private BufferedImage image;

    public Coins() {
        this.x = 150;
        this.y = 180;
        this.width = 100;
        this.height = 67;
        this.image = Assets.coins;
        this.random = new Random();
        this.velosity = 8;
    }
    public void tick(){
        this.y += velosity;

    }

    public void render(Graphics g){
        g.drawImage(this.image,this.x ,this.y , null);

        int newX = random.nextInt((60 + 150) + 1) + 60;
        int newY = random.nextInt((0 + 350)+ 1) + 0;

        if(this.y >= Game.HEIGHT - 70|| Player.leftHit || Player.rightHit){
            this.x = newX;
            this.y = newY;
            this.createNewCoin(g);
        }
    }

    public void createNewCoin(Graphics g){
        g.drawImage(this.image, this.x, this.y, null);
    }
}


