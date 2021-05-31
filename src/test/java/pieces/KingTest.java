package pieces;

import board.Board;
import board.Square;
import org.junit.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.*;
public class KingTest {
    @Test
    public void Castled(){
        King king = new King(PieceColor.BLACK,null,new Square(new Board(), Color.WHITE,1,1));
        king.setCastled(true);
        assertThat(king.isCastled()).isTrue();
    }

    @Test
    public void legalMove(){

    }

}
