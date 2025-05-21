package fr.neifko.shape;

public class Rectangle extends Shape{
    public Point p1;
    public int width;
    public int height;

    public Rectangle(Point p1, int width, int height) {
        this.p1 = p1;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle [p1=" + p1 + ", width=" + width + ", height=" + height + "]";
    }
}
