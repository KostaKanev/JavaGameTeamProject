package game;

import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OtherCars {
    private final int DROP_POSITION_Y = -250;
    public static final int WIDTH = 85;
    public static final int HEIGHT = 168;
    private final int VELOSITY = 7;
    private int x;
    private int y;
    private int supplement;

    private BufferedImage playerImage;

    public OtherCars(BufferedImage playerImage){
        this.x = 75;
        this.y = 25;
        this.playerImage = playerImage;
        this.supplement = 120;
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

    public int getSupplement(){
        return this.supplement;
    }

    public  void setSupplement(int supplement){
        this.supplement = supplement;
    }


    public void tick(){
        int addSupplement = this.getSupplement() + 60;
        int addY = this.getY() + VELOSITY;
        this.setY(addY);
        this.setSupplement(addSupplement);
        if(supplement >= 400){
            supplement = 80;
        }
    }
    public void render(Graphics g){
        g.drawImage(this.playerImage, this.x, this.y, null);
        if(this.getY() >= Game.HEIGHT){
            this.setY(DROP_POSITION_Y);
            this.setX(supplement);
            this.createNewCar(g);
        }
    }

   public void createNewCar(Graphics g){
       g.drawImage(this.playerImage, this.x, this.y, null);
   }
}
