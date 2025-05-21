package fr.neifko.shape;

import java.util.Arrays;

public class Polygon extends Shape{
    public Point[] points;

    public Polygon(int numPoints) {
        points = new Point[numPoints];
    }

    @Override
    public String toString() {
        return "Polygon [points=" + Arrays.toString(points) + "]";
    }
}
