package fr.neifko.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Command {

    public static final int MAX_PARAM = 30;
    public String name;

    public List<Integer> intParams;
    public List<Float> floatParams;
    public List<String> stringParams;

    // Messages d'erreur (traduction de command.c)
    public static String[] errorMessages = {
            "",
            "Commande inconnue",
            "Commande manquante",
            "Erreur paramètres, consultez la commande help",
            "exit",
            "clear",
            "plot",
            "~~~ HELP ~~~",
            "done",
            "id inconnu dans la liste",
    };

    public Command() {
        this.name = "";
        this.intParams = new ArrayList<>();
        this.floatParams = new ArrayList<>();
        this.stringParams = new ArrayList<>();
    }

    public void addIntParam(int p) {
        if (intParams.size() < MAX_PARAM)
            intParams.add(p);
    }

    public void addFloatParam(float p) {
        if (floatParams.size() < MAX_PARAM)
            floatParams.add(p);
    }

    public void addStringParam(String p) {
        if (stringParams.size() < MAX_PARAM)
            stringParams.add(p);
    }

    public static Command createCommand() {
        return new Command();
    }

    public static boolean isInt(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWord(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'a' || c > 'z') {
                return false;
            }
        }
        return true;
    }

    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String cleanText(String str) {
        if (str == null) return null;
        // Transformation en minuscules
        str = str.toLowerCase();
        // Supprime le commentaire ou la fin de ligne
        int index = str.indexOf('#');
        if (index != -1) {
            str = str.substring(0, index);
        }
        index = str.indexOf('\n');
        if (index != -1) {
            str = str.substring(0, index);
        }
        return str.trim();
    }

    public static void readFromStdin(Command cmd) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("~> ");
        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            return;
        }
        if (line == null || line.isEmpty()) {
            return; // rien lu
        }
        line = cleanText(line);
        String[] tokens = line.split("\\s+");
        for (String token : tokens) {
            if (cmd.stringParams.size() >= MAX_PARAM
                    || cmd.intParams.size() >= MAX_PARAM
                    || cmd.floatParams.size() >= MAX_PARAM)
                return; // nb max args atteint

            if (isWord(token)) {
                cmd.addStringParam(token);
            } else if (isInt(token)) {
                cmd.addIntParam(Integer.parseInt(token));
            } else if (isFloat(token)) {
                cmd.addFloatParam(Float.parseFloat(token));
            } else {
                // Cas erreur, ajoute deux paramètres de type chaîne
                cmd.addStringParam("error");
                cmd.addStringParam("line");
            }
        }
    }

    public static void debugCmd(Command cmd) {
        System.out.println("\n --- ");
        System.out.println("str:");
        for (String s : cmd.stringParams) {
            System.out.println("<" + s + ">");
        }
        System.out.println("int:");
        for (Integer i : cmd.intParams) {
            System.out.println("<" + i + ">");
        }
        System.out.println("float:");
        for (Float f : cmd.floatParams) {
            System.out.println("<" + f + ">");
        }
    }

    public boolean checkNbParams(int expectedStr, int expectedInt, int expectedFloat) {
        return this.stringParams.size() == expectedStr &&
                this.intParams.size() == expectedInt &&
                this.floatParams.size() == expectedFloat;
    }

    public boolean checkNbParamsPolygon() {
        return this.stringParams.size() == 1 &&
                this.intParams.size() != 0 &&
                this.intParams.size() < MAX_PARAM &&
                this.intParams.size() % 2 == 0 &&
                this.floatParams.size() == 0;
    }
}
