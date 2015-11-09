package game;

import java.applet.AudioClip;
import java.net.URL;

public class SoundTest {
    public URL url;
    private AudioClip clip;

    public SoundTest(URL url, AudioClip clip){
        this.url = url;
        this.clip = clip;
    }

    public void play(){
        if(!Game.isDie) {
            this.clip.loop();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            this.clip.stop();
        }
    }
}
