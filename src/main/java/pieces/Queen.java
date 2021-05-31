package pieces;

import board.Board;
import board.Square;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Queen extends Piece{
    /**
     * Instantiates a new Piece.
     *
     * @param color      the color
     * @param image      the image
     * @param initSquare the init square
     */
    public Queen(PieceColor color, BufferedImage image, Square initSquare) {
        super(color, image, initSquare);
    }

    @Override
    public List<Square> getLegalMoves(Board b) {
        List<Square> legalMoves;

        Square[][] squares = b.getSquares();

        int x = this.getPosition().getXPos();
        int y = this.getPosition().getYPos();

        legalMoves = Stream.concat(getDiagMoves(squares,x,y).stream(), getStraightMoves(squares,x,y).stream())
                .collect(Collectors.toList());

        return legalMoves;
    }
}
