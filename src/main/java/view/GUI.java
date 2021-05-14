package view;


import board.Board;
import utils.Timer;

import javax.swing.*;
import java.awt.*;

/**
 * The type Gui.
 */
public class GUI implements Runnable{
    /**
     * The Black timer.
     */
    public Timer blackTimer;
    /**
     * The White timer.
     */
    public Timer whiteTimer;
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
        blackTimer = new Timer(hh, ss, mm);
        whiteTimer = new Timer(hh, ss, mm);
    }

    @Override
    public void run() {
        gui = new JFrame("Chess");
        gui.setResizable(false);
        gui.setSize(1600, 800);

        this.board = new Board(this);
        JPanel timerPanel = new JPanel(new BorderLayout());
        timerPanel.add(new JLabel(blackTimer.toString()),BorderLayout.NORTH);
        timerPanel.add(new JLabel(whiteTimer.toString()),BorderLayout.SOUTH);

        gui.add(board, BorderLayout.CENTER);
        gui.add(timerPanel,BorderLayout.EAST);

        // gui.pack();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}