package game;

import graphics.Assets;
import graphics.ImgLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Scoreboard {
    private final int yForScore = 280;
    private final int xForThents = 645;
    private final int xForHundreds = 595;
    private final int xForThousandths = 545;
    private final int xForTenThousands = 495;
    private int x;
    private int y;

    public Scoreboard(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tick() {

    }

    public void render(Graphics g) {

        g.drawImage(Assets.scoreboardImage,475,0,null);
        this.drawScore(g, Player.score);
        g.drawImage(Assets.hearthImage,480,117,null);
        g.drawImage(Assets.zeroLives,545,70,null);
        g.drawImage(Assets.oneLives,635,70,null);
        g.drawImage(Assets.score, 560, 240, null);
        g.drawImage(Assets.coins, 470, 220, null);
        g.drawImage(Assets.beer, 280, 350, null);
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
                    g.drawImage(Assets.zeroScore, xForThents, yForScore, null);
                    break;
                case 1:
                    g.drawImage(Assets.oneScore, xForThents, yForScore, null);
                    break;
                case 2:
                    g.drawImage(Assets.twoScore, xForThents, yForScore, null);
                    break;
                case 3:
                    g.drawImage(Assets.threeScore, xForThents, yForScore, null);
                    break;
                case 4:
                    g.drawImage(Assets.fourScore, xForThents, yForScore, null);
                    break;
                case 5:
                    g.drawImage(Assets.fiveScore, xForThents, yForScore, null);
                    break;
                case 6:
                    g.drawImage(Assets.sixScore, xForThents, yForScore, null);
                    break;
                case 7:
                    g.drawImage(Assets.sevenScore, xForThents, yForScore, null);
                    break;
                case 8:
                    g.drawImage(Assets.eightScore, xForThents, yForScore, null);
                    break;
                case 9:
                    g.drawImage(Assets.nineScore, xForThents, yForScore, null);
                    break;
            }

            switch (hundredsOfScore) {
                case 0:
                    g.drawImage(Assets.zeroScore, xForHundreds, yForScore, null);
                    break;
                case 1:
                    g.drawImage(Assets.oneScore, xForHundreds, yForScore, null);
                    break;
                case 2:
                    g.drawImage(Assets.twoScore, xForHundreds, yForScore, null);
                    break;
                case 3:
                    g.drawImage(Assets.threeScore, xForHundreds, yForScore, null);
                    break;
                case 4:
                    g.drawImage(Assets.fourScore, xForHundreds, yForScore, null);
                    break;
                case 5:
                    g.drawImage(Assets.fiveScore, xForHundreds, yForScore, null);
                    break;
                case 6:
                    g.drawImage(Assets.sixScore, xForHundreds, yForScore, null);
                    break;
                case 7:
                    g.drawImage(Assets.sevenScore, xForHundreds, yForScore, null);
                    break;
                case 8:
                    g.drawImage(Assets.eightScore, xForHundreds, yForScore, null);
                    break;
                case 9:
                    g.drawImage(Assets.nineScore, xForHundreds, yForScore, null);
                    break;
            }


            switch (thousandthsOfScore) {
                case 0:
                    g.drawImage(Assets.zeroScore, xForThousandths, yForScore, null);
                    break;
                case 1:
                    g.drawImage(Assets.oneScore, xForThousandths, yForScore, null);
                    break;
                case 2:
                    g.drawImage(Assets.twoScore, xForThousandths, yForScore, null);
                    break;
                case 3:
                    g.drawImage(Assets.threeScore, xForThousandths, yForScore, null);
                    break;
                case 4:
                    g.drawImage(Assets.fourScore, xForThousandths, yForScore, null);
                    break;
                case 5:
                    g.drawImage(Assets.fiveScore, xForThousandths, yForScore, null);
                    break;
                case 6:
                    g.drawImage(Assets.sixScore, xForThousandths, yForScore, null);
                    break;
                case 7:
                    g.drawImage(Assets.sevenScore, xForThousandths, yForScore, null);
                    break;
                case 8:
                    g.drawImage(Assets.eightScore, xForThousandths, yForScore, null);
                    break;
                case 9:
                    g.drawImage(Assets.nineScore, xForThousandths, yForScore, null);
                    break;
            }

            switch (tenThousandsOfScore) {
                case 0:
                    g.drawImage(Assets.zeroScore, xForTenThousands, yForScore, null);
                    break;
                case 1:
                    g.drawImage(Assets.oneScore, xForTenThousands, yForScore, null);
                    break;
                case 2:
                    g.drawImage(Assets.twoScore, xForTenThousands, yForScore, null);
                    break;
                case 3:
                    g.drawImage(Assets.threeScore, xForTenThousands, yForScore, null);
                    break;
                case 4:
                    g.drawImage(Assets.fourScore, xForTenThousands, yForScore, null);
                    break;
                case 5:
                    g.drawImage(Assets.fiveScore, xForTenThousands, yForScore, null);
                    break;
                case 6:
                    g.drawImage(Assets.sixScore, xForTenThousands, yForScore, null);
                    break;
                case 7:
                    g.drawImage(Assets.sevenScore, xForTenThousands, yForScore, null);
                    break;
                case 8:
                    g.drawImage(Assets.eightScore, xForTenThousands, yForScore, null);
                    break;
                case 9:
                    g.drawImage(Assets.nineScore, xForTenThousands, yForScore, null);
                    break;
            }
        }
    }

