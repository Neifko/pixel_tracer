package fr.neifko.area;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une zone (Area).
 */
public class Area {

    /**
     * Identifiant unique de la zone.
     */
    protected int id;

    /**
     * Nom de la zone.
     */
    protected String name;

    /**
     * Largeur de la zone.
     */
    protected int width;

    /**
     * Hauteur de la zone.
     */
    protected int height;

    /**
     * Caractère représentant une case vide.
     */
    protected char emptyChar = '.';

    /**
     * Caractère représentant une case pleine.
     */
    protected char fullChar = '@';

    /**
     * Matrice représentant la zone.
     */
    protected char[][] area;

    /**
     * Liste des couches associées à la zone.
     */
    protected List<Layer> lstLayers;

    /**
     * Constructeur par défaut.
     */
    public Area() {
        this.lstLayers = new ArrayList<>();
    }

    /**
     * Constructeur avec paramètres.
     *
     * @param id       Identifiant de la zone.
     * @param name     Nom de la zone.
     * @param width    Largeur de la zone.
     * @param height   Hauteur de la zone.
     */
    public Area(int id, String name, int width, int height) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.emptyChar = '.';
        this.fullChar = '@';
        this.lstLayers = new ArrayList<>();
        this.area = new char[height][width];

        // Initialisation de la matrice avec le caractère vide
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.area[i][j] = emptyChar;
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
        this.lstLayers = lstLayers;
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