package game;

import display.Display;
import graphics.Assets;
import graphics.ImgLoader;
import graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
    private String title;
    private int width;
    private int height;
    private Thread thread;
    private boolean isRunning;
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    private SpriteSheet sh;
    private int x = 269;
    private int y = 410;
    public Game(String title, int width, int height){

        this.title = title;
        this.width = width;
        this.height = height;
        this.isRunning = false;
    }

    public void init(){
        this.display =  new Display(this.title, this.width, this.height);
        this.sh = new SpriteSheet(ImgLoader.loadImage("/img/car.png"));
        Assets.init();
    }

    private void tick(){

    }

    private void render(){
        this.bs = this.display.getCanvas().getBufferStrategy();

        if(this.bs == null){
            this.display.getCanvas().createBufferStrategy(2);
            this.bs = display.getCanvas().getBufferStrategy();
        }

        this.g = this.bs.getDrawGraphics();
        this.g.clearRect(0,0,this.width,this.height);
        this.g.drawImage(ImgLoader.loadImage("/img/bkg.jpg"),0,0,null);
        //this.g.drawImage(this.sh.crop(0,0,256,256),0,0,null);
        this.g.drawImage(Assets.policeCar,x,y,null);

        this.bs.show();
        this.g.dispose();

    }

    @Override
    public void run() {
        this.init();
        int fps = 30;
        double ticksPF = 1_000_000_000/fps;
        double delta = 0;
        long now;
        long lastTT = System.nanoTime();

        while(isRunning){
            now = System.nanoTime();
            delta += (now - lastTT) / ticksPF;
            lastTT = now;
            if (delta >=1){
                tick();
                render();
                delta--;
            }
        }
        this.stop();
    }

    public synchronized void start(){
        if(this.isRunning){
            return;
        }
        this.isRunning = true;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public synchronized void stop(){
        if(!this.isRunning){
            return;
        }
        this.isRunning = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
