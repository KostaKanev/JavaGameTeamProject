package game;

import display.Display;
import graphics.Assets;
import graphics.ImgLoader;
import graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Runnable {
    public static final int WIDTH = 720;
    public static final int HEIGHT = 660;
    public static final int START_POSITION = 480 - 210;
    private static int index = 0;
    private String title;
    private Thread thread;
    private boolean isRunning;
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    private InputHandler ih;
    private Random random;
    private SpriteSheet spriteSheet;

    private static Player player;
    private ArrayList<OtherCars> otherCar;
    private Track track;
    private Scoreboard scoreboard;

    public Game(String title)
    {
        this.title = title;
        this.isRunning = false;
        this.random = new Random();

    }

    public void init(){
        int randomNum = random.nextInt(296);
        this.display =  new Display(this.title, this.WIDTH, this.HEIGHT);
        this.ih = new InputHandler(this.display);
        this.spriteSheet = new SpriteSheet(ImgLoader.loadImage("/img/car.png"));
        Assets.init();
        this.track = new Track(START_POSITION,this.HEIGHT);
        this.otherCar = new ArrayList<>();
        otherCar.add(new OtherCars(randomNum, 0, Assets.playerCar7));
        otherCar.add(new OtherCars(randomNum, 0, Assets.playerCar2));
        otherCar.add(new OtherCars(randomNum, 0, Assets.taxi));
        otherCar.add(new OtherCars(randomNum, 0, Assets.playerCar3));
        otherCar.add(new OtherCars(randomNum, 0, Assets.playerCar1));
        otherCar.add(new OtherCars(randomNum, 0, Assets.playerCar5));

        this.player = new Player(START_POSITION + 10, this.HEIGHT - 250);

        this.scoreboard = new Scoreboard(0,0);

    }
    boolean isHit = false;
    private void tick(){
        this.otherCar.stream().forEach(a -> a.tick());
        this.track.tick();
        this.player.tick();
        this.scoreboard.tick();

        if (this.player.x <= 25) {

            this.player.x = 25;
        } else if (this.player.x >= 303) {

            this.player.x = 303;
        }
        if(this.player.intersects(this.otherCar.get(0)) ||
                this.player.intersects(this.otherCar.get(1))||
                this.player.intersects(this.otherCar.get(2))||
                this.player.intersects(this.otherCar.get(3))||
                this.player.intersects(this.otherCar.get(4))||
                this.player.intersects(this.otherCar.get(5))){
           this.player.blood--;
          isHit = true;
        }

        if(this.player.blood <= 0) {
            System.out.println("Dead");
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

        if(this.otherCar.get(index).y >= this.HEIGHT - 90){
            index++;
            if(index >= this.otherCar.size()){
                index = 0;
            }
            this.otherCar.get(index).render(g);
        }

        if(isHit == true){
            g.drawImage(ImgLoader.loadImage("/img/redf.png"), 0, 0, this.WIDTH, this.HEIGHT, null);
            isHit = false;
        }

        this.scoreboard.render(g);
        //END DRAWING
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
