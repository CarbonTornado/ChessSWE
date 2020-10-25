package pieces;

import board.Square;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public abstract class Piece {
    private final PieceColor color;
    private final BufferedImage image;
    private Square currentSquare;

    public Piece(PieceColor color, BufferedImage image, Square initSquare) {
        this.color = color;
        this.image = image;
        this.currentSquare = initSquare;
    }

    public BufferedImage getImage() {
        return image;
    }


    public PieceColor getColor() {
        return color;
    }

    public Square getPosition() {
        return this.currentSquare;
    }

    public void setPosition(Square square) {
        this.currentSquare = square;
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, this.currentSquare.getX(), this.currentSquare.getY(), null);
    }

    public abstract List<Square> getLegalMoves();

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
