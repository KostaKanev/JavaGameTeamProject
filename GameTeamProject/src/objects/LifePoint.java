package objects;

import game.Game;
import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class LifePoint {

    public int x;
    public int y;
    public int velocity;
    private BufferedImage lifeImage;

    public LifePoint(int x, int y) {
        this.x = x;
        this.y = y;
        this.lifeImage = Assets.hearthImage;
        this.velocity = 7;
    }

    public void tick(){
        this.y += velocity;
    }

    public void render(Graphics g){
        g.drawImage(this.lifeImage, this.x, this.y, null);
        Random rand = new Random();
        int randomNum = rand.nextInt((303 - 25) + 1) + 25;
        int dropPositionY = -250;

        if(this.y >= Game.HEIGHT){
            this.y = dropPositionY;
            this.x = randomNum;
            this.dropLife(g);
        }
    }

    public void dropLife(Graphics g) {
        g.drawImage(this.lifeImage,this.x ,this.y ,null);
    }
}