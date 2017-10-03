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
    private boolean cheater;

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
        // Files are labeled A-H
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
        //Ranks need to be loaded starting with the largest (top to bottom from white perspective)
        for (int i = 0; i < SIZE; i++)
        {
            Integer row = SIZE - i;
            rankPanel.add(new JLabel(row.toString()));
        }
        return rankPanel;
    }

    /**
     * Build GUI elements of board for display
     */
    public void create()
    {
        removeAll();
        GridBagConstraints constraints = new GridBagConstraints();
        boardPanel = new JPanel(new GridLayout(SIZE, SIZE));

        setLayout(new GridBagLayout());
        // Add all the Squares as elements
        for (int row = 0; row < SIZE; row++)
            for (int column = 0; column < SIZE; column++)
                boardPanel.add(board[row][column]);
        /*
        Grid Layout:
                   |  FilePanel   |            |  newGame JButton
        -----------+--------------+------------+------------------
        RankPanel  |  boardPanel  |  RankPanel |
        -----------+--------------+------------+
                   |  FilePanel   |            |
         */

        // Left RankPanel
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 10, 0, 10);
        add(createRankPanel(), constraints);

        // Right RankPanel
        constraints.gridx = 2;
        add(createRankPanel(), constraints);

        // Top FilePanel
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 0, 10, 0);
        add(createFilePanel(), constraints);

        // Bottom FilePanel
        constraints.gridy = 2;
        add(createFilePanel(), constraints);

        // New Game Button
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 0, 10, 10);
        JButton newGame = new JButton("New Game");
        newGame.addActionListener((ActionEvent e) -> createStandardPieceSet());

        // Clear Button
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 0, 10, 10);
        JButton clear = new JButton("Clear Board");
        clear.addActionListener((ActionEvent e) -> clearBoard());

        // boardPanel
        add(newGame, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        add(boardPanel, constraints);
        createStandardPieceSet();
    }

    /**
     * Returns the Square at a specified row and column.  Returns null if out of bounds.
     *
     * @param row row to be checked
     * @param col column to be checked
     * @return the Square at row, col
     */
    public Square getSquare(int row, int col)
    {
        Square toRet = null;
        if (row < SIZE && col < SIZE && row >= 0 && col >= 0)
            toRet = board[row][col];
        return toRet;
    }

    /**
     * Clears the board for a new game reset.
     */
    public void clearBoard()
    {
        pieces.clear();
        whitePieces.clear();
        blackPieces.clear();
    }

    /**
     * Generates standard board setup for 8 x 8 game
     */
    public void createStandardPieceSet()
    {
        // Pawns
        for (int i = 0; i < SIZE; i++)
        {
            pieces.add(new Pawn(PieceColor.WHITE));
            board[6][i].setPiece(pieces.get(pieces.size() - 1));
            pieces.add(new Pawn(PieceColor.BLACK));
            board[1][i].setPiece(pieces.get(pieces.size() - 1));
        }
        // Rooks
        for (int i = 0; i < 8; i += 7)
        {
            pieces.add(new Rook(PieceColor.WHITE));
            board[7][i].setPiece(pieces.get(pieces.size() - 1));
            pieces.add(new Rook(PieceColor.BLACK));
            board[0][i].setPiece(pieces.get(pieces.size() - 1));
        }
        // Knights
        for (int i = 1; i < 8; i += 5)
        {
            pieces.add(new Knight(PieceColor.WHITE));
            board[7][i].setPiece(pieces.get(pieces.size() - 1));
            pieces.add(new Knight(PieceColor.BLACK));
            board[0][i].setPiece(pieces.get(pieces.size() - 1));
        }
        // Bishops
        for (int i = 2; i < 8; i += 3)
        {
            pieces.add(new Bishop(PieceColor.WHITE));
            board[7][i].setPiece(pieces.get(pieces.size() - 1));
            pieces.add(new Bishop(PieceColor.BLACK));
            board[0][i].setPiece(pieces.get(pieces.size() - 1));
        }
        //Queens
        pieces.add(new Queen(PieceColor.WHITE));
        board[7][3].setPiece(pieces.get(pieces.size() - 1));
        pieces.add(new Queen(PieceColor.BLACK));
        board[0][3].setPiece(pieces.get(pieces.size() - 1));
        // White King
        pieces.add(new King(PieceColor.WHITE));
        board[7][4].setPiece(pieces.get(pieces.size() - 1));
        whiteKingPiece = (King) pieces.get(pieces.size() - 1);
        // Black King
        pieces.add(new King(PieceColor.BLACK));
        board[0][4].setPiece(pieces.get(pieces.size() - 1));
        blackKingPiece = (King) pieces.get(pieces.size() - 1);

        // TODO: REMOVE TEST PAWN
        pieces.add(new Pawn(PieceColor.BLACK));
        board[5][2].setPiece(pieces.get(pieces.size() - 1));
    }

    /**
     * Returns who's turn it is in the game
     *
     * @return true if white, false if black.
     */
    public boolean getTurn()
    {
        return turn;
    }

    /**
     * Return selected Square
     *
     * @return Selected Square
     */
    public Square getSelected()
    {
        return selectedSquare;
    }

    /**
     * Select a Square for action
     *
     * @param square Square to select
     */
    public void setSelected(Square square)
    {
        selectedSquare = square;
    }

    /**
     * Reset selection to none.
     */
    public void deselect()
    {
        if (selectedSquare != null)
        {
            selectedSquare.deselect();
            for (Square[] squares : board)
            {
                for (Square square : squares)
                {
                    square.setBackground(square.getColor());
                }
            }
        }
    }
}
