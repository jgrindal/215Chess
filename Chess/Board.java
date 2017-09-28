/*
 * Board.java
 * Development time: 51 minutes
 * version 0.1
 */
package Chess;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Board extends JPanel
{
    public static final int SIZE = 8;
    private ArrayList<Piece> pieces;
    private ArrayList<Piece> whitePieces;
    private ArrayList<Piece> blackPieces;
    private Square[][] board;
    private Square selectedSquare;
    private JPanel boardPanel;
    private boolean turn;
    private boolean check;
    private King whiteKingPiece;
    private King blackKingPiece;

    /**
     * Constructor
     */
    public Board()
    {
        // Initialize Pieces first
        pieces = new ArrayList<>();
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        turn = false;
        check = false;
        board = new Square[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++)
            for (int column = 0; column < SIZE; column++)
                board[row][column] = new Square(row, column, this);

        // Create JPanel
        create();
    }

    /**
     * Creates the Label Panel for all the files
     *
     * @return constructed panel for insertion into layout
     */
    private JPanel createFilePanel()
    {
        JPanel filePanel = new JPanel(new GridLayout(1, 0));
        for (int i = 0; i < SIZE; i++)
        {
            char fileChar = (char) ('A' + i);
            filePanel.add(new JLabel(String.valueOf(fileChar), SwingConstants.CENTER));
        }
        return filePanel;
    }

    /**
     * Creates the Label Panel for all the Ranks
     *
     * @return constructed rank panel for insertion into layout
     */
    private JPanel createRankPanel()
    {
        JPanel rankPanel = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < SIZE; i++)
        {
            int row = SIZE - i;
            rankPanel.add(new JLabel(String.valueOf(row)));
        }
        return rankPanel;
    }

    /**
     * Build GUI elements of board for display
     */
    public void create()
    {
        removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        boardPanel = new JPanel(new GridLayout(SIZE, SIZE));

        setLayout(new GridBagLayout());
        for (int row = 0; row < SIZE; row++)
        {
            for (int column = 0; column < SIZE; column++)
            {
                boardPanel.add(board[row][column]);
            }
        }
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 0, 10);
        add(createRankPanel(), gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(createRankPanel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5, 0, 5, 0);
        add(createFilePanel(), gbc);

        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        add(createFilePanel(), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 5, 5);
        JButton newGame = new JButton("New Game");
        newGame.addActionListener((ActionEvent e) -> create());

        add(newGame, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(boardPanel, gbc);
        add(boardPanel, gbc);
    }
}
