package graphics;

import java.awt.image.BufferedImage;


public class Assets {
    private static final int width = 125;
    private static final int height = 350;
    public static BufferedImage playerCar1, playerCar2, playerCar3, ambulance, policeCar, taxi, playerCar4,
            playerCar5, playerCar6, playerCar7, animPoliceCar1, animPoliceCar2, animPoliceCar3;

    public  static void init(){
        SpriteSheet spriteSheet = new SpriteSheet(
                ImgLoader.loadImage("/img/car.png")
        );

        playerCar1 = spriteSheet.crop(0,0,width,height);
        playerCar2 = spriteSheet.crop(width*2 - (width/3),0,width,height);
        ambulance = spriteSheet.crop(width*3,0,width,height);
        playerCar3 = spriteSheet.crop(width*4,0,width,height);
        policeCar = spriteSheet.crop(width*6 - width/2,0,width,height);
        taxi = spriteSheet.crop(width*7,0,width,height);
        playerCar4 = spriteSheet.crop(width*8 + width/3,0,width,height);
        playerCar5 = spriteSheet.crop(width*9 + width/2,0,width,height);
        playerCar6 = spriteSheet.crop(width*9 + width/2 + 10,height,width,height);
        playerCar7 = spriteSheet.crop(width*8 + width/3,height,width,height);

        //players for animation
      /*  animPoliceCar1 = spriteSheet.crop(0,height,width,height);
        animPoliceCar2 = spriteSheet.crop(width + width/3,height,width,height);
        animPoliceCar3 = spriteSheet.crop(width *3,height,width,height);*/
    }
}
