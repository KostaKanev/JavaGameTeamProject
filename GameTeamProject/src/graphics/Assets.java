package graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 85;
    private static final int height = 168;

    public static BufferedImage playerCar1, blackViper, audi,policeCar, taxi;

    public static final int scoreDigitWidth = 52;
    public static final int scoreDigitHeight = 60 , livesDigitHeight = 101;
    public static BufferedImage zeroScore, oneScore , twoScore, threeScore,
            fourScore, fiveScore, sixScore, sevenScore, eightScore, nineScore;
    public static BufferedImage zeroLives, oneLives, twoLives, threeLives,
            fourLives,fiveLives,sixLives,sevenLives,eightLives,nineLives, score;
    public static BufferedImage hearthImage, coins, coinIcon;
    public static BufferedImage scoreboardImage;


    public  static void init(){
        SpriteSheet spriteSheet = new SpriteSheet(
                ImgLoader.loadImage("/img/spriteCars.png")
        );

          taxi = spriteSheet.crop(0,0,width,height);
          policeCar = spriteSheet.crop(width,0,width,height);
          playerCar1 = spriteSheet.crop(width*2,0,width,height);
          blackViper = spriteSheet.crop(width*3,0,width,height);
          audi = spriteSheet.crop(width*4,0,width - 12,height);

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
        coins = ImgLoader.loadImage("/img/nakovCoin.png");
        coinIcon = ImgLoader.loadImage("/img/coin_nakov.png");

    }
}
