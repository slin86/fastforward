package de.fastforward.game.environment.attribute.data;

/**
 * Aufzählungstyp für die Spieleigenschaften.
 * 
 * @author Nils Holthues
 */
public enum AttributeType {

    // Modifizierend
    MODIFICATION,

    // Freischaltend
    UNLOCK;

    /**
     * Wandelt die Zeichenkette str in einen Aufz�hlungswert um.
     * 
     * @param str
     *            Zeichenkette, die in einen Aufzählungswert umgewandelt wird.
     * 
     * @return Aufzählungswert, welcher der Zeichenkette str entspricht.
     */
    public static AttributeType fromString(String str) {
        AttributeType res = AttributeType.valueOf(str.toUpperCase());

        return res;
    }

}
