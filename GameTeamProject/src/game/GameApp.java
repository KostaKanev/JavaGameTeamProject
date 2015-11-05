package game;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class GameApp {

    public static void main(String[] args){
        Game game = new Game("Cars");
        game.start();
        //Sound
        URL url = SoundTest.class.getResource("/audio/sound.wav");
        AudioClip clip = Applet.newAudioClip(url);
        SoundTest sound = new SoundTest(url, clip);
        sound.play();
    }
}
