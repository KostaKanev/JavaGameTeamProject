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
        this.velosity = 2;
        this.trackImage = ImgLoader.loadImage("/img/bkg.jpg");
    }

    public void tick(){

        this.y += 1;
    }

    public void render(Graphics g){

        g.drawImage(this.trackImage,0 , this.y, null);
    }

}
