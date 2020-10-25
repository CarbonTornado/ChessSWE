package pieces;

import board.Square;

import java.awt.image.BufferedImage;

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
}
