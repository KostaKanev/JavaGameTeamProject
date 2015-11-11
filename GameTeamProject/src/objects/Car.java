package objects;

import game.Game;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Car {
    public final int DROP_POSITION_Y = -250;
    public final int VELOCITY = 8;
    private int index;
    private int x;
    private int y;

    private ArrayList<BufferedImage> playerImages;

    public Car() {
        this.x = 200;
        this.y = 50;
        this.playerImages = new ArrayList<>();
        playerImages.add(Assets.audi);
        playerImages.add(Assets.playerCar1);
        playerImages.add(Assets.policeCar);
        playerImages.add(Assets.taxi);
        playerImages.add(Assets.blackViper);
        this.index = 4;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void tick() {
        int y = this.getY() + VELOCITY;
        this.setY(y);
    }

    public void render(Graphics g) {
        g.drawImage(this.playerImages.get(index), this.x, this.y, null);
        if (this.getY() >= Game.HEIGHT * 2) {
            index++;
            if(index >= playerImages.size()){
                index = 0;
            }
            this.y = DROP_POSITION_Y;
            this.createNewCar(g);
        }
    }

    public void createNewCar(Graphics g) {

        g.drawImage(this.playerImages.get(index), this.x, this.y, null);
    }
}