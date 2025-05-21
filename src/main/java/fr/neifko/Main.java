package fr.neifko;

import fr.neifko.area.Area;
import fr.neifko.command.Command;
import fr.neifko.layer.Layer;
import fr.neifko.shape.Shape;

import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {

        // init app
        ArrayList<Area> areas = new ArrayList<>();
        Area currentArea = new Area(Id.getInstance().getNextId(), "area1", 80, 40);
        areas.add(currentArea);

        ArrayList<Layer> layers = new ArrayList<>();
        Layer currentLayer = new Layer(Id.getInstance().getNextId(), "layer1");
        layers.add(currentLayer);

        Shape currentShape;

        // clear_screen
        // draw_all_layer
        // draw area

        while(true) {
            int err = Command.execCommand();
            if (err == 0 || err == 6){
                // clear_screen
                // draw_all_layer
                // draw area
            }
            if (err == 4){
                break;
            }
            if (err == 5){
                // clear_screen
            }
            if (err == 7 || err == 8){
                continue;
            }
        }


    }
}