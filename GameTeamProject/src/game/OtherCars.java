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
    private Random random;

    public OtherCars(int x, int y){
        this.x = x;
        this.y = y;
        this.velosity = 2;
        this.playerImage = Assets.playerCar1;
    }

    public void tick(){
        this.y += this.velosity;
    }

    public void render(Graphics g){
        g.drawImage(this.playerImage, this.x, this.y, null);
        if(this.y >= Game.HEIGHT){
            this.y = -250;
            this.createNewCar(g);
        }
    }

   public void createNewCar(Graphics g){
       g.drawImage(this.playerImage, this.x, this.y, null);

   }
}
