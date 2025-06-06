package fr.neifko.shape;

public class Line extends Shape{
    public Point p1;
    public Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Line [p1=" + p1 + ", p2=" + p2 + "]";
    }
}
