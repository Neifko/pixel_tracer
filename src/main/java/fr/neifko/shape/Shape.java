package fr.neifko.shape;

public abstract class Shape {
    protected int id;
    public boolean fill;
    public float thickness;
    public int color;
    public double rotation;

    public abstract String toString();

    public int getId(){ return id;}
    public void setId(int id){ this.id = id;}
}
