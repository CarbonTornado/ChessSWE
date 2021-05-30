package pieces;

import board.Square;

import java.awt.image.BufferedImage;

public class PieceFactory {
    public Piece getPiece(String pieceType, PieceColor color, BufferedImage image, Square initSquare) {
        if (pieceType.equalsIgnoreCase("BISHOP")) {
            return new Bishop(color, image, initSquare);
        } else if (pieceType.equalsIgnoreCase("KING")) {
            return new King(color, image, initSquare);

        } else if (pieceType.equalsIgnoreCase("KNIGHT")) {
            return new Knight(color, image, initSquare);
        } else if (pieceType.equalsIgnoreCase("PAWN")) {
            return new Pawn(color, image, initSquare);
        } else if (pieceType.equalsIgnoreCase("QUEEN")) {
            return new Queen(color, image, initSquare);
        } else if (pieceType.equalsIgnoreCase("ROOK")) {
            return new Rook(color, image, initSquare);
        }
        return null;
    }
}
