package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OtherCars {
    private final int DROP_POSITION_Y = -250;
    public static int x;
    public static int y;
    public static int width;
    public static int height;
    private int velosity;
    private BufferedImage playerImage;
    private int supplement = 80;

    public OtherCars(int x, int y, BufferedImage playerImage){
        this.x = x;
        this.y = y;
        this.velosity = 3;
        this.playerImage = playerImage;
        this.width = 85;
        this.height = 168;
    }

    public void tick(){

        this.y += this.velosity;
        this.supplement += 60;
        if(supplement >= 400){
            supplement = 80;
        }
    }

    public void render(Graphics g){
        g.drawImage(this.playerImage, this.x, this.y, null);
        if(this.y >= Game.HEIGHT){
            this.y = DROP_POSITION_Y;
            this.x = supplement;
            this.createNewCar(g);
        }
    }

   public void createNewCar(Graphics g){
       g.drawImage(this.playerImage, this.x, this.y, null);
   }

}
