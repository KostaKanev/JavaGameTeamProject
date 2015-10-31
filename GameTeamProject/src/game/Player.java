package game;

import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    public int x;
    public int y;
    public int lives;
    public int velosity;

    public static boolean moovingLeft;
    public static boolean moovingRight;

    private BufferedImage playerImage;

    public Player(int x, int y, int lives) {
        this.x = x;
        this.y = y;
        this.lives = lives;

        this.velosity = 8;
        moovingLeft = false;
        moovingRight = false;

        this.playerImage = Assets.policeCar;
    }

    public void tick() {
        //this.y -= this.velosity;
        if (moovingLeft) {
            this.x -= velosity;
        }
        if (moovingRight) {
            this.x += velosity;
        }
    }

    public void render(Graphics g) {

        g.drawImage(this.playerImage, this.x, this.y, null);
    }

    public boolean intersects(OtherCars otherCar) {
        boolean isBlow = false;

        if((otherCar.y == this.y - 160 && otherCar.x <= this.x) ||
            (otherCar.y >= this.y - 160 && otherCar.y <= this.y + 160) &&
            (otherCar.x >= this.x && otherCar.x <= this.x + 60)) {

            //isBlow = true;
        }
        return isBlow;
    }
}
