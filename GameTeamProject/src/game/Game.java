package game;

import display.Display;
import graphics.Assets;
import graphics.ImgLoader;
import graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game implements Runnable {
    public static final int WIDTH = 720;
    public static final int HEIGHT = 660;
    public static final int START_POSITION = 450;
    private final int LEFT_BORDER = 55;
    private final int RIGHT_BORDER = 332;
    private int index = 0;
    private String title;
    private Thread thread;
    private boolean isRunning;
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    private InputHandler ih;
    private SpriteSheet spriteSheet;

    private Player player;
    private ArrayList<OtherCars> otherCar;
    private Track track;
    private Scoreboard scoreboard;
    private Coins coins;
    public static boolean isDie = false;

    public Game(String title) {
        this.title = title;
        this.isRunning = false;
    }

    public void init(){
        this.display =  new Display(this.title, WIDTH, HEIGHT);
        this.ih = new InputHandler(this.display);
        this.spriteSheet = new SpriteSheet(ImgLoader.loadImage("/img/spriteCars.png"));
        Assets.init();
        this.track = new Track(START_POSITION, HEIGHT);
        this.otherCar = new ArrayList<>();
        otherCar.add(new OtherCars(Assets.taxi));
        otherCar.add(new OtherCars(Assets.playerCar1));
        otherCar.add(new OtherCars(Assets.blackViper));
        otherCar.add(new OtherCars(Assets.taxi));
        otherCar.add(new OtherCars(Assets.playerCar1));
        otherCar.add(new OtherCars(Assets.blackViper));
        otherCar.add(new OtherCars(Assets.audi));

        this.player = new Player(200, HEIGHT - 190);
        this.scoreboard = new Scoreboard(0,0, this.player);
        this.coins = new Coins(this.player);

    }

    private void tick(){
        this.otherCar.stream().forEach(a -> a.tick());
        this.track.tick();
        this.player.tick();
        if (this.player.getX() <= this.LEFT_BORDER) {

            this.player.setX(this.LEFT_BORDER);
        } else if (this.player.getX() >= this.RIGHT_BORDER) {

            this.player.setX(this.RIGHT_BORDER);
        }

        if(this.player.intersects(this.otherCar.get(0)) ||
                this.player.intersects(this.otherCar.get(1))||
                this.player.intersects(this.otherCar.get(2))||
                this.player.intersects(this.otherCar.get(3))||
                this.player.intersects(this.otherCar.get(4))||
                this.player.intersects(this.otherCar.get(5))||
                this.player.intersects(this.otherCar.get(6))
                ){
            int takeBlood = this.player.getBlood() - 10;
            this.player.setBlood(takeBlood);
        }
        this.scoreboard.tick();
        this.coins.tick();

        if(this.isDie){
            stop();
        }
    }

    private void render(){
        this.bs = this.display.getCanvas().getBufferStrategy();

        if(this.bs == null){
            this.display.getCanvas().createBufferStrategy(2);
            this.bs = display.getCanvas().getBufferStrategy();
        }
        this.g = this.bs.getDrawGraphics();

        //START DRAWING
        this.track.render(g);
        this.player.render(g);
        this.otherCar.get(index).render(g);

        if(otherCar.get(index).getY() >= HEIGHT - 60){
            index++;
            if(index >= otherCar.size()){
                index = 0;
            }
            otherCar.get(index).render(g);
        }

        if(this.player.getBlood() < 0){
            g.drawImage(Assets.red, -90, 0, Game.WIDTH - 50, Game.HEIGHT - 50, null);
            isDie = true;
        }
        this.scoreboard.render(g);
        this.coins.render(g);

        this.bs.show();
        this.g.dispose();
    }



    @Override
    public void run() {
        this.init();
        int fps = 30;
        double ticksPF = 1_000_000_000 / fps;
        double delta = 0;
        long now;
        long lastTimeTicked = System.nanoTime();

        while(isRunning){
            now = System.nanoTime();
            delta += (now - lastTimeTicked) / ticksPF;
            lastTimeTicked = now;
            if (delta >= 1){
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
