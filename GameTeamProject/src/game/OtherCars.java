package game;

import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Random;

public class OtherCars {
    private final int DROP_POSITION_Y = -250;

    private int x;
    public static int y;
    private int velosity;
    private BufferedImage playerImage;
    private Random random;
    public Point firstLeftPoint,secondLeftPoint ,thirdLeftPoint
                 ,firstRightPoint,secondRightPoint,thirdRightPoint,
                 leftRearPoint,rightRearPoint;

    public OtherCars(int x, int y, BufferedImage playerImage){
        this.x = x;
        this.y = y;
        this.velosity = 4;
        this.playerImage = playerImage;
    }

    public void tick(){
        setBoundings();
        if (!Player.frontHit)
        this.y += this.velosity;
    }

    public void render(Graphics g){
        g.drawImage(this.playerImage, this.x, this.y, null);
        //Just printing the boundings for better interpretation... This will be removed
//        g.setColor(Color.green);
//        g.fillRect(this.x + 50,this.y + 90,  2,2);
//        g.fillRect(this.x + 50,this.y + 135, 2,2);
//        g.fillRect(this.x + 50,this.y + 180, 2,2);
//        g.fillRect(this.x + 120,this.y + 90, 2,2);
//        g.fillRect(this.x + 120,this.y + 165,2,2);
//        g.fillRect(this.x + 120,this.y + 230,2,2);
//        g.fillRect(this.x + 60,this.y + 245,2,2);
//        g.fillRect(this.x + 110,this.y + 245,2,2);
        this.random = new Random();
        int min = 26;
        int max = 300;
        int randomNum = random.nextInt((max - min) + 1) + min;

        if(this.y >= Game.HEIGHT){
            this.y = DROP_POSITION_Y;
            this.x = randomNum;
            this.createNewCar(g);
        }
    }

   public void createNewCar(Graphics g){
       g.drawImage(this.playerImage, this.x, this.y, null);
   }

    public void setBoundings(){
        firstLeftPoint = new Point(this.x+50,this.y+90);
        secondLeftPoint=new Point(this.x + 45, this.y + 165);
        thirdLeftPoint= new Point(this.x+45,this.y+230);
        firstRightPoint = new Point(this.x + 120,this.y + 90);
        secondRightPoint = new Point(this.x + 120,this.y + 165);
        thirdRightPoint = new Point(this.x + 120,this.y + 230);
        rightRearPoint = new Point(this.x + 110,this.y + 245);
        leftRearPoint = new Point(this.x + 60,this.y + 245);
        this.firstLeftPoint.setLocation(firstLeftPoint);
        this.thirdLeftPoint.setLocation(thirdLeftPoint);
        this.secondLeftPoint.setLocation(secondLeftPoint);
        this.firstRightPoint.setLocation(firstRightPoint);
        this.secondRightPoint.setLocation(secondRightPoint);
        this.thirdRightPoint.setLocation(thirdRightPoint);
        this.leftRearPoint.setLocation(leftRearPoint);
        this.rightRearPoint.setLocation(rightRearPoint);
    }
}
