package game;

import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;

public class OtherCars {
    public int x;
    public int y;
    public int velosity;

    public boolean isMoovingLeft;
    public boolean isMoovingRight;

    private BufferedImage playerImage;

    public OtherCars(int x, int y){
        this.x = x;
        this.y = y;

        this.velosity = 2;
        this.isMoovingLeft = false;
        this.isMoovingRight = false;

        this.playerImage = Assets.playerCar1;
    }

    public void tick(){
        this.y += this.velosity;
    }

    public void render(Graphics g){
        g.drawImage(this.playerImage, this.x, this.y, null);
    }
}
