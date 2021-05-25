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
     * Draw the image on the corresponding square.
     *
     * @param g the Graphic
     */
    public void draw(Graphics g) {
        int x = this.currentSquare.getX() + (this.currentSquare.getWidth() - this.image.getWidth(null)) / 2;
        int y = this.currentSquare.getY() + (this.currentSquare.getHeight() - this.image.getHeight(null)) / 2;
        g.drawImage(this.image, x, y, null);
    }

    /**
     * Gets legal moves.
     *
     * @param b the Board
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

    public List<Square> getDiagMoves(Square[][] squares, int x, int y) {
        List<Square> legalMoves = new LinkedList<>();


        //TODO: Check for blockage

        // Check SW->NE
        for (int xOffset = squares.length; xOffset >= -squares.length; xOffset--) {
            for (int yOffset = squares.length; yOffset >= -squares.length; yOffset--) {

            }
        }

        // Check SE -> NW
        return legalMoves;
    }
//Fragile code
    public List<Square> getStraightMoves(Square[][] squares, int x, int y) {
        List<Square> legalMovesX = new LinkedList<>();
        List<Square> legalMovesY = new LinkedList<>();
        for (int xOffset = squares.length; xOffset >= -squares.length; xOffset--) {
            if (x + xOffset >= 0 && x + xOffset < squares.length) {
                if (!squares[x + xOffset][y].isOccupied() ||
                        squares[x + xOffset][y].getOccupyingPiece().getColor()
                                != this.getColor()) {
                    if (legalMovesX.isEmpty()) {
                        legalMovesX.add(squares[x + xOffset][y]);
                    } else if (x + xOffset > 0 && legalMovesX.contains(squares[x + xOffset][x + xOffset + 1]))
                        legalMovesX.add(squares[y][x + xOffset]);
                }
            }
        }

        for (int yOffset = squares.length; yOffset >= -squares.length; yOffset--) {
            if (y + yOffset >= 0 && y + yOffset < squares.length) {
                if (!squares[x][y + yOffset].isOccupied() ||
                        squares[x][y + yOffset].getOccupyingPiece().getColor()
                                != this.getColor()) {
                    //TODO: Add test for bug where 1st move is already illegal
                    if (legalMovesY.isEmpty()) {
                        legalMovesY.add(squares[x][y + yOffset]);
                    } else if (y + yOffset > 0 && legalMovesY.contains(squares[x][y + yOffset + 1]))
                        legalMovesY.add(squares[x][y + yOffset]);
                }
            }
        }

        return Stream.concat(legalMovesX.stream(), legalMovesY.stream())
                .collect(Collectors.toList());
    }
}
