package graphics;

import java.awt.image.BufferedImage;


public class Assets {
    private static final int width = 125;
    private static final int height = 256;
    public static BufferedImage playerCar1, playerCar2, playerCar3, ambulance;

    public  static void init(){
        SpriteSheet spriteSheet = new SpriteSheet(
                ImgLoader.loadImage("/img/car.png")
        );

        playerCar1 = spriteSheet.crop(0,0,width,height);
        playerCar2 = spriteSheet.crop(width*2 - (width/3),0,width,height);
        playerCar3 = spriteSheet.crop(width*4,0,width,height);
        ambulance = spriteSheet.crop(width*3,0,width,height);

    }
}
