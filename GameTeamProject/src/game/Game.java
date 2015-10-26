package game;

import display.Display;

public class Game implements Runnable{
    private String title;
    private int width;
    private int height;

    public Game(String title, int width, int height){

        this.title = title;
        this.width = width;
        this.height = height;
        new Display(this.title, this.width, this.height);
    }

    @Override
    public void run() {

    }
}
