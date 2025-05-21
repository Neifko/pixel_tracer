package fr.neifko.shape;

public class Point extends Shape {
    public int px;
    public int py;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;
    }

    @Override
    public String toString() {
        return "Point [px=" + px + ", py=" + py + "]";
    }
}
