package board;

import org.junit.Test;
import view.GUI;

import java.awt.*;

import static org.assertj.core.api.Assertions.*;

//Use Mocks maybe
public class SquareTest {

    @Test
    public void getOccupyingPiece() {
        Square sq = new Square(new Board(new GUI(100,0,0)), Color.WHITE,1,1);
        assertThat(sq.isOccupied()).isFalse();
    }

    @Test
    public void isOccupied() {
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
