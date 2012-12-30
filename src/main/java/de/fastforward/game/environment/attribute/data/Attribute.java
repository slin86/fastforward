package de.fastforward.game.environment.attribute.data;

/**
 * Eine Spieleigenschaft.
 * 
 * @author Nils Holthues
 */
public class Attribute {
    /** Key der Spieleigenschaft */
    public String      key;

    /** Anzeigename der Spieleigenschaft */
    public String      label;

    /** Beschreibung der Spieleigenschaft */
    public String      description;

    /** modifizierend oder freischaltend */
    public AttributeType featureType;

    /** Wirkungsbereich */
    public ScopeType   scopeType;

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Attribute)
            return this.key.equals(((Attribute) obj).key);
        else
            return false;
    }

    @Override
    public String toString() {
        return key + "(" + scopeType + ", " + featureType + ")";
    }
}
