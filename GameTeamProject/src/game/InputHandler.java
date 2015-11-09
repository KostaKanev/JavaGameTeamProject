package game;

import display.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    public InputHandler(Display display){

        display.getCanvas().addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_LEFT){
            Player.moovingLeft = true;

        }
        if(keyCode == KeyEvent.VK_RIGHT){
            Player.moovingRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_LEFT){
            Player.moovingLeft = false;
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            Player.moovingRight = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
