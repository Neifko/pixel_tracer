package fr.neifko;

public class Id {
    private static Id inst;
    private int id = 0;

    /**
     * Constructeur privé pour le singleton
     *
     * @return
     */
    public static Id getInstance() {
        if (inst == null) {
            inst = new Id();
        }
        return inst;
    }

    /**
     * Renvoie l'id suivant
     * @return
     */
    public int getNextId() {
        return id++;
    }
}
