/*
 * Main.java
 * Development time: 2 minutes
 * version 0.1
 */

import javax.swing.*;

import Chess.*;

/**
 * Driver class for chess program
 *
 * @author JGrindal
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Board board = new Board();
        JFrame frame = new JFrame("SER 215 Chess");
        frame.getContentPane().add(board);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}