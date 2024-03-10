package com.salimkhani.SnakeGame.Properties;

/*
// @param <T> The Type Class
*/
public class Property <T>{
    private T _type;
    public Property(T type)
    {
        _type = type;
    }

    public T get_type() {
        return _type;
    }

    public void set_type(T _type) {
        this._type = _type;
    }
}
