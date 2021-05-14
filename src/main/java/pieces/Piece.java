package pieces;

import board.Board;
import board.Square;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * The type Piece.
 */
public abstract class Piece {
    private final PieceColor color;
    private final BufferedImage image;
    private Square currentSquare;

    /**
     * Instantiates a new Piece.
     *
     * @param color      the color
     * @param image      the image
     * @param initSquare the init square
     */
    protected Piece(PieceColor color, BufferedImage image, Square initSquare) {
        this.color = color;
        this.image = image;
        this.currentSquare = initSquare;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }


    /**
     * Gets color.
     *
     * @return the color
     */
    public PieceColor getColor() {
        return color;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Square getPosition() {
        return this.currentSquare;
    }

    /**
     * Sets position.
     *
     * @param square the square
     */
    public void setPosition(Square square) {
        this.currentSquare = square;
    }

    /**
     * Draw.
     *
     * @param g the g
     */
    public void draw(Graphics g) {
        g.drawImage(this.image, this.currentSquare.getX(), this.currentSquare.getY(), null);
    }

    /**
     * Gets legal moves.
     *
     * @param b the b
     * @return the legal moves
     */
    public abstract List<Square> getLegalMoves(Board b);

    /**
     * Move boolean.
     *
     * @param arrivalSquare the arrival square
     * @return the boolean
     */
    public boolean move(Square arrivalSquare) {
        Piece occupyingPiece = arrivalSquare.getOccupyingPiece();

        if (occupyingPiece != null) {
            if (occupyingPiece.getColor() == this.color)
                return false;
            arrivalSquare.capture(this);
        }

        this.currentSquare.removePiece();
        arrivalSquare.putPiece(this);
        this.currentSquare = arrivalSquare;
        return true;
    }
}
