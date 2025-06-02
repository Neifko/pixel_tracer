package fr.neifko;

import fr.neifko.area.Area;
import fr.neifko.layer.Layer;
import fr.neifko.shape.Shape;

import java.util.ArrayList;

public class App {

    public ArrayList<Area> areas = new ArrayList<>();
    public ArrayList<Layer> layers = new ArrayList<>();
    public Area currentArea;
    public Layer currentLayer;
    public Shape currentShape;

    public App() {
        currentArea = new Area(Id.getInstance().getNextId(), "area1", 80, 40);
        areas.add(currentArea);

        currentLayer = new Layer(Id.getInstance().getNextId(), "layer1");
        layers.add(currentLayer);

        currentShape = null;


    }
}
