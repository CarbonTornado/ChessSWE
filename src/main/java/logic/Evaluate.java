package logic;

import pieces.Piece;


import java.util.List;

// import static logic.Backend.*;

public class Evaluate {

    /* static double[][] pawnEvalWhite =
            {
                    {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                    {5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0},
                    {1.0, 1.0, 2.0, 3.0, 3.0, 2.0, 1.0, 1.0},
                    {0.5, 0.5, 1.0, 2.5, 2.5, 1.0, 0.5, 0.5},
                    {0.0, 0.0, 0.0, 2.0, 2.0, 0.0, 0.0, 0.0},
                    {0.5, -0.5, -1.0, 0.0, 0.0, -1.0, -0.5, 0.5},
                    {0.5, 1.0, 1.0, -2.0, -2.0, 1.0, 1.0, 0.5},
                    {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
            };

    static double[][] pawnEvalBlack =

            reverseArray(pawnEvalWhite);

    static double[][] knightEval =
            {
                    {-5.0, -4.0, -3.0, -3.0, -3.0, -3.0, -4.0, -5.0},
                    {-4.0, -2.0, 0.0, 0.0, 0.0, 0.0, -2.0, -4.0},
                    {-3.0, 0.0, 1.0, 1.5, 1.5, 1.0, 0.0, -3.0},
                    {-3.0, 0.5, 1.5, 2.0, 2.0, 1.5, 0.5, -3.0},
                    {-3.0, 0.0, 1.5, 2.0, 2.0, 1.5, 0.0, -3.0},
                    {-3.0, 0.5, 1.0, 1.5, 1.5, 1.0, 0.5, -3.0},
                    {-4.0, -2.0, 0.0, 0.5, 0.5, 0.0, -2.0, -4.0},
                    {-5.0, -4.0, -3.0, -3.0, -3.0, -3.0, -4.0, -5.0}
            };

    static double[][] bishopEvalWhite = {
            {-2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0},
            {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -1.0},
            {-1.0, 0.0, 0.5, 1.0, 1.0, 0.5, 0.0, -1.0},
            {-1.0, 0.5, 0.5, 1.0, 1.0, 0.5, 0.5, -1.0},
            {-1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, -1.0},
            {-1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, -1.0},
            {-1.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5, -1.0},
            {-2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0}
    };

    static double[][] bishopEvalBlack =

            reverseArray(bishopEvalWhite);

    static double[][] rookEvalWhite = {
            {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
            {0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5},
            {-0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5},
            {-0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5},
            {-0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5},
            {-0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5},
            {-0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5},
            {0.0, 0.0, 0.0, 0.5, 0.5, 0.0, 0.0, 0.0}
    };

    static double[][] rookEvalBlack =

            reverseArray(rookEvalWhite);

    static double[][] evalQueen =
            {
                    {-2.0, -1.0, -1.0, -0.5, -0.5, -1.0, -1.0, -2.0},
                    {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -1.0},
                    {-1.0, 0.0, 0.5, 0.5, 0.5, 0.5, 0.0, -1.0},
                    {-0.5, 0.0, 0.5, 0.5, 0.5, 0.5, 0.0, -0.5},
                    {0.0, 0.0, 0.5, 0.5, 0.5, 0.5, 0.0, -0.5},
                    {-1.0, 0.5, 0.5, 0.5, 0.5, 0.5, 0.0, -1.0},
                    {-1.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, -1.0},
                    {-2.0, -1.0, -1.0, -0.5, -0.5, -1.0, -1.0, -2.0}
            };

    static double[][] kingEvalWhite = {

            {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
            {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
            {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
            {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
            {-2.0, -3.0, -3.0, -4.0, -4.0, -3.0, -3.0, -2.0},
            {-1.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -1.0},
            {2.0, 2.0, 0.0, 0.0, 0.0, 0.0, 2.0, 2.0},
            {2.0, 3.0, 1.0, 0.0, 0.0, 1.0, 3.0, 2.0}};

    static double[][] kingEvalBlack = reverseArray(kingEvalWhite);

    public static Move generate(int depth) {
        List<Move> moves = validMoves();
        int bestMove = -9999;
        Move bestMoveFound = null;

        for (Move movement : moves) {
            move(movement);
            int value = negamax(depth - 1, -10000, 10000);
            undo();
            if (value >= bestMove) {
                bestMove = value;
                bestMoveFound = movement;
            }
        }
        return bestMoveFound;
    }

    public static int negamax(int depth, int alpha, int beta) {
        if (depth == 0) {
            return -evaluateBoard(board());
        }

        List<Move> moves = validMoves();

        int bestMove = -9999;
        for (Move move : moves) {
            move(move);
            int cur = negamax(depth - 1, -beta, -alpha);
            if (cur > bestMove) {
                bestMove = cur;
            }
            if (bestMove > alpha) {
                alpha = bestMove;
            }

            undo();
            if (alpha >= beta) {
                return bestMove;
            }
        }
        return bestMove;
    }

    public static int evaluateBoard(List<Piece> board) {
        int totalEvaluation = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // totalEvaluation = totalEvaluation + getPieceValue(board[i][j], i, j);
            }
        }
        return totalEvaluation;
    }

    public static double getPieceValue(Piece piece, int x, int y) {
        if (piece == null) {
            return 0;
        }
        double absoluteValue = getAbsoluteValue(piece, piece.getColor().getName().equals("White"), x, y);
        return piece.getColor().getName().equals("White") ? absoluteValue : -absoluteValue;
    }

    public static double getAbsoluteValue(Piece piece, boolean isWhite, int x, int y) {
        switch (piece.getClass().getName()) {
            case "Pawn":
                return (
                        10 + (isWhite ? pawnEvalWhite[y][x] : pawnEvalBlack[y][x])
                );
            case "Rook":
                return (
                        50 + (isWhite ? rookEvalWhite[y][x] : rookEvalBlack[y][x])
                );
            case "Knight":
                return 30 + knightEval[y][x];
            case "Bishop":
                return (
                        30 +
                                (isWhite ? bishopEvalWhite[y][x] : bishopEvalBlack[y][x])
                );
            case "Queen":
                return 90 + evalQueen[y][x];
            case "King":
                return (
                        900 + (isWhite ? kingEvalWhite[y][x] : kingEvalBlack[y][x])
                );
            default:
                throw new IllegalStateException("Unexpected value: " + piece.getClass().getName());
        }
    }


    private static double[][] reverseArray(double array[][]) {
        for (int i = 0; i < array.length / 2; i++) {
            double temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    } */
}
