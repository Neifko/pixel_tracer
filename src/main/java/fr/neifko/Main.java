package fr.neifko;

import fr.neifko.area.Area;
import fr.neifko.command.Command;
import fr.neifko.layer.Layer;
import fr.neifko.render.Render;
import fr.neifko.shape.Shape;

import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {

        Command cmd = new Command();

        App app = new App();

        // clear_screen
        Render.clearScreen();
        // draw_all_layer
        Render.drawAllLayers(app.currentArea);
        // draw area
        Render.drawArea(app.currentArea);

        while(true) {
            int err = cmd.read_exec_command(app);
            if (err == 0 || err == 6){
                // clear_screen
                Render.clearScreen();
                // draw_all_layer
                Render.drawAllLayers(app.currentArea);
                // draw area
                Render.drawArea(app.currentArea);
            }
            if (err == 4){
                break;
            }
            if (err == 5){
                // clear_screen
                Render.clearScreen();
            }
            if (err == 7 || err == 8){
                continue;
            }
        }


    }
}