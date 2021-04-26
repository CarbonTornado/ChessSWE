package view;


import board.Board;
import utils.Timer;

import javax.swing.*;
import java.awt.*;

public class GUI implements Runnable{
    public Timer blackTimer;
    public Timer whiteTimer;
    private JFrame gui;
    private Timer timer;

    private Board board;

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

        gui.add(board, BorderLayout.CENTER);

        gui.pack();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}