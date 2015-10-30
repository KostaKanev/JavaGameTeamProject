package graphics;

import java.awt.image.BufferedImage;


public class Assets {
    private static final int width = 125;
    private static final int height = 350;

    public static BufferedImage playerCar1, playerCar2, playerCar3, ambulance, policeCar, taxi, playerCar4,
            playerCar5, playerCar6, playerCar7, animPoliceCar1, animPoliceCar2, animPoliceCar3;

    public static final int scoreDigitWidth = 52 , livesDigitWidth = 110;
    public static final int scoreDigitHeight = 60 , livesDigitHeight = 101;
    public static BufferedImage zeroScore, oneScore , twoScore, threeScore,
            fourScore, fiveScore, sixScore, sevenScore, eightScore, nineScore;
    public static BufferedImage zeroLives, oneLives, twoLives, threeLives,
            fourLives,fiveLives,sixLives,sevenLives,eightLives,nineLives;

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

        //All digits from "/img/digitsImg.png"
        SpriteSheet digitsSprite = new SpriteSheet(
                ImgLoader.loadImage("/img/digitsImg.png")
        );
        //Digits for Score
        zeroScore = digitsSprite.crop(28,80, scoreDigitWidth, scoreDigitHeight);
        oneScore = digitsSprite.crop(85,85, scoreDigitWidth, scoreDigitHeight);
        //Digits for Lives
        zeroLives = digitsSprite.crop(37,462,90,101);
        oneLives = digitsSprite.crop(147,462,74,livesDigitHeight);
        twoLives = digitsSprite.crop(235,462,83,livesDigitHeight);
        threeLives = digitsSprite.crop(335,462,91,livesDigitHeight);
        fourLives = digitsSprite.crop(443,462,84,livesDigitHeight);
        fiveLives = digitsSprite.crop(541,462,94,livesDigitHeight);
        sixLives = digitsSprite.crop(654,462,89,livesDigitHeight);
        sevenLives = digitsSprite.crop(758,462,94,livesDigitHeight);
        eightLives = digitsSprite.crop(865,462,90,livesDigitHeight);
        nineLives = digitsSprite.crop(970,462,91,livesDigitHeight);


        //players for animation
      /*  animPoliceCar1 = spriteSheet.crop(0,height,width,height);
        animPoliceCar2 = spriteSheet.crop(width + width/3,height,width,height);
        animPoliceCar3 = spriteSheet.crop(width *3,height,width,height);*/
    }
}
