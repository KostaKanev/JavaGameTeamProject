package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImgLoader {
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(com.sun.deploy.ui.ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
