/*
 * Main.java
 * Development time: 2 minutes
 * version 0.1
 */

import javax.swing.*;

/**
 * Driver class for chess program
 * @author JGrindal
 */public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("My chessboard");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}