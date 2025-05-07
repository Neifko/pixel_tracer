package fr.neifko.area;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une liste de zones (AreaList).
 */
public class AreaList {

    /**
     * Liste des zones.
     */
    protected List<Area> areas;

    /**
     * Constructeur par défaut.
     */
    public AreaList() {
        this.areas = new ArrayList<>();
    }

    /**
     * Ajoute une zone à la liste.
     *
     * @param area La zone à ajouter.
     */
    public void addArea(Area area) {
        this.areas.add(area);
    }

    /**
     * Supprime une zone de la liste.
     *
     * @param area La zone à supprimer.
     */
    public void removeArea(Area area) {
        this.areas.remove(area);
    }

    /**
     * Supprime toutes les zones de la liste.
     */
    public void deleteAllAreas() {
        this.areas.clear();
    }

    /**
     * Retourne la liste des zones.
     *
     * @return La liste des zones.
     */
    public List<Area> getAreas() {
        return areas;
    }

    /**
     * Définit la liste des zones.
     *
     * @param areas La nouvelle liste des zones.
     */
    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}