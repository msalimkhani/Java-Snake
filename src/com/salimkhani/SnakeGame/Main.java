package com.salimkhani.SnakeGame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GameBoard board = new GameBoard(500, 500);
        frame.add(board);
        frame.pack();
        frame.setVisible(true);
        frame.requestFocus();
    }
}