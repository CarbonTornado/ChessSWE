package utils;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.when;

public class ImageLoaderTest {

    @Test
    public void testLoadImage() throws IOException {
        PowerMockito.mockStatic(ImageIO.class);

        when(ImageIO.read((File) any())).thenAnswer(invocation -> {
            Object argument = invocation.getArguments()[0];
            // here you can check what arguments you were passed

            // here you can fill in some data so the image isn't blank

            return new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        });

        assertThat(ImageLoader.loadImage(null)).isEqualTo(new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB));
    }
}
