package board;

import pieces.*;
import utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Board.
 */
public class Board extends JPanel implements MouseListener {
    private final List<Piece> pieces;
    private final Square[][] board;
    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private PieceColor turn;
    private Piece currPiece;
    private int currX;
    private int currY;
    private PieceFactory pieceFactory = new PieceFactory();

    /**
     * Instantiates a new Board.
     */
    public Board() {
        this.pieces = new ArrayList<>();
        this.board = new Square[8][8];
        this.setLayout(new GridLayout(8, 8, 0, 0));
        this.addMouseListener(this);

        // Init Board
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                int xMod = x % 2;
                int yMod = y % 2;

                //shotgun surgery with x and y
                if ((xMod == 0 && yMod == 0) || (xMod == 1 && yMod == 1)) {
                    board[x][y] = new Square(this, Color.WHITE, x, y);
                } else {
                    board[x][y] = new Square(this, Color.GRAY, x, y);
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
                Square sq = board[x][y];
                sq.paintComponent(g);
            }
        }
        if (currPiece != null && (currPiece.getColor() == PieceColor.BLACK && turn.equals(PieceColor.WHITE))
                || (currPiece != null ? currPiece.getColor() : null) == PieceColor.WHITE && turn.equals(PieceColor.BLACK)) {
            final Image i = currPiece.getImage();
            g.drawImage(i, currX, currY, null);
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
        initializeConcretePiece("King",4,1);
        logger.info("Loading Queens...");
        initializeConcretePiece("Queen",3,1);
        logger.info("Loading Knights...");
        initializeConcretePiece("Knight",6,2);
        logger.info("Loading Rooks...");
        initializeConcretePiece("Rook",7,2);
        logger.info("Loading Bishops...");
        initializeConcretePiece("Bishop",5,2);
        logger.info("Loading Pawns...");
        initializePawns();

        //Initialize all Pieces on the board
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                pieces.add(board[x][y].getOccupyingPiece());
                // logger.info(String.format("X:%d Y:%d Piece:%s%n",x,y,board[x][y].getOccupyingPiece()));
            }
        }
    }

    private void initializePawns() {
        for (int i = 0; i < 8; i++) {
            board[i][1].putPiece(pieceFactory.getPiece("Pawn",PieceColor.BLACK, ImageLoader.loadImage(System.getProperty("user.dir") + "/src/main/resources/Chess_pdt60.png"), board[i][1]));
            board[i][6].putPiece(pieceFactory.getPiece("Pawn",PieceColor.WHITE, ImageLoader.loadImage(System.getProperty("user.dir") + "/src/main/resources/Chess_plt60.png"), board[i][6]));
        }
    }

    public void initializeConcretePiece(String pieceName, int xCoords, int amountPerPlayer){
        int index = 0;
        if(pieceName.equalsIgnoreCase("knight")) index++;
        for (int i = 0; i < amountPerPlayer; i++) {
            board[xCoords][7].putPiece(pieceFactory.getPiece(pieceName,PieceColor.WHITE, ImageLoader.loadImage(System.getProperty("user.dir") + "/src/main/resources/Chess_"+pieceName.toLowerCase().charAt(index)+"lt60.png"), board[xCoords][7]));
            board[xCoords][0].putPiece(pieceFactory.getPiece(pieceName,PieceColor.BLACK, ImageLoader.loadImage(System.getProperty("user.dir") + "/src/main/resources/Chess_"+pieceName.toLowerCase().charAt(index)+"dt60.png"), board[xCoords][0]));
            if(i == 1){
                board[Math.abs(7-xCoords)][7].putPiece(pieceFactory.getPiece(pieceName,PieceColor.WHITE, ImageLoader.loadImage(System.getProperty("user.dir") + "/src/main/resources/Chess_"+pieceName.toLowerCase().charAt(index)+"lt60.png"), board[Math.abs(7-xCoords)][7]));
                board[Math.abs(7-xCoords)][0].putPiece(pieceFactory.getPiece(pieceName,PieceColor.BLACK, ImageLoader.loadImage(System.getProperty("user.dir") + "/src/main/resources/Chess_"+pieceName.toLowerCase().charAt(index)+"dt60.png"), board[Math.abs(7-xCoords)][0]));
            }
        }
    }

    /**
     * Gets pieces.
     *
     * @return the pieces
     */
    public List<Piece> getPieces() {
        return pieces;
    }

    /**
     * Get squares square [ ] [ ].
     *
     * @return the square [ ] [ ]
     */
    public Square[][] getSquares() {
        return this.board;
    }

    /**
     * Gets turn.
     *
     * @return the turn
     */
    public PieceColor getTurn() {
        return turn;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        Square sq = (Square) this.getComponentAt(new Point(e.getX(), e.getY()));
        if (sq.isOccupied()) {
            currPiece = sq.getOccupyingPiece();
            if (currPiece.getColor() != turn) {
                return;
            }
        }

        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Square sq = (Square) this.getComponentAt(new Point(e.getX(), e.getY()));
        if (currPiece != null) {
            if (currPiece.getColor() != turn) {
                return;
            }
            if (currPiece.getLegalMoves(this).contains(sq)) {
                currPiece.move(sq);
                this.turn = turn.getName().equals("White")? PieceColor.BLACK:PieceColor.WHITE;
            }

        }

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
