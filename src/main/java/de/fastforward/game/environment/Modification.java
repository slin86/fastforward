package de.fastforward.game.environment;

import de.fastforward.game.environment.attribute.data.Attribute;

/**
 * Modifikation einer Spieleigenschaft
 * 
 * @author Nils Holthues
 */
public class Modification {
    public int     summand;
    public float   factor;
    public Attribute feature;

    public Modification() {
        summand = 0;
        factor = 1;
    }
}
