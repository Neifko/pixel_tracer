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

        void add_area_to_list(Area area) {
            areas.add(area);
        }

        Command command;




        System.out.println("Pixel Tracer App");
        while (true) {
            command.clear_command();
            command.read_from_stdin();
            command.read_exec_command(this, currentArea, currentLayer, currentShape);


    }
}