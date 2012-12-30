package de.fastforward.game.environment.costs.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Ressourcenkosten
 * 
 * @author Nils Holthues
 */
public class ResourceCosts {
    private final Map<String, Integer> resourceCost;

    public ResourceCosts() {
        resourceCost = new HashMap<String, Integer>();
    }

    /**
     * Setzt die Ressourcenkosten für einen Typ.
     * 
     * @param type
     *            der Resourcentyp
     * @param costs
     *            die Kosten
     */
    public void setResourceCost(String type, Integer costs) {
        this.resourceCost.put(type, costs);
    }

    /**
     * Gibt die Ressourcenkosten eines Gebäudes zurück
     * 
     * @param type
     *            der Resourcentyp
     * @return die Kosten
     */
    public Integer getCosts(String type) {
        if (this.resourceCost.containsKey(type))
            return this.resourceCost.get(type);
        else
            return 0;
    }
}
