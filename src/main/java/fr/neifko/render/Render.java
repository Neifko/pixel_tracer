package fr.neifko.render;

import fr.neifko.area.Area;
import fr.neifko.layer.Layer;
import fr.neifko.pixel.Pixel;
import fr.neifko.shape.Shape;

import java.util.List;

/**
 * Class Render
 */
public class Render{

    //
    // Fields
    //

    char emptyChar = '.';
    char fullChar = '#';
    char blackCell = 'B';
    char redCell = 'R';

    //
    // Constructors
    //
    public Render (char emptyChar, char fullChar, char blackCell, char redCell) {
        this.emptyChar = emptyChar;
        this.fullChar = fullChar;
        this.blackCell = blackCell;
        this.redCell = redCell;
    };

    //
    // Methods
    //

    /**
     * @param area
     */
    private void render_area(Area area){

    }

    /**
     * Affiche la zone actuelle dans la console.
     * @param area La zone à afficher.
     */
    public static void drawArea(Area area) {
        if (area == null) {
            System.out.println("Aucune zone à afficher.");
            return;
        }

        for (int i = 0; i < area.getHeight(); i++) {
            for (int j = 0; j < area.getWidth(); j++) {
                System.out.print(area.getArea()[i][j]);
            }
            System.out.println();
        }
    }


    /**
     * Nettoie la zone en remplissant avec les caractères vides.
     * @param area La zone à nettoyer.
     */
    public static void clearArea(Area area) {
        if (area != null) {
            for (int i = 0; i < area.getHeight(); i++) {
                for (int j = 0; j < area.getWidth(); j++) {
                    area.getArea()[i][j] = area.getEmptyChar();
                }
            }
        }
    }


    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name");
    
            if (os.contains("Windows")) {
                // Windows : utilise la commande "cls"
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Linux/macOS : séquence ANSI d'effacement de l'écran
                System.out.print("\033[H\033[J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du nettoyage de l'écran.");
        }
    }


    /**
     * Dessine tous les layers visibles dans la zone.
     * @param area La zone à dessiner.
     */
    public static void drawAllLayers(Area area) {
        if (area == null) return;

        clearArea(area);

        for (Layer layer : area.getLstLayers()) {
            if (layer.getVisible()) {
                drawLayerShapes(area, layer);
            }
        }
    }

    /**
     * Dessine toutes les formes d’un layer dans la zone.
     * @param area La zone cible.
     * @param layer Le layer à dessiner.
     */
    public static void drawLayerShapes(Area area, Layer layer) {
        if (layer == null || area == null) return;

        for (Shape shape : layer.getShapes()) {
            List<Pixel> pixels = Pixel.createShapeToPixel(shape);

            if (pixels == null) continue;

            for (Pixel pixel : pixels) {
                int x = pixel.px;
                int y = pixel.py;

                if (x >= 0 && x < area.getHeight() && y >= 0 && y < area.getWidth()) {
                    area.getArea()[x][y] = area.getFullChar();
                }
            }
        }
    }
}
