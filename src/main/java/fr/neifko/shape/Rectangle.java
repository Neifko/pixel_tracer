package fr.neifko.shape;

public class Rectangle extends Shape{
    protected Point p1;
    protected int width;
    protected int height;

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
