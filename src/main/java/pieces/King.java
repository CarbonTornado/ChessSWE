package pieces;

import board.Board;
import board.Square;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class King extends Piece {
    private boolean castled;

    public King(PieceColor color, BufferedImage image, Square initSq) {
        super(color, image, initSq);
        this.castled = false;
    }

    @Override
    public List<Square> getLegalMoves(Board b) {
        LinkedList<Square> legalMoves = new LinkedList<>();

        Square[][] squares = b.getSquares();

        int x = this.getPosition().getXPos();
        int y = this.getPosition().getYPos();

        for (int i = 1; i > -2; i--) {
            for (int k = 1; k > -2; k--) {
                if(!(i == 0 && k == 0)) {
                    try {
                        if(!squares[y + k][x + i].isOccupied() ||
                                squares[y + k][x + i].getOccupyingPiece().getColor()
                                        != this.getColor()) {
                            legalMoves.add(squares[y + k][x + i]);
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }
            }
        }

        return legalMoves;
    }

    public boolean isCastled() {
        return castled;
    }

    public void setCastled(boolean castled) {
        this.castled = castled;
    }
}
