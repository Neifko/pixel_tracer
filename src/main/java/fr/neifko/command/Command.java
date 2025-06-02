package fr.neifko.command;

import fr.neifko.App;
import fr.neifko.Main;
import fr.neifko.area.Area;
import fr.neifko.layer.Layer;
import fr.neifko.shape.*;

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

        str_params[0] = name;
        str_size = 1;

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i].matches("-?\\d+")) {
                int_params[int_size] = Integer.parseInt(tokens[i]);
                int_size++;
            } else {
                str_params[str_size] = tokens[i];
                str_size++;
            }
        }

    }

    public int read_exec_command(App app) {
        read_from_stdin();
        int errorNum = 1;

        if (str_size == 0) {
            errorNum = 2;
            System.out.println("Erreur : pas de commande.");
            return errorNum;
        }

        String cmdName = str_params[0];

        if (cmdName.equals("exit")) {
            System.out.println("Exiting...");
            errorNum = 4;
        } else if (cmdName.equals("clear")) {
            errorNum = 5;
        } else if (cmdName.equals("plot")) {
            errorNum = 6;
        } else if (cmdName.equals("help")) {
            print_help();
            System.out.println("Available commands: exit, help");
            errorNum = 7;
        } else if (cmdName.equals("point")) {
            if (int_size < 2) { errorNum = 3; }
            else {
                Point pt = new Point(int_params[0], int_params[1]);
                app.currentShape = pt;
                System.out.println("Point created: " + pt);
                errorNum = 0;
            }
        } else if (cmdName.equals("line")) {
            if (int_size < 4) { errorNum = 3; }
            else {
                Line ln = new Line(new Point(int_params[0], int_params[1]), new Point(int_params[2], int_params[3]));
                app.currentShape = ln;
                errorNum = 0;
            }
        } else if (cmdName.equals("circle")) {
            if (int_size < 3) { errorNum = 3; }
            else {
                Circle sh = new Circle(new Point(int_params[0], int_params[1]), int_params[2]);
                app.currentShape = sh;
                errorNum = 0;
            }
        } else if (cmdName.equals("square")) {
            if (int_size < 3) { errorNum = 3; }
            else {
                Squar sh = new Squar(new Point(int_params[0], int_params[1]), int_params[2]);
                app.currentShape = sh;
                errorNum = 0;
            }
        } else if (cmdName.equals("rectangle")) {
            if (int_size < 4) { errorNum = 3; }
            else {
                Rectangle sh = new Rectangle(new Point(int_params[0], int_params[1]), int_params[2], int_params[3]);
                app.currentShape = sh;
                errorNum = 0;
            }
        } else if (cmdName.equals("polygon")) {
            if (int_size < 6) { errorNum = 3; }
            else {
                System.out.println("TODO");
                errorNum = 0;
            }
        } else if (cmdName.equals("curve")) {
            if (int_size < 8) { errorNum = 3; }
            else {
                Curve sh = new Curve(
                        new Point(int_params[0], int_params[1]),
                        new Point(int_params[2], int_params[3]),
                        new Point(int_params[4], int_params[5]),
                        new Point(int_params[6], int_params[7])
                );
                app.currentShape = sh;
                errorNum = 0;
            }
        } else if (cmdName.equals("list")) {
            if (str_size < 2) { errorNum = 3; }
            else if (str_params[1].equals("areas")) {
                System.out.println("TODO: List areas");
                errorNum = 8;
            } else if (str_params[1].equals("layers")) {
                System.out.println("TODO: List layers");
                errorNum = 8;
            } else if (str_params[1].equals("shapes")) {
                System.out.println("TODO: List shapes");
                errorNum = 8;
            }
        } else if (cmdName.equals("new")) {
            if (str_size < 2) { errorNum = 3; }
            else if (str_params[1].equals("area")) {
                Area area = new Area(80, "area_name", 80, 40);
                Area currentArea = app.currentArea;
                app.currentArea = area;
                Layer layer = new Layer(0, "Layer 1");
                area.addLayer(layer);
                app.currentLayer = layer;
                app.currentShape = null;
                errorNum = 8;
            } else if (str_params[1].equals("layer")) {
                Layer layer = new Layer(0, "layer_name");
                app.currentArea.addLayer(layer);
                app.currentLayer = layer;
                app.currentShape = null;
                errorNum = 8;
            }
        } else if (cmdName.equals("select")) {
            // À compléter selon la logique C, pour area/layer/shape
            errorNum = 8;
        } else if (cmdName.equals("delete")) {
            // À compléter selon la logique C, pour shape
            errorNum = 8;
        } else if (cmdName.equals("set")) {
            // À compléter selon la logique C, pour char/layer
            errorNum = 0;
        } else {
            System.out.println("Commande inconnue : " + cmdName);
        }

        // Affichage du message d'erreur ou de succès
        System.out.println("Code retour : " + errorNum);
        return errorNum;
    }
}