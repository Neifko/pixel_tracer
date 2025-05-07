package fr.neifko.layer;



/**
 * Class Layer
 */
public class Layer {

    //
    // Fields
    //

    protected unsigned int id;
    protected char name;
    protected unsigned char visible;
    protected ArrayList shapes;

    //
    // Constructors
    //
    public Layer () { };

    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of id
     * @param newVar the new value of id
     */
    public void setId (unsigned int newVar) {
        id = newVar;
    }

    /**
     * Get the value of id
     * @return the value of id
     */
    public unsigned int getId () {
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
     * Set the value of visible
     * @param newVar the new value of visible
     */
    public void setVisible (unsigned char newVar) {
        visible = newVar;
    }

    /**
     * Get the value of visible
     * @return the value of visible
     */
    public unsigned char getVisible () {
        return visible;
    }

    /**
     * Set the value of shapes
     * @param newVar the new value of shapes
     */
    public void setShapes (ArrayList newVar) {
        shapes = newVar;
    }

    /**
     * Get the value of shapes
     * @return the value of shapes
     */
    public ArrayList getShapes () {
        return shapes;
    }

    //
    // Other methods
    //

    /**
     * @return       LayersList
     */
    private LayersList create_layers_list()
    {
    }


    /**
     * @param        layer_list
     */
    private void delete_layers_list(LayersList layer_list)
    {
    }


    /**
     * @param        layer_list
     * @param        layer
     */
    private void add_layer_to_list(LayersList layer_list, Layer layer)
    {
    }


    /**
     * @param        layer_list
     * @param        layer
     */
    private void remove_layer_from_list(LayersList layer_list, Layer layer)
    {
    }


    /**
     * @param        layer
     */
    private void set_layer_visible(Layer layer)
    {
    }


    /**
     * @param        layer
     */
    private void set_layer_unvisible(Layer layer)
    {
    }


    /**
     * @param        layer
     * @param        shape
     */
    private void add_shape_to_layer(Layer layer, Shape shape)
    {
    }


    /**
     * @param        layer
     * @param        shape
     */
    private void remove_shape_to_from(Layer layer, Shape shape)
    {
    }


}
