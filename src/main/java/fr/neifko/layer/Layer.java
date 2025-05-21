package fr.neifko.layer;
import fr.neifko.shape.Shape;

import java.util.ArrayList;


/**
 * Class Layer
 */
public class Layer {

    //
    // Fields
    //

    protected int id;
    protected char name;
    protected boolean visible;
    protected ArrayList <Shape> shapes;

    //
    // Constructors
    //
    public Layer () {
        this.id = id;
        this.name = name;
        this.visible = visible;
        this.shapes = shapes;
    };


    /**
     * Set the value of id
     * @param newVar the new value of id
     */
    public void setId (int newVar) {
        id = newVar;
    }

    /**
     * Get the value of id
     * @return the value of id
     */
    public int getId () {
        return id;
    }

    /**
     * Set the value of name
     * @param newVar the new value of name
     */
    public void setName (char newVar) {
        name = newVar;
    }

    /**
     * Get the value of name
     * @return the value of name
     */
    public char getName () {
        return name;
    }

    /**
     * Set the value of visible to True
     */
    public void setVisible () {
        visible = true;
    }

    /**
     * Set the value of visible to True
     */
    public void setUnvisible () {
        visible = false;
    }


    /**
     * Get the value of visible
     *
     * @return the value of visible
     */
    public boolean getVisible () {
        return visible;
    }

    /**
     * Set the value of shapes
     * @param newVar the new value of shapes
     */
    public void setShapes (ArrayList <Shape> newVar) {
        shapes = newVar;
    }

    /**
     * Get the value of shapes
     * @return the value of shapes
     */
    public ArrayList <Shape> getShapes () {
        return shapes;
    }

    //
    // Other methods
    //

    /**
     * @param layer
     */
    private void set_layer_visible(Layer layer)
    {
    }


    /**
     * @param layer
     */
    private void set_layer_unvisible(Layer layer)
    {
    }


    /**
     * @param layer
     * @param shape
     */
    private void add_shape_to_layer(Layer layer, Shape shape)
    {
    }


    /**
     * @param layer
     * @param shape
     */
    private void remove_shape_to_from(Layer layer, Shape shape)
    {
    }


}
