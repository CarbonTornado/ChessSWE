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


        //TODO: Check for blockage
     /*   for (int xOffset = squares.length; xOffset >= -squares.length; xOffset--) {
            for (int yOffset = squares.length; yOffset >= -squares.length; yOffset--) {
                if ((x + xOffset >= 0 && y + yOffset >= 0) && (x + xOffset < squares.length && y + yOffset < squares.length)) {
                    if (!squares[x + xOffset][y + yOffset].isOccupied() ||
                            squares[x + xOffset][y + yOffset].getOccupyingPiece().getColor()
                                    != this.getColor()) {
                        legalMoves.add(squares[x + xOffset][y + yOffset]);
                    }
                }
            }
        } */

        return legalMoves;
    }
}
