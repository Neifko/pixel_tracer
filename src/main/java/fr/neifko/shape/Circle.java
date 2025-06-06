package fr.neifko.shape;

public class Circle extends Shape{
    public Point center;
    public int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [center=" + center + ", radius=" + radius + "]";
    }
}
