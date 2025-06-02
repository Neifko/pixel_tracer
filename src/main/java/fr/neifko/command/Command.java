package fr.neifko.command;

import fr.neifko.Main;
import fr.neifko.area.Area;
import fr.neifko.layer.Layer;
import fr.neifko.shape.Shape;

public class Command {

    public static final int MAX_PARAM = 10;
    public static final int MAX_STR_SIZE = 50;
    public static final int MAX_FLT_SIZE = 50;

    public String name;
    int int_size;
    int[] int_params = new int[MAX_PARAM];
    int str_size;
    String[] str_params = new String[MAX_PARAM];


    public Command() {
        this.clear_command();
    }

    public void clear_command() {
        int_size = 0;
        str_size = 0;
    }

    void print_help() {
        System.out.println("Available commands: exit, help");
        System.out.println("exit - Exit the program");
        System.out.println("help - Show this help message");
        System.out.println("line - Draw a line");
        System.out.println("circle - Draw a circle");
        System.out.println("rectangle - Draw a rectangle");
    }


    public void read_from_stdin() {
        System.out.print(">> ");
        // read a entire string from stdin
        String input = System.console().readLine();
        // split the string into tokens
        String[] tokens = input.split(" ");
        // first token is the name of the command
        name = tokens[0];

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i].matches("-?\\d+")) {
                // if the token is an integer
                int_params[int_size] = Integer.parseInt(tokens[i]);
                int_size++;
            } else {
                // if the token is a string
                str_params[str_size] = tokens[i];
                str_size++;
            }
        }

    }

    public void read_exec_command(App app) {
        if (this.name.equals("exit")) {
            System.out.println("Exiting...");
            System.exit(0);
        }
        if (this.name.equals("help")) {
            System.out.println("Available commands: exit, help");
            return;
        }
        if (this.name.equals("line")) {
            System.out.println("Draw line...");
            return;
        }
        if (this.name.equals("circle")) {
            System.out.println("Draw circle...");
            return;
        }
        if (this.name.equals("rectangle")) {
            System.out.println("Draw rectangle...");
            return;
        }

        if (this.name.equals("new")) {
            if (this.str_params[0].equals("area")) {
                System.out.println("New area...");
                Area newArea = new Area(0,"New Area", 10, 10);
                area = newArea;
            } else if (this.str_params[0].equals("layer")) {
                System.out.println("New layer...");
                Layer newLayer = new Layer(0,"New Layer");
                if (area != null) {
                    area.addLayer(newLayer);
                }
                layer = newLayer;
            } else if (this.str_params[0].equals("shape")) {
                System.out.println("New shape...");
                Shape newShape = new Shape();
                if (layer != null) {
                    layer.addShape(newShape);
                }
                shape = newShape;
            }
            return;
        }
        end:
        System.out.println("Unknown command: " + this.name);

    }
}