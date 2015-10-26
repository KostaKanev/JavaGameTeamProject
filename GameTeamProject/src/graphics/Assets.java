package graphics;

import java.awt.image.BufferedImage;


public class Assets {

    public static BufferedImage car, policeCar;

    public  static void init(){
        SpriteSheet spriteSheet = new SpriteSheet(
                ImgLoader.loadImage("/img/car.png")
        );

        policeCar = spriteSheet.crop(0,0,256,256);
        car = spriteSheet.crop(256,0,256,256);
    }
}
