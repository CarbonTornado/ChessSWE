package board;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.awt.*;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(sq.getOccupyingPiece()).isNull();
    }

    @Test
    public void removePiece() {
        assertThat(sq.getOccupyingPiece()).isNull();
    }

    @Test
    public void capture() {
        assertThat(sq.getOccupyingPiece()).isNull();
    }

    @Test
    public void getXPos() {
        assertThat(sq.getOccupyingPiece()).isNull();
    }

    @Test
    public void getYPos() {
        assertThat(sq.getOccupyingPiece()).isNull();
    }
}
