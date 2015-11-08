package game;

import graphics.Assets;
import graphics.ImgLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    public static final int WIDTH = 85;
    public static final int HEIGHT = 168;
    public static final int VELOSITY = 12;
    private int x;
    private int y;
    private int blood;
    private int score;


    public static boolean leftHit;
    public static boolean rightHit;
    public static boolean frontHit;
    public static boolean leftHitCar;
    public static boolean rightHitCar;
    public static boolean frontHitCar;
    public static boolean moovingLeft;
    public static boolean moovingRight;
    public static boolean isHit;
    private OtherCars car;
    private Coins coin;
    private BufferedImage playerImage;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.blood = 99;
        this.moovingLeft = false;
        this.moovingRight = false;
        this.score = 0;
        this.playerImage = Assets.policeCar;
        this.leftHit = false;
        this.rightHit = false;
        this.frontHit = false;

        this.leftHitCar = false;
        this.rightHitCar = false;
        this.frontHitCar = false;
        this.isHit = false;
    }
    public int getX(){
        return this.x;
    }

    public  void setX(int x){
        this.x = x;
    }

    public int getY(){
        return this.y;
    }

    public  void setY(int y){
        this.y = y;
    }
    public int getBlood(){
        return this.blood;
    }

    public  void setBlood(int blood){
        this.blood = blood;
    }

    public int getScore(){
        return this.score;
    }

    public  void setScore(int score){
        this.score = score;
    }
    public void tick() {
        int takeX = this.getX() - VELOSITY;
        int addX = this.getX() + VELOSITY;
        if (this.moovingLeft && !this.leftHit) {
            this.setX(takeX);
        }
        if (this.moovingRight && !this.rightHit) {
            this.setX(addX);
        }
        this.intersectsCoins(this.coin);
    }

    public void render(Graphics g) {
        g.drawImage(this.playerImage, this.x, this.y, null);

        if(isHit){
            g.drawImage(ImgLoader.loadImage("/img/hit.png"),this.getX() + 20,this.getY() + 40, 90, 90, null);
            isHit = false;
        }
    }

    public boolean intersects(OtherCars car) {
        int pointX1Player = this.x;
        int pointX1OtherCar = car.getX();
        int pointX2OtherCar = car.getX() + OtherCars.WIDTH;
        int pointX2Player = this.x + WIDTH;
        int pointY1Player = this.y;
        int pointY1OtherCar = car.getY();
        int pointY2OtherCar = car.getY() + OtherCars.HEIGHT;
        int pointY2Player = this.y + HEIGHT;

        boolean isBlow = false;

        if((pointY2OtherCar >= pointY1Player && pointY1OtherCar <= pointY2Player) &&
                (pointX1Player <= pointX2OtherCar && pointX2Player >= pointX2OtherCar)){
            int takeX = car.getX() - 20;
            this.leftHitCar = true;
            isBlow = true;
            System.out.println("Left");
            car.setX(takeX);
            this.x += 9;
            isHit = true;
        }
        if((pointY2OtherCar >= pointY1Player && pointY1OtherCar <= pointY2Player) &&
                (pointX2Player >= pointX1OtherCar && pointX1Player <= pointX1OtherCar)){
            int addX = car.getX() + 20;
            this.rightHitCar = true;
            isBlow = true;
            System.out.println("Right");
            car.setX(addX);
            this.x -= 9;
            isHit = true;
        }

        return isBlow;
    }

    public boolean intersectsCoins(Coins coins) {
        int pointX1Player = this.x;
        int pointX1Coin = coins.x;
        int pointX2Coin = coins.x + coins.width;
        int pointX2Player = this.x + WIDTH;
        int pointY1Player = this.y;
        int pointY1Coin = coins.y;
        int pointY2Coin = coins.y + coins.height;
        int pointY2Player = this.y + HEIGHT;
        this.leftHit = false;
        this.rightHit = false;
        this.frontHit = false;
        boolean isBlow = false;

        if((pointY2Coin >= pointY1Player && pointY1Coin <= pointY2Player) &&
                (pointX1Player <= pointX2Coin && pointX2Player >= pointX2Coin)){
            this.leftHit = true;
            isBlow = true;
            int add = this.getScore() + 1;
            this.setScore(add);
            System.out.println(this.getScore());
            System.out.println("Left");
        }

        if((pointY2Coin >= pointY1Player && pointY1Coin <= pointY2Player) &&
                (pointX2Player >= pointX1Coin && pointX1Player <= pointX1Coin)){
            this.rightHit = true;
            isBlow = true;
            int add = this.getScore() + 1;
            this.setScore(add);
            System.out.println(this.getScore());
            System.out.println("Right");
        }

        if(pointY1Player == pointY2Coin &&
            (pointX1Player <= pointX2Coin && pointX2Player >= pointX1Coin ||
             pointX1Player <= pointX2Player && pointX2Coin >= pointX1Player)){
            isBlow = true;
            this.frontHit = true;
            int add = this.getScore() + 1;
            this.setScore(add);
            System.out.println(this.getScore());
            System.out.println("Front");
        }

        return isBlow;
    }
}