package com.salimkhani.SnakeGame.Models;


public class Direction {
    /**
     * Parses The DirectionType And Convert it to the new Position
     * See the class description for {@link Direction} for a definition of
     * parseDirection.
     * @param dir the DirectionType.
     * @param prevPos the previous position of Tile.
     * @param tileSize the size of Tile.
     */
    public static void parseDirection(DirectionType dir,Position prevPos,int tileSize)
    {
        switch (dir)
        {
            case UP:
                prevPos.X.set_type(prevPos.X.get_type());
                prevPos.Y.set_type(prevPos.Y.get_type()-tileSize);
                break;
            case DOWN:
                prevPos.X.set_type(prevPos.X.get_type());
                prevPos.Y.set_type(prevPos.Y.get_type()+tileSize);
                break;
            case LEFT:
                prevPos.X.set_type(prevPos.X.get_type()-tileSize);
                prevPos.Y.set_type(prevPos.Y.get_type());
                break;
            case RIGHT:
                prevPos.X.set_type(prevPos.X.get_type()+tileSize);
                prevPos.Y.set_type(prevPos.Y.get_type());
                break;
            case NONE:
                prevPos.X.set_type(prevPos.X.get_type());
                prevPos.Y.set_type(prevPos.Y.get_type());
                break;
        }
    }
}
