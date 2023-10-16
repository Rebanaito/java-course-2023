package edu.hw2;

public class Rectangle {
    public Rectangle(int width, int height) {
        this.width = Math.max(width, 0);
        this.height = Math.max(height, 0);
    }

    private final int width;
    private final int height;

    Rectangle setWidth(int width) {
        return new Rectangle(width, this.height);
    }

    Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }

    double area() {
        return width * height;
    }
}
