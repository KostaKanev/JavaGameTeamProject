package game;

import display.Display;

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

    public Game(String title, int width, int height){

        this.title = title;
        this.width = width;
        this.height = height;
        this.isRunning = false;
    }

    public void init(){
       display =  new Display(this.title, this.width, this.height);
    }

    private void tick(){

    }

    private void render(){
        this.bs = display.getCanvas().getBufferStrategy();

        if(this.bs == null){
            this.display.getCanvas().createBufferStrategy(2);
            this.bs = display.getCanvas().getBufferStrategy();
        }

        this.g = this.bs.getDrawGraphics();

        //set color
        g.setColor(Color.cyan);
        //here we can draw
        g.fillRect(3, 3, 20, 20);

        //again
        g.setColor(Color.cyan);
        g.fillOval(10, 20, 30, 40);

        this.bs.show();
        this.g.dispose();
    }

    @Override
    public void run() {

        init();
        while(isRunning){
            tick();
            render();
        }
        stop();
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
