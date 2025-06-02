package fr.neifko.area;

import java.util.ArrayList;
import java.util.List;

import fr.neifko.layer.Layer;


/**
 * Classe représentant une zone (Area).
 */
public class Area {

    int id;
    String name;
    int width;
    int height;
    char emptyChar = '.';
    char fullChar = '#';
    char[][] area;
    ArrayList<Layer> lstLayers;

    /**
     * Constructeur
     */
    public Area(int id, String name, int width, int height) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.lstLayers = new ArrayList<>();
        this.area = new char[height][width];

        // Initialisation de la matrice avec le caractère vide
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.area[i][j] = emptyChar;
            }
        }
    }

    /**
     * Réinitialise la zone en remplissant la matrice avec le caractère vide.
     */
    public void clearArea() {
        if (area != null) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    area[i][j] = emptyChar;
                }
            }
        }
    }

    // Getters et setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public char getEmptyChar() {
        return emptyChar;
    }
    public void setEmptyChar(char emptyChar) {
        this.emptyChar = emptyChar;
    }
    public char getFullChar() {
        return fullChar;
    }
    public void setFullChar(char fullChar) {
        this.fullChar = fullChar;
    }
    public char[][] getArea() {
        return area;
    }
    public void setArea(char[][] area) {
        this.area = area;
    }
    public List<Layer> getLstLayers() {
        return lstLayers;
    }
    public void setLstLayers(List<Layer> lstLayers) {
        this.lstLayers = (ArrayList<Layer>) lstLayers;
    }


    /**
     * Ajoute une couche à la liste des couches.
     *
     * @param layer La couche à ajouter.
     */
    public void addLayer(Layer layer) {
        this.lstLayers.add(layer);
    }

    /**
     * Supprime une couche de la liste des couches.
     *
     * @param layer La couche à supprimer.
     */
    public void removeLayer(Layer layer) {
        this.lstLayers.remove(layer);
    }

    /**
     * Supprime toutes les couches associées à la zone.
     */
    public void deleteAllLayers() {
        this.lstLayers.clear();
    }
}