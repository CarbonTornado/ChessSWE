package board;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.awt.*;

import static org.assertj.core.api.Assertions.*;

//Use Mocks maybe
public class SquareTest {

    private static Square sq;
    @BeforeAll
    public static void init(){
         sq = new Square(new Board(), Color.WHITE,1,1);
    }

    @Test
    public void getOccupyingPiece() {
        assertThat(sq.getOccupyingPiece()).isNull();
    }

    @Test
    public void isOccupied() {

        assertThat(sq.isOccupied()).isFalse();
    }

    @Test
    public void putPiece() {
    }

    @Test
    public void removePiece() {
    }

    @Test
    public void capture() {
    }

    @Test
    public void getXPos() {
    }

    @Test
    public void getYPos() {
    }
}
