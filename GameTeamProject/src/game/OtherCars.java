package game;

import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class OtherCars {
    public int x;
    public int y;
    public int velosity;
    private BufferedImage playerImage;

    public OtherCars(int x, int y){
        this.x = x;
        this.y = y;
        this.velosity = 8;
        this.playerImage = Assets.playerCar1;
    }

    public void tick(){

        this.y += this.velosity;
    }

    public void render(Graphics g){
        g.drawImage(this.playerImage, this.x, this.y, null);

        Random rand = new Random();
        int randomX = rand.nextInt((303 - 25) + 1) + 25;
        int dropPositionY = -250;

        if(this.y >= Game.HEIGHT){
            this.y = dropPositionY;
            this.x = randomX;

            this.createNewCar(g,randomX,dropPositionY);
        }
    }

   public void createNewCar(Graphics g, int x, int y){
       g.drawImage(this.playerImage, x, y, null);

   }
}
