package fr.neifko.shape;

public class Squar extends Shape{
    protected Point p1;
    protected int length;

    public Squar(Point p1, int length){
        this.p1 = p1;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Squar [p1=" + p1 + ", length=" + length + "]";
    }
}
