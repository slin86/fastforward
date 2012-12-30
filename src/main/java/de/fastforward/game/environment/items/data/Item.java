package de.fastforward.game.environment.items.data;

import java.util.HashMap;
import java.util.Map;

public class Item {

    public String                     key;
    public String                     title;
    public String                     description;

    public ItemType                   type;

    private final Map<Integer, Level> levels;

    public Item() {
        levels = new HashMap<Integer, Level>();
    }

}
