package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
    private static BufferedImage img;

    private ImageLoader() {
    }

    /**
     * Load image from filesystem
     *
     * @param path path to piece image
     * @return the buffered image
     */
    public static BufferedImage loadImage(String path) {
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
