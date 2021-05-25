package pieces;

import board.Board;
import board.Square;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class Knight extends Piece{
    /**
     * Instantiates a new Piece.
     *
     * @param color      the color
     * @param image      the image
     * @param initSquare the init square
     */
    public Knight(PieceColor color, BufferedImage image, Square initSquare) {
        super(color, image, initSquare);
    }

    @Override
    public List<Square> getLegalMoves(Board b) {
        LinkedList<Square> legalMoves = new LinkedList<>();

        Square[][] squares = b.getSquares();

        int x = this.getPosition().getXPos();
        int y = this.getPosition().getYPos();

        for (int xOffset = 2; xOffset >= -2; xOffset--) {
            for (int yOffset = 3; yOffset >= -3; yOffset--) {
                if ((x + xOffset >= 0 && y + yOffset >= 0) && (x + xOffset < squares.length && y + yOffset < squares.length) && Math.abs(xOffset) == 2 ^ Math.abs(yOffset) == 2) {
                        legalMoves.add(squares[x + xOffset][y + yOffset]);
                }
            }
        }

        return legalMoves;
    }
}
