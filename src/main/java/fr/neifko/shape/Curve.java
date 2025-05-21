package fr.neifko.shape;

public class Curve extends Shape {
    public Point p1;
    public Point p2;
    public Point p3;
    public Point p4;

    public Curve(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    @Override
    public String toString() {
        return "Curve [" + p1 + ", " + p2 + ", " + p3 + ", " + p4 + "]";
    }
}
