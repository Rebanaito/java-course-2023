package edu.hw2;

public class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }

    @Override
    Square setWidth(int width) {
        return new Square(width);
    }

    @Override
    Square setHeight(int height) {
        return new Square(height);
    }
}
