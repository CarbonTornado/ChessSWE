package pieces;

import board.Board;
import board.Square;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

/**
 * The type King.
 */
public class King extends Piece {
    private boolean castled;

    /**
     * Instantiates a new King.
     *
     * @param color  the color
     * @param image  the image
     * @param initSq the init sq
     */
    public King(PieceColor color, BufferedImage image, Square initSq) {
        super(color, image, initSq);
        this.castled = false;
    }

    //TODO: Add test for no OOB
    @Override
    public List<Square> getLegalMoves(Board b) {
        LinkedList<Square> legalMoves = new LinkedList<>();

        Square[][] squares = b.getSquares();

        int x = this.getPosition().getXPos();
        int y = this.getPosition().getYPos();

        for (int xOffset = 1; xOffset >= -1; xOffset--) {
            for (int yOffset = 1; yOffset >= -1; yOffset--) {
                if ((x + xOffset >= 0 && y + yOffset >= 0) && (x + xOffset < squares.length && y + yOffset < squares.length)) {
                    if (!squares[x + xOffset][y + yOffset].isOccupied() ||
                            squares[x + xOffset][y + yOffset].getOccupyingPiece().getColor()
                                    != this.getColor()) {
                        legalMoves.add(squares[x + xOffset][y + yOffset]);
                    }
                }
            }
        }

        return legalMoves;
    }

    /**
     * Is castled boolean.
     *
     * @return the boolean
     */
    public boolean isCastled() {
        return castled;
    }

    /**
     * Sets castled.
     *
     * @param castled the castled
     */
    public void setCastled(boolean castled) {
        this.castled = castled;
    }
}
