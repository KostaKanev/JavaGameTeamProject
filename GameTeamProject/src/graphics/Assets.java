package graphics;

import java.awt.image.BufferedImage;


public class Assets {
    private static final int width = 125;
    private static final int height = 350;

    public static BufferedImage playerCar1, playerCar2, playerCar3, ambulance, policeCar, taxi, playerCar4,
            playerCar5, playerCar6, playerCar7, animPoliceCar1, animPoliceCar2, animPoliceCar3;

    public static final int scoreDigitWidth = 52;
    public static final int scoreDigitHeight = 60 , livesDigitHeight = 101;
    public static BufferedImage zeroScore, oneScore , twoScore, threeScore,
            fourScore, fiveScore, sixScore, sevenScore, eightScore, nineScore;
    public static BufferedImage zeroLives, oneLives, twoLives, threeLives,
            fourLives,fiveLives,sixLives,sevenLives,eightLives,nineLives, score;
    public static BufferedImage hearthImage;
    public static BufferedImage scoreboardImage;

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
        int scoreDigitsY = 27;
        int multiplier = 57;
        zeroScore = digitsSprite.crop(scoreDigitsY,75, scoreDigitWidth, scoreDigitHeight);
        oneScore = digitsSprite.crop(scoreDigitsY + multiplier,75, scoreDigitWidth, scoreDigitHeight);
        twoScore = digitsSprite.crop(scoreDigitsY + multiplier * 2,75, scoreDigitWidth, scoreDigitHeight);
        threeScore = digitsSprite.crop(scoreDigitsY + multiplier * 3,75, scoreDigitWidth, scoreDigitHeight);
        fourScore = digitsSprite.crop(scoreDigitsY + multiplier * 4,75, scoreDigitWidth, scoreDigitHeight);
        fiveScore = digitsSprite.crop(scoreDigitsY + multiplier * 5,75, scoreDigitWidth, scoreDigitHeight);
        sixScore = digitsSprite.crop(scoreDigitsY + multiplier * 6,75, scoreDigitWidth, scoreDigitHeight);
        sevenScore = digitsSprite.crop(scoreDigitsY + multiplier * 7,75, scoreDigitWidth, scoreDigitHeight);
        eightScore = digitsSprite.crop(scoreDigitsY + multiplier * 8,75, scoreDigitWidth, scoreDigitHeight);
        nineScore = digitsSprite.crop(scoreDigitsY + multiplier * 9,75, scoreDigitWidth, scoreDigitHeight);

        //Digits for Lives
        int liveDigitsY = 462;
        zeroLives = digitsSprite.crop(37,liveDigitsY,90,livesDigitHeight);
        oneLives = digitsSprite.crop(147,liveDigitsY,74,livesDigitHeight);
        twoLives = digitsSprite.crop(235,liveDigitsY,83,livesDigitHeight);
        threeLives = digitsSprite.crop(335,liveDigitsY,91,livesDigitHeight);
        fourLives = digitsSprite.crop(443,liveDigitsY,84,livesDigitHeight);
        fiveLives = digitsSprite.crop(541,liveDigitsY,94,livesDigitHeight);
        sixLives = digitsSprite.crop(654,liveDigitsY,89,livesDigitHeight);
        sevenLives = digitsSprite.crop(758,liveDigitsY,94,livesDigitHeight);
        eightLives = digitsSprite.crop(865,liveDigitsY,90,livesDigitHeight);
        nineLives = digitsSprite.crop(970,liveDigitsY,91,livesDigitHeight);


        //Scoreboard Image
        scoreboardImage = ImgLoader.loadImage("/img/scoreboardBack.jpg");
        //Items
        hearthImage = ImgLoader.loadImage("/img/heart.png");
        score = ImgLoader.loadImage("/img/score5.png");

        //players for animation
      /*  animPoliceCar1 = spriteSheet.crop(0,height,width,height);
        animPoliceCar2 = spriteSheet.crop(width + width/3,height,width,height);
        animPoliceCar3 = spriteSheet.crop(width *3,height,width,height);*/
    }
}
