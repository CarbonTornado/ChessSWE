import view.GUI;

import javax.swing.*;


/**
 * The type Game.
 */
public class Game implements Runnable {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }

    public void run() {
        SwingUtilities.invokeLater(new GUI(0, 10,0));
    }
}
