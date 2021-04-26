package utils;
import org.junit.Test;

import javax.imageio.IIOException;

import static org.assertj.core.api.Assertions.*;

//Integration Test
public class ImageLoaderTest {

    @Test
    public void testLoadImage() {
        assertThatExceptionOfType(IIOException.class).describedAs("Can't read input file!").isThrownBy(() -> ImageLoader.loadImage(""));
    }
}
