package fr.neifko.shape;

public abstract class Shape {
    protected int id;
    protected boolean fill;
    protected float thickness;
    protected int color;
    protected double rotation;

    public abstract String toString();

    public int getId(){ return id;}
    public void setId(int id){ this.id = id;}
}
