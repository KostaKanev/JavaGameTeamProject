package game;

import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    public static int x;
    public static int y;
    private int width;
    private int height;
    public static int blood;
    public int velosity;

    public static boolean leftHit;
    public static boolean rightHit;
    public static boolean frontHit;
    public static boolean moovingLeft;
    public static boolean moovingRight;

    private BufferedImage playerImage;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.blood = 500;
        this.width = 85;
        this.height = 168;
        this.velosity = 5;
        this.moovingLeft = false;
        this.moovingRight = false;

        this.playerImage = Assets.policeCar;
    }

    public void tick() {

        if (this.moovingLeft && !this.leftHit) {
            this.x -= this.velosity;
        }
        if (this.moovingRight && !this.rightHit) {
            this.x += this.velosity;
        }
    }

    public void render(Graphics g) {

        g.drawImage(this.playerImage, this.x, this.y, null);
    }

    public boolean intersects(OtherCars car) {
        int pointX1Player = this.x;
        int pointX1OtherCar = car.x;
        int pointX2OtherCar = car.x + car.width;
        int pointX2Player = this.x + this.width;
        int pointY1Player = this.y;
        int pointY1OtherCar = car.y;
        int pointY2OtherCar = car.y + car.height;
        int pointY2Player = this.y + this.height;
         this.leftHit = false;
         this.rightHit = false;
         this.frontHit = false;
         boolean isBlow = false;

        if((pointY2OtherCar >= pointY1Player && pointY1OtherCar <= pointY2Player) &&
                (pointX1Player <= pointX2OtherCar && pointX2Player >= pointX2OtherCar)){
            this.leftHit = true;
            isBlow = true;
            System.out.println("Left");
            car.x -= 20;
            this.x += 9;

        }
        if((pointY2OtherCar >= pointY1Player && pointY1OtherCar <= pointY2Player) &&
                (pointX2Player >= pointX1OtherCar && pointX1Player <= pointX1OtherCar)){
            this.rightHit = true;
            isBlow = true;
            System.out.println("Right");
            car.x += 20;
            this.x -= 9;

        }
        return isBlow;
    }
}