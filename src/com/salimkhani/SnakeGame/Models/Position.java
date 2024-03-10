package com.salimkhani.SnakeGame.Models;

import com.salimkhani.SnakeGame.Properties.Property;

public class Position {
    public Property<Integer> X,Y;
    public Position(int positionX,int positionY)
    {
        this.X = new Property<>(positionX);
        this.Y = new Property<>(positionY);
    }
}
