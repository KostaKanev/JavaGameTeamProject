package game;

import graphics.ImgLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Track {

    public int x;
    public int y;
    public int velosity;

    private BufferedImage trackImage;

    public Track (int x, int y) {
        this.x = x;
        this.y = y;

        this.velosity = 10;

        this.trackImage = ImgLoader.loadImage("/img/bkg.jpg");
    }

    public void tick(){

        this.y += this.velosity;

    }

    public void render(Graphics g){

        g.drawImage(this.trackImage,0 , this.y, null);
        //Change number of iterations to increase track length :)
        //5 = 10 sec
        //10 = 20 sec
        //15 = 30 sec
        //...
        for (int i = 1; i < 500; i++) {
            g.drawImage(this.trackImage, 0, this.y - (660 * i),null);
        }
    }
}