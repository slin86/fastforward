package de.fastforward.game.environment.attribute.data;

/**
 * Aufzählungstyp für die Wikrungsbereiche.
 * 
 * @author Nils Holthues
 */
public enum ScopeType {

    // Spieler (z.B. Schiff oder Charakter)
    PLAYER,

    // Planet oder Stadt
    PLANET,

    // Sternensystem oder Land
    SYSTEM,

    // Die gesamte Nation, also alles was dem Spieler gehört
    NATION,

    // Das Team, in dem der Spieler ist
    TEAM,

    //

    ;

    /**
     * Wandelt die Zeichenkette str in einen Aufzählungswert um.
     * 
     * @param str
     *            Zeichenkette, die in einen Aufzählungswert umgewandelt wird.
     * 
     * @return Aufzählungswert, welcher der Zeichenkette str entspricht.
     */
    public static ScopeType fromString(String str) {
        ScopeType res = ScopeType.valueOf(str.toUpperCase());

        return res;
    }
}
