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

        for (int xOffset = 1; xOffset > -2; xOffset--) {
            for (int yOffset = 1; yOffset > -2; yOffset--) {
                if (!(xOffset == 0 && yOffset == 0)) {
                    try {
                        if (!squares[y + yOffset][x + xOffset].isOccupied() ||
                                squares[y + yOffset][x + xOffset].getOccupyingPiece().getColor()
                                        != this.getColor()) {
                            legalMoves.add(squares[y + yOffset][x + xOffset]);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        //TODO: Change Approach
                        continue;
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
