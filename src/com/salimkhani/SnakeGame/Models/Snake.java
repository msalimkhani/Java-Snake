package com.salimkhani.SnakeGame.Models;

import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;

/**
 * The Snake CLass.
 */
public class Snake {
    public SnakeHead Head;
    public LinkedList<Tile> Body;
    int tileSize = 25;
    public Snake()
    {
        Head = new SnakeHead(new Position(5*tileSize,5*tileSize),new Dimension(tileSize,tileSize),Color.green);
        Body = new LinkedList<>();
    }
    /**
     * Draws Head Of Snake On the Screen.
     * See the class description for {@link Snake} for a definition of
     * a DrawHead Method.
     * @param g the Graphics abstract for Drawing
     */
    public void DrawHead(Graphics g)
    {
        Head.Draw(g);
    }
    /**
     * Checks if the two tile are Hit together.
     * See the class description for {@link Snake} for a definition of
     * a Hit Method.
     * See the class {@link Tile} for a definition of a Tile.
     * @param tile1 the first Tile.
     * @param tile2 the second Tile.
     */
    public boolean Hit(Tile tile1, Tile tile2)
    {
        return Objects.equals(tile1.position.X.get_type(), tile2.position.X.get_type()) && Objects.equals(tile1.position.Y.get_type(), tile2.position.Y.get_type());
    }
    public void Grow(Food food)
    {
        Body.add(new Tile(new Position(food.position.X.get_type(),food.position.Y.get_type()),new Dimension(tileSize, tileSize),Color.green));
    }
    public void DrawBody(Graphics g)
    {
        for (var tile : Body)
        {
            tile.Draw(g);
            //System.out.println(tile.position.X.get_type() + ", " + tile.position.Y.get_type());
        }

    }
    public void MoveBody(DirectionType dir)
    {
        for (Tile snakePart : Body) {
            Direction.parseDirection(dir, snakePart.position, tileSize);
        }
    }

    public void MoveHead(DirectionType dir)
    {
        Direction.parseDirection(dir, Head.position, tileSize);
    }
}
