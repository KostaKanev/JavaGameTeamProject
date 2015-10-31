package game;

import graphics.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Random;

public class OtherCars {
    public int x;
    public int y;
    public int velosity;
    private BufferedImage playerImage;
    private Random random;
    public Point firstLeftPoint,secondLeftPoint ,thirdLeftPoint
                 ,firstRightPoint,secondRightPoint,thirdRightPoint,
                 leftRearPoint,rightRearPoint;
    public OtherCars(int x, int y){
        this.x = x;
        this.y = y;
        this.velosity = 2;
        this.playerImage = Assets.playerCar1;
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


        if(this.y >= Game.HEIGHT){
            this.y = -210;
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
