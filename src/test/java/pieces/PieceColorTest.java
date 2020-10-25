package pieces;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PieceColorTest {

    @Test
    public void BlackColor(){
        assertThat(PieceColor.BLACK.getName()).isEqualTo("Black");
    }

    @Test
    public void WhiteColor(){
        assertThat(PieceColor.WHITE.getName()).isEqualTo("White");
    }
}
