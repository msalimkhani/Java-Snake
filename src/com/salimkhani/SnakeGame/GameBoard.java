package com.salimkhani.SnakeGame;

import com.salimkhani.SnakeGame.Models.*;
import com.salimkhani.SnakeGame.Properties.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameBoard extends JPanel implements ActionListener ,KeyListener {
    private final Property<Integer> boardWidth;
    private final Property<Integer> boardHeight;
    Snake snake;
    Food food;
    Random rnd;
    int tileSize = 25;
    Timer gameLoop;
    Food drawFood()
    {
       return new Food(new Position(rnd.nextInt(boardWidth.get_type()/tileSize)*tileSize,rnd.nextInt(boardHeight.get_type()/tileSize)*tileSize),new Dimension(tileSize,tileSize),Color.RED);
    }
    GameBoard(int boardW, int boardH)
    {
        boardWidth = new Property<>(boardW);
        boardHeight = new Property<>(boardH);
        rnd = new Random();
        setPreferredSize(new Dimension(boardWidth.get_type(),boardHeight.get_type()));
        setBackground(Color.black);
        snake = new Snake();
        food = drawFood();
        gameLoop = new Timer(100,this);
        gameLoop.start();
        addKeyListener(this);
        setFocusable(true);
    }
    void drawGrid(Graphics g)
    {
        for (int i = 0; i < boardWidth.get_type();i++)
        {
            g.drawLine(i*tileSize,0,i*tileSize,boardHeight.get_type());
            g.drawLine(0,i*tileSize,boardWidth.get_type(),i*tileSize);
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawGrid(g);
        snake.DrawHead(g);
        snake.DrawBody(g);
        food.Draw(g);
        //snake.MoveBody();
    }
    DirectionType moveHead(@org.jetbrains.annotations.NotNull KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                return DirectionType.UP;
            case KeyEvent.VK_DOWN:
                return DirectionType.DOWN;
            case KeyEvent.VK_LEFT:
                return DirectionType.LEFT;
            case KeyEvent.VK_RIGHT:
                return DirectionType.RIGHT;
            default:
                return DirectionType.NONE;
        }
    }

    void move(KeyEvent e)
    {

        DirectionType dir = moveHead(e);
        snake.MoveHead(dir);
        snake.MoveBody(dir);
        if(snake.Hit(snake.Head,food))
        {
            snake.Grow(food);
            food = drawFood();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        move(e);
    }
    //section noNeeded
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    //end-section
}
