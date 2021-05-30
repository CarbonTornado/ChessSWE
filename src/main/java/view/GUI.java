package view;


import board.Board;
import pieces.PieceColor;
import utils.ChessClock;

import javax.swing.*;
import java.awt.*;

/**
 * The type Gui.
 */
public class GUI implements Runnable {
    /**
     * The Black timer.
     */
    private ChessClock blackChessClock;
    /**
     * The White timer.
     */
    private ChessClock whiteChessClock;
    private JFrame gui;
    private Timer timer;

    private Board board;

    /**
     * Instantiates a new Gui.
     *
     * @param hh the hh
     * @param mm the mm
     * @param ss the ss
     */
    public GUI(int hh, int mm, int ss) {
        blackChessClock = new ChessClock(hh, mm, ss);
        whiteChessClock = new ChessClock(hh, mm, ss);
    }

    @Override
    public void run() {
        gui = new JFrame("Chess");
        gui.setResizable(false);
        gui.setSize(1600, 800);

        this.board = new Board();
        JPanel timerPanel = new JPanel(new BorderLayout());

        JLabel blackTimerLabel = new JLabel(blackChessClock.toString());
        JLabel whiteTimerLabel = new JLabel(whiteChessClock.toString());
        blackTimerLabel.setFont(new Font("Arial", Font.BOLD, 40));
        whiteTimerLabel.setFont(new Font("Arial", Font.BOLD, 40));
        whiteTimerLabel.setForeground(Color.WHITE);
        timerPanel.add(blackTimerLabel, BorderLayout.NORTH);
        timerPanel.add(whiteTimerLabel, BorderLayout.SOUTH);

        gui.add(board, BorderLayout.CENTER);
        gui.add(timerPanel, BorderLayout.EAST);

        timer = new Timer(1000, null);
        timer.addActionListener(e -> {
            PieceColor turn = board.getTurn();

            if (turn.getName().equals("White")) {
                whiteChessClock.decrement();
                whiteTimerLabel.setText(whiteChessClock.toString());
            } else {
                blackChessClock.decrement();
                blackTimerLabel.setText(blackChessClock.toString());
            }

        });
        timer.start();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}