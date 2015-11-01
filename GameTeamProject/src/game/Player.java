package game;

import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    public int x;
    public int y;
    public int lives;
    public int velosity;
    public Rectangle leftBound;
    public Rectangle rightBounding;
    public Rectangle frontBounds;
    public boolean leftHit;
    public static boolean rightHit;
    public static boolean frontHit;
    public static boolean moovingLeft;
    public static boolean moovingRight;

    private BufferedImage playerImage;
    private ArrayList<Point> points;

    public Player(int x, int y, int lives) {
        this.x = x;
        this.y = y;
        this.lives = lives;

        this.velosity = 8;
        this.moovingLeft = false;
        this.moovingRight = false;
        this.leftBound = new Rectangle(15,200);
        this.rightBounding = new Rectangle(15,200);
        this.frontBounds = new Rectangle(60,5);
        this.playerImage = Assets.policeCar;
    }

    public void tick() {
        this.leftBound.setBounds(this.x + 40, this.y + 80,15, 150);
        this.rightBounding.setBounds(this.x+105,this.y+80,15,150);
        this.frontBounds.setBounds(this.x + 45, this.y + 70, 60, 10);
        if (this.moovingLeft && !this.leftHit) {
            this.x -= this.velosity;
        }
        if (this.moovingRight && !this.rightHit) {
            this.x += this.velosity;
        }
    }

    public void render(Graphics g) {

        g.drawImage(this.playerImage, this.x, this.y, null);
        //Just  printing the bounds
//        g.setColor(Color.blue);
//        g.fillRect(this.x + 40, this.y + 80, 5, 150);
//        g.fillRect(this.x+105,this.y+80,5,150);
//        g.fillRect(this.x + 45, this.y + 70, 60, 5);
    }

    public boolean intersects(OtherCars car) {
         this.leftHit = false;
         this.rightHit = false;
         this.frontHit = false;
         boolean isBlow = false;

         this.points = new ArrayList<Point>(
                Arrays.asList(car.firstLeftPoint, car.secondLeftPoint, car.thirdLeftPoint,
                        car.firstRightPoint, car.secondRightPoint, car.thirdRightPoint,
                        car.leftRearPoint, car.rightRearPoint));

        for (Point point : points) {
            if (this.leftBound.contains(point)) {
                System.out.println("LeftttttttHittt");
                leftHit = true;
                isBlow = true;
            }
        }
        for (Point point : points) {
            if (this.rightBounding.contains(point)) {
                System.out.println("RightHittt");
                rightHit =true;
                isBlow = true;
            }
        }
        for (Point point : points) {
            if (this.frontBounds.contains(point)) {
                System.out.println("FrooontBUmmp");
                frontHit = true;
                isBlow = true;
            }
        }
        return isBlow;
    }
}