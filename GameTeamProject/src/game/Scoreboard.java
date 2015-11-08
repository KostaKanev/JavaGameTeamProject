package game;

import graphics.Assets;
import graphics.ImgLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Scoreboard {
    private final int Y_FOR_BLOOD = 80;
    private final int X_FOR_TENTHS_BLOOD = 630;
    private final int X_FOR_HUNDREDS_BLOOD = 540;

    private final int Y_FOR_SCORE = 280;
    private final int X_FOR_TENTHS_SCORE = 645;
    private final int X_FOR_HUNDREDS_SCORE = 597;
    private final int X_FOR_THOUSANDS_SCORE = 545;
    private final int X_FOR_TEN_THOUSANDS_SCORE = 495;
    private Player player;
    private int x;
    private int y;

    public Scoreboard(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public void tick() {

    }

    public void render(Graphics g) {

        g.drawImage(Assets.scoreboardImage,475,0,null);
        this.drawScore(g, this.player.getScore());
        this.drawBlood(g, this.player.getBlood());
        g.drawImage(Assets.hearthImage,480,95,null);

        g.drawImage(Assets.score, 560, 240, null);
        g.drawImage(Assets.coins, 470, 220, null);
        g.drawImage(Assets.logo, 400, 390, null);
    }
    public void drawBlood(Graphics g, int blood){
        int tenthsOfBlood = blood%10;

        int secondDigit = blood/10;
        int hundredsOfBlood = secondDigit%10;

        switch (tenthsOfBlood) {
            case 0:
                g.drawImage(Assets.zeroLives, X_FOR_TENTHS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 1:
                g.drawImage(Assets.oneLives, X_FOR_TENTHS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 2:
                g.drawImage(Assets.twoLives, X_FOR_TENTHS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 3:
                g.drawImage(Assets.threeLives, X_FOR_TENTHS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 4:
                g.drawImage(Assets.fourLives, X_FOR_TENTHS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 5:
                g.drawImage(Assets.fiveLives, X_FOR_TENTHS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 6:
                g.drawImage(Assets.sixLives, X_FOR_TENTHS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 7:
                g.drawImage(Assets.sevenLives, X_FOR_TENTHS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 8:
                g.drawImage(Assets.eightLives, X_FOR_TENTHS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 9:
                g.drawImage(Assets.nineLives, X_FOR_TENTHS_BLOOD, Y_FOR_BLOOD, null);
                break;
        }

        switch (hundredsOfBlood) {
            case 0:
                g.drawImage(Assets.zeroLives, X_FOR_HUNDREDS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 1:
                g.drawImage(Assets.oneLives, X_FOR_HUNDREDS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 2:
                g.drawImage(Assets.twoLives, X_FOR_HUNDREDS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 3:
                g.drawImage(Assets.threeLives, X_FOR_HUNDREDS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 4:
                g.drawImage(Assets.fourLives, X_FOR_HUNDREDS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 5:
                g.drawImage(Assets.fiveLives, X_FOR_HUNDREDS_BLOOD,Y_FOR_BLOOD, null);
                break;
            case 6:
                g.drawImage(Assets.sixLives, X_FOR_HUNDREDS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 7:
                g.drawImage(Assets.sevenLives, X_FOR_HUNDREDS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 8:
                g.drawImage(Assets.eightLives, X_FOR_HUNDREDS_BLOOD, Y_FOR_BLOOD, null);
                break;
            case 9:
                g.drawImage(Assets.nineLives, X_FOR_HUNDREDS_BLOOD, Y_FOR_BLOOD, null);
                break;
        }

    }
    public void drawScore(Graphics g, int score){
        int tenthsOfScore = score%10;

        int secondDigit = score/10;
        int hundredsOfScore = secondDigit%10;

        int thirdDigit = score/100;
        int thousandthsOfScore = thirdDigit%10;

        int fourDigit = score/1000;
        int tenThousandsOfScore = fourDigit%10;

            switch (tenthsOfScore) {
                case 0:
                    g.drawImage(Assets.zeroScore, X_FOR_TENTHS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 1:
                    g.drawImage(Assets.oneScore, X_FOR_TENTHS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 2:
                    g.drawImage(Assets.twoScore, X_FOR_TENTHS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 3:
                    g.drawImage(Assets.threeScore, X_FOR_TENTHS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 4:
                    g.drawImage(Assets.fourScore, X_FOR_TENTHS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 5:
                    g.drawImage(Assets.fiveScore, X_FOR_TENTHS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 6:
                    g.drawImage(Assets.sixScore, X_FOR_TENTHS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 7:
                    g.drawImage(Assets.sevenScore, X_FOR_TENTHS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 8:
                    g.drawImage(Assets.eightScore, X_FOR_TENTHS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 9:
                    g.drawImage(Assets.nineScore, X_FOR_TENTHS_SCORE, Y_FOR_SCORE, null);
                    break;
            }

            switch (hundredsOfScore) {
                case 0:
                    g.drawImage(Assets.zeroScore, X_FOR_HUNDREDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 1:
                    g.drawImage(Assets.oneScore, X_FOR_HUNDREDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 2:
                    g.drawImage(Assets.twoScore, X_FOR_HUNDREDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 3:
                    g.drawImage(Assets.threeScore, X_FOR_HUNDREDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 4:
                    g.drawImage(Assets.fourScore, X_FOR_HUNDREDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 5:
                    g.drawImage(Assets.fiveScore, X_FOR_HUNDREDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 6:
                    g.drawImage(Assets.sixScore, X_FOR_HUNDREDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 7:
                    g.drawImage(Assets.sevenScore, X_FOR_HUNDREDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 8:
                    g.drawImage(Assets.eightScore, X_FOR_HUNDREDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 9:
                    g.drawImage(Assets.nineScore, X_FOR_HUNDREDS_SCORE, Y_FOR_SCORE, null);
                    break;
            }


            switch (thousandthsOfScore) {
                case 0:
                    g.drawImage(Assets.zeroScore, X_FOR_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 1:
                    g.drawImage(Assets.oneScore, X_FOR_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 2:
                    g.drawImage(Assets.twoScore, X_FOR_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 3:
                    g.drawImage(Assets.threeScore, X_FOR_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 4:
                    g.drawImage(Assets.fourScore, X_FOR_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 5:
                    g.drawImage(Assets.fiveScore, X_FOR_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 6:
                    g.drawImage(Assets.sixScore, X_FOR_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 7:
                    g.drawImage(Assets.sevenScore, X_FOR_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 8:
                    g.drawImage(Assets.eightScore, X_FOR_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 9:
                    g.drawImage(Assets.nineScore, X_FOR_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
            }

            switch (tenThousandsOfScore) {
                case 0:
                    g.drawImage(Assets.zeroScore, X_FOR_TEN_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 1:
                    g.drawImage(Assets.oneScore, X_FOR_TEN_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 2:
                    g.drawImage(Assets.twoScore, X_FOR_TEN_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 3:
                    g.drawImage(Assets.threeScore, X_FOR_TEN_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 4:
                    g.drawImage(Assets.fourScore, X_FOR_TEN_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 5:
                    g.drawImage(Assets.fiveScore, X_FOR_TEN_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 6:
                    g.drawImage(Assets.sixScore, X_FOR_TEN_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 7:
                    g.drawImage(Assets.sevenScore, X_FOR_TEN_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 8:
                    g.drawImage(Assets.eightScore, X_FOR_TEN_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
                case 9:
                    g.drawImage(Assets.nineScore, X_FOR_TEN_THOUSANDS_SCORE, Y_FOR_SCORE, null);
                    break;
            }
        }
    }

