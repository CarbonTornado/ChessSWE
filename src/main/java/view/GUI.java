package view;


import board.Board;
import pieces.PieceColor;
import utils.Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Gui.
 */
public class GUI implements Runnable {
    /**
     * The Black timer.
     */
    public Clock blackClock;
    /**
     * The White timer.
     */
    public Clock whiteClock;
    private JFrame gui;
    private Timer timer;

    private Board board;

    /**
     * Instantiates a new Gui.
     *
     * @param hh the hh
     * @param ss the ss
     * @param mm the mm
     */
    public GUI(int hh, int ss, int mm) {
        blackClock = new Clock(hh, ss, mm);
        whiteClock = new Clock(hh, ss, mm);
    }

    @Override
    public void run() {
        gui = new JFrame("Chess");
        gui.setResizable(false);
        gui.setSize(1600, 800);

        this.board = new Board(this);
        JPanel timerPanel = new JPanel(new BorderLayout());

        JLabel blackTimerLabel = new JLabel(blackClock.toString());
        JLabel whiteTimerLabel = new JLabel(whiteClock.toString());
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
                whiteClock.decrement();
                whiteTimerLabel.setText(whiteClock.toString());
            } else {
                blackClock.decrement();
                blackTimerLabel.setText(blackClock.toString());
            }

        });
        timer.start();
        // gui.pack();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}