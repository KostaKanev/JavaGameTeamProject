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
        this.y = 0;
        this.width = 100;
        this.height = 67;
        this.image = Assets.coins;
        this.random = new Random();
        this.velosity = 12;
    }
    public void tick(){
        this.y += velosity;

    }

    public void render(Graphics g){
        g.drawImage(this.image,this.x ,this.y , null);

        int newX = random.nextInt((60 + 150) + 1) + 60;
        int newY = random.nextInt((-44 + 90)+ 1) + -44;

        if(this.y >= Game.HEIGHT - 40|| Player.leftHit || Player.rightHit || Player.frontHit){
            if(Player.score % 5 == 0){
                Player.blood += 25;
            }
            this.x = newX;
            this.y = newY;
            this.createNewCoin(g);
        }
    }

    public void createNewCoin(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }
}



