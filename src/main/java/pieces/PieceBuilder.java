package pieces;

import board.Board;
import board.Square;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Piece.
 */
public class PieceBuilder {
    private final PieceColor color;
    private final BufferedImage image;
    private Square initSquare;

    /**
     * Instantiates a new Piece.
     *
     * @param color      the color
     * @param image      the image
     * @param initSquare the init square
     */
    protected PieceBuilder(PieceColor color, BufferedImage image, Square initSquare) {
        this.color = color;
        this.image = image;
        this.initSquare = initSquare;
    }



   /* public Piece build(){
        return new Piece(color,image,initSquare);
    } */
}
