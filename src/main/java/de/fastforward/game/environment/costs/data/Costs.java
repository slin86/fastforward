package de.fastforward.game.environment.costs.data;


/**
 * Eine Abbildung für die Kosten eines Gebäudes. <br />
 * Die Kosten bestehen einmal aus den ResourceCosts, in den die <br />
 * Ressourcenkosten abgebildet sind, sowie den Aufwand in Form von <br />
 * PopulationUnitCostsTyps. (Ressourcen für die Kosten und PopulationCosts<br />
 * für die Dauer eines baues)
 * 
 * @author Nils Holthues
 */
public class Costs {
    /** Baupunkte */
    private int                 bp;

    /** Nahrungseinheiten */
    private int                 ne;

    /** Forschungspunkte */
    private int                 fp;

    /** ResourcenKosten */
    private final ResourceCosts rc;

    public Costs() {
        rc = new ResourceCosts();
        bp = 0;
        ne = 0;
        fp = 0;
    }

    /**
     * @return the bp
     */
    public int getBp() {
        return bp;
    }

    /**
     * @param bp
     *            the bp to set
     */
    public void setBp(int bp) {
        this.bp = bp;
    }

    /**
     * @return the ne
     */
    public int getNe() {
        return ne;
    }

    /**
     * @param ne
     *            the ne to set
     */
    public void setNe(int ne) {
        this.ne = ne;
    }

    /**
     * @return the fp
     */
    public int getFp() {
        return fp;
    }

    /**
     * @param fp
     *            the fp to set
     */
    public void setFp(int fp) {
        this.fp = fp;
    }

    /**
     * @return the rc
     */
    public ResourceCosts getRc() {
        return rc;
    }

    /**
     * Gibt die Punkte zu dem passenden Costtype zurück
     * 
     * @param costType
     *            Typ der Bevölkerungsriege
     * @return die Punkte für den CostType
     */
    public int get(PopulationUnitCostType costType) {
        switch (costType) {
            case BP:
                return this.getBp();
            case NE:
                return this.getNe();
            case FP:
                return this.getFp();

            default:
                return 0;
        }
    }
}
