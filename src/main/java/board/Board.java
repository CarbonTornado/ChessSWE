package board;

import pieces.King;
import pieces.Piece;
import pieces.PieceColor;
import utils.ImageLoader;
import view.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board extends JPanel implements MouseListener {
    private final List<Piece> pieces;
    private final GUI gui;
    private final Square[][] board;
    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final PieceColor turn;
    private int currX;
    private int currY;
    private Piece currPiece;

    public Board(GUI gui) {
        this.gui = gui;
        this.pieces = new ArrayList<>();
        this.board = new Square[8][8];
        this.setLayout(new GridLayout(8, 8, 0, 0));
        this.addMouseListener(this);

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                int xMod = x % 2;
                int yMod = y % 2;

                if ((xMod == 0 && yMod == 0) || (xMod == 1 && yMod == 1)) {
                    board[x][y] = new Square(this, Color.WHITE, x, y);
                } else {
                    board[x][y] = new Square(this, Color.BLACK, x, y);
                }
                this.add(board[x][y]);
            }
        }

        logger.setLevel(Level.ALL);
        initializePieces();
        this.setSize(new Dimension(400, 400));
        turn = PieceColor.WHITE;
    }

    @Override
    public void paintComponent(Graphics g) {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Square sq = board[y][x];
                sq.paintComponent(g);
            }
        }

        if (currPiece != null) {
            if ((currPiece.getColor() == PieceColor.BLACK && turn.equals(PieceColor.WHITE))
                    || (currPiece.getColor() == PieceColor.WHITE && turn.equals(PieceColor.BLACK))) {
                final Image i = currPiece.getImage();
                g.drawImage(i, currX, currY, null);
            }
        }
    }

    /*
    The rooks are placed on the outside corners, right and left edge.
    The knights are placed immediately inside of the rooks.
    The bishops are placed immediately inside of the knights.
    The queen is placed on the central square of the same color of that of the player: white queen on the white square and black queen on the black square.
    The king takes the vacant spot next to the queen.
    The pawns are placed one square in front of all of the other pieces.
     */
    private void initializePieces() {
        logger.info("Loading Kings...");
        board[0][4].putPiece(new King(PieceColor.BLACK, ImageLoader.loadImage(System.getProperty("user.dir") + "/src/main/resources/Chess_kdt60.png"), board[0][4]));
        board[7][4].putPiece(new King(PieceColor.WHITE, ImageLoader.loadImage(System.getProperty("user.dir") + "/src/main/resources/Chess_klt60.png"), board[7][4]));

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                pieces.add(board[y][x].getOccupyingPiece());
            }
        }
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Square[][] getSquares() {
        return this.board;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //unused
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //unused
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //unused
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //unused
    }
}
