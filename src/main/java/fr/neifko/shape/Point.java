package fr.neifko.shape;

public class Point extends Shape {
    protected int px;
    protected int py;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;
    }

    @Override
    public String toString() {
        return "Point [px=" + px + ", py=" + py + "]";
    }
}
