package board;

import pieces.Piece;

import javax.swing.*;
import java.awt.*;

public class Square extends JComponent {

    private final Board board;
    private final int xPos;
    private final int yPos;
    private Piece occupyingPiece;
    private final Color color;

    public Square(Board board, Color color, int xPos, int yPos) {
        this.board = board;
        this.color = color;
        this.xPos = xPos;
        this.yPos = yPos;
        this.occupyingPiece = null;
    }

    public Piece getOccupyingPiece() {
        return occupyingPiece;
    }

    public boolean isOccupied() {
        return (this.occupyingPiece != null);
    }

    public void putPiece(Piece p) {
        this.occupyingPiece = p;
        p.setPosition(this);
    }

    public void removePiece() {
        this.occupyingPiece = null;
    }

    public void capture(Piece capPiece) {
        this.board.getPieces().remove(getOccupyingPiece());
        this.occupyingPiece = capPiece;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        occupyingPiece.draw(g);
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
