package com.salimkhani.SnakeGame.Models;

import java.awt.*;

public class Tile {
    public Position position;
    Dimension dimension;
    Color color;
    public Tile(Position position,Dimension dimension,Color color)
    {
        this.position = position;
        this.dimension = dimension;
        this.color = color;
    }
    public void Draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(position.X.get_type(),position.Y.get_type(),dimension.width,dimension.height);
    }
}
