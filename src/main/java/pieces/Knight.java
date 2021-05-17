package pieces;

import board.Board;
import board.Square;

import java.awt.image.BufferedImage;
import java.util.List;

public class Knight extends Piece{
    /**
     * Instantiates a new Piece.
     *
     * @param color      the color
     * @param image      the image
     * @param initSquare the init square
     */
    protected Knight(PieceColor color, BufferedImage image, Square initSquare) {
        super(color, image, initSquare);
    }

    @Override
    public List<Square> getLegalMoves(Board b) {
        return null;
    }
}