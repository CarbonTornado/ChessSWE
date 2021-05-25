package utils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

//Integration Test
public class ImageLoaderTest {


    //TODO: Test weird edge case where a random image is loaded is resource does not exist
    //TODO: Fix and rework
    /// @Test
    public void testLoadImage() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/Chess_kdt60.png"));

        assertThat(ImageLoader.loadImage(System.getProperty("user.dir") + "/src/main/resources/Chess_kdt60.png")).isEqualTo(bufferedImage);
    }
}
