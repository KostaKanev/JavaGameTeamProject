package game;

import graphics.Assets;
import graphics.ImgLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Scoreboard {

    public int x;
    public int y;
    private BufferedImage boardImage;



    public Scoreboard(int x, int y) {


        //this.x = 0;
        //this.y = 0;
        //this.boardImage = Assets. ...

    }


    public void tick() {



    }

    public void render(Graphics g) {

        for (int i = 0; i < 5 ; i++) {
            g.drawImage(Assets.zeroScore,480 + (45 * i),250,null);
        }
        g.drawImage(Assets.zeroLives,525,70,null);
        g.drawImage(Assets.oneLives,613,70,null);

    }





}
