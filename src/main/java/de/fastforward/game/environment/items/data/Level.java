package de.fastforward.game.environment.items.data;

public class Level {

    public String key;
    public String title;
    public String description;

    /** Level der Ausbaustufe */
    private int   level;

    /** Anzahl der Slots, die für Erweiterungen zur Verfügung stehen. */
    private int   countSlots;

    /** Anzahl der Slots, die für das nächste Update min. gebraucht werden. */
    private int   countSlotsToUpdate;

}
