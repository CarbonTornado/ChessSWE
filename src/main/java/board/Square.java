package board;

import pieces.Piece;

import javax.swing.*;
import java.awt.*;

/**
 * The type Square.
 */
public class Square extends JComponent {

    private final Board board;
    private final int xPos;
    private final int yPos;
    private Piece occupyingPiece;
    private final Color color;

    /**
     * Instantiates a new Square.
     *
     * @param board the board
     * @param color the color
     * @param xPos  the x pos
     * @param yPos  the y pos
     */
    public Square(Board board, Color color, int xPos, int yPos) {
        this.board = board;
        this.color = color;
        this.xPos = xPos;
        this.yPos = yPos;
        this.occupyingPiece = null;
    }

    /**
     * Gets occupying piece.
     *
     * @return the occupying piece
     */
    public Piece getOccupyingPiece() {
        return occupyingPiece;
    }

    /**
     * Is occupied boolean.
     *
     * @return the boolean
     */
    public boolean isOccupied() {
        return (this.occupyingPiece != null);
    }

    /**
     * Put piece.
     *
     * @param p the p
     */
    public void putPiece(Piece p) {
        this.occupyingPiece = p;
        p.setPosition(this);
    }

    /**
     * Remove piece.
     */
    public void removePiece() {
        this.occupyingPiece = null;
    }

    /**
     * Capture.
     *
     * @param capPiece the cap piece
     */
    public void capture(Piece capPiece) {
        this.board.getPieces().remove(getOccupyingPiece());
        this.occupyingPiece = capPiece;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if (occupyingPiece != null) {
            occupyingPiece.draw(g);
        }
    }

    /**
     * Gets x pos.
     *
     * @return the x pos
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * Gets y pos.
     *
     * @return the y pos
     */
    public int getYPos() {
        return yPos;
    }
}
