package pieces;

import board.Board;
import board.Square;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class Pawn extends Piece {
    public boolean positionIsInitial = true;

    /**
     * Instantiates a new Piece.
     *
     * @param color      the color
     * @param image      the image
     * @param initSquare the init square
     */
    public Pawn(PieceColor color, BufferedImage image, Square initSquare) {
        super(color, image, initSquare);
    }

    @Override
    public boolean move(Square arrivalSquare) {
        positionIsInitial = false;
        return super.move(arrivalSquare);
    }

    @Override
    public List<Square> getLegalMoves(Board b) {
        //TODO: Add Test for bug for not having legal move
        LinkedList<Square> legalMoves = new LinkedList<>();

        Square[][] squares = b.getSquares();

        int x = this.getPosition().getXPos();
        int y = this.getPosition().getYPos();
        int yOffset = 1;
        if(this.getColor() == PieceColor.BLACK) yOffset = -yOffset;
        if (positionIsInitial) {
            legalMoves.add(squares[x][y - 2*yOffset]);
        }
        if (!squares[x][y - yOffset].isOccupied()) {
            legalMoves.add(squares[x][y - yOffset]);
        }
        return legalMoves;
    }
}
