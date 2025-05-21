package fr.neifko.pixel;

import fr.neifko.shape.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Pixel
 */
public class Pixel {

    public int px;
    public int py;
    public int color;

    public Pixel (int px, int py, int color) {
        this.px = px;
        this.py = py;
        this.color = color;
    };

    public static Pixel createPixel(int px, int py, int color) {
        return new Pixel(px, py, color);
    }

    public static List<Pixel> createShapeToPixel(Shape shape) {
        if (shape == null) return null;

        List<Pixel> lst = new ArrayList<>();

        if (shape instanceof Point) {
            pixelPoint((Point) shape, shape.color, lst);
        } else if (shape instanceof Line) {
            pixelLine((Line) shape, shape.color, lst);
        } else if (shape instanceof Squar) {
            pixelSquare((Squar) shape, shape.color, lst);
        } else if (shape instanceof Rectangle) {
            pixelRectangle((Rectangle) shape, shape.color, lst);
        } else if (shape instanceof Circle) {
            pixelCircle((Circle) shape, shape.color, lst);
        } else if (shape instanceof Polygon) {
            pixelPolygon((Polygon) shape, shape.color, lst);
        } else if (shape instanceof Curve) {
            pixelCurve((Curve) shape, shape.color, lst);
        }

        return lst;
    }

    private static void pixelPoint(Point pt, int color, List<Pixel> lst) {
        lst.add(createPixel(pt.px, pt.py, color));
    }

    private static void drawSegment(int x, int y, int dx, int dy, int color, List<Pixel> lst) {
        int xinc = (dx > 0) ? 1 : -1;
        int yinc = (dy > 0) ? 1 : -1;
        dx = Math.abs(dx);
        dy = Math.abs(dy);

        lst.add(createPixel(x, y, color));

        if (dx > dy) {
            int cumul = dx / 2;
            for (int i = 1; i <= dx; i++) {
                x += xinc;
                cumul += dy;
                if (cumul >= dx) {
                    cumul -= dx;
                    y += yinc;
                }
                lst.add(createPixel(x, y, color));
            }
        } else {
            int cumul = dy / 2;
            for (int i = 1; i <= dy; i++) {
                y += yinc;
                cumul += dx;
                if (cumul >= dy) {
                    cumul -= dy;
                    x += xinc;
                }
                lst.add(createPixel(x, y, color));
            }
        }
    }

    private static void pixelLine(Line line, int color, List<Pixel> lst) {
        int dx = line.p2.px - line.p1.px;
        int dy = line.p2.py - line.p1.py;
        drawSegment(line.p1.px, line.p1.py, dx, dy, color, lst);
    }

    private static void pixelCircle(Circle circle, int color, List<Pixel> lst) {
        int x = 0;
        int y = circle.radius;
        int d = circle.radius - 1;
        int cx = circle.center.px;
        int cy = circle.center.py;

        while (y >= x) {
            lst.add(createPixel(cx + x, cy + y, color));
            lst.add(createPixel(cx + y, cy + x, color));
            lst.add(createPixel(cx - x, cy + y, color));
            lst.add(createPixel(cx - y, cy + x, color));
            lst.add(createPixel(cx + x, cy - y, color));
            lst.add(createPixel(cx + y, cy - x, color));
            lst.add(createPixel(cx - x, cy - y, color));
            lst.add(createPixel(cx - y, cy - x, color));

            if (d >= 2 * x) {
                d -= 2 * x + 1;
                x++;
            } else if (d < 2 * (circle.radius - y)) {
                d += 2 * y - 1;
                y--;
            } else {
                d += 2 * (y - x - 1);
                y--;
                x++;
            }
        }
    }

    private static void pixelRectangle(Rectangle rect, int color, List<Pixel> lst) {
        drawSegment(rect.p1.px, rect.p1.py, 0, rect.height - 1, color, lst);
        drawSegment(rect.p1.px, rect.p1.py, rect.width - 1, 0, color, lst);
        drawSegment(rect.p1.px + rect.width - 1, rect.p1.py, 0, rect.height - 1, color, lst);
        drawSegment(rect.p1.px, rect.p1.py + rect.height - 1, rect.width - 1, 0, color, lst);
    }

    private static void pixelSquare(Squar square, int color, List<Pixel> lst) {
        int len = square.length;
        int x = square.p1.px;
        int y = square.p1.py;
        drawSegment(x, y, len - 1, 0, color, lst);
        drawSegment(x, y, 0, len - 1, color, lst);
        drawSegment(x + len - 1, y, 0, len - 1, color, lst);
        drawSegment(x, y + len - 1, len - 1, 0, color, lst);
    }

    private static void pixelPolygon(Polygon poly, int color, List<Pixel> lst) {
        for (int i = 1; i < poly.points.length; i++) {
            Point p1 = poly.points[i - 1];
            Point p2 = poly.points[i];
            int dx = p2.px - p1.px;
            int dy = p2.py - p1.py;
            drawSegment(p1.px, p1.py, dx, dy, color, lst);
        }
    }

    private static void pixelCurve(Curve curve, int color, List<Pixel> lst) {
        Point[] pts = new Point[]{curve.p1, curve.p2, curve.p3, curve.p4};
        for (double t = 0; t <= 1.0; t += 0.001) {
            Point p = deCasteljau(pts, t);
            lst.add(createPixel((int) p.px, (int) p.py, color));
        }
    }

    private static Point deCasteljau(Point[] points, double t) {
        int n = points.length;
        Point[] tmp = new Point[n];
        for (int i = 0; i < n; i++) tmp[i] = new Point(points[i].px, points[i].py);

        for (int r = 1; r < n; r++) {
            for (int i = 0; i < n - r; i++) {
                int x = (int) ((1 - t) * tmp[i].px + t * tmp[i + 1].px);
                int y = (int) ((1 - t) * tmp[i].py + t * tmp[i + 1].py);
                tmp[i] = new Point(x, y);
            }
        }
        return tmp[0];
    }
  }
  
