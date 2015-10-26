package game;

import javax.swing.*;

public class Display {

    private int width;
    private int height;
    private String title;

    private JFrame frame;

    public Display(String title, int width, int height){

        this.width = width;
        this.height = height;
        this.title = title;

        createFrame();
    }
    private void createFrame(){
        frame = new JFrame(this.title);
        frame.setSize(this.width, this.height);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
