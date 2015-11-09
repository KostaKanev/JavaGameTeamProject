package objects;

import game.Game;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Coins {
    public final static int WIDTH = 100;
    public final static int HEIGHT = 67;
    private Random random;
    private int x;
    private int y;

    public final int VELOCITY = 12;

    private BufferedImage image;
    private Player player;

    public Coins(Player player, int x, int y) {
        this.x = x;
        this.y = y;
        this.image = Assets.coins;
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

        int newX = random.nextInt((60 + 150) + 1) + 60;
        int newY = random.nextInt((-44 + 90)+ 1) + -44;

        if(this.y >= Game.HEIGHT - 40|| Player.leftHit || Player.rightHit || Player.frontHit){
            if(player.getScore() % 5 == 0 && player.getBlood() < 89){
                int addBlood = player.getBlood() + 10;
                player.setBlood(addBlood);
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



