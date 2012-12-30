package de.fastforward.game.environment.costs.data;


/**
 * Aufzählungstyp für Art der Punktkosten
 * 
 * @author Nils Holthues
 */
public enum PopulationUnitCostType {
  /** Unbekannter, unerlaubter Status */
  UNKNOWN,
  
  /** Baupunkt */
  BP,
  
  /** Nahrungseinheit */
  NE,
  
  /** Forschungspunkt */
  FP;
  
  /**
   * Wandelt den Index in einen Aufzählungswert um.
   * 
   * @param index
   *          der Index
   * 
   * @return Aufzählungswert, welcher dem Index entspricht.
   */
  public static PopulationUnitCostType fromIndex(int index) {
    PopulationUnitCostType res = UNKNOWN;

    if (index == 1) {
      res = BP;
    } else if (index == 2) {
      res = NE;
    } else if (index == 3) {
      res = FP;
    } 

    return res;
  }

  /**
   * Wandelt den Index in einen Aufzählungswert um.
   * 
   * @param res
   *          Aufzählungswert
   * 
   * @return Index, welcher dem Aufzählungswert entspricht.
   */
  public static int toIndex(PopulationUnitCostType res) {
    int id = 0;

    if (res == BP) {
      id = 1;
    } else if (res == NE) {
      id = 2;
    } else if (res == FP) {
      id = 3;
    } 

    return id;
  }

  /**
   * Wandelt die Zeichenkette str in einen Aufzählungswert um.
   * 
   * @param str
   *          Zeichenkette, die in einen Aufzählungswert umgewandelt wird.
   * 
   * @return Aufzählungswert, welcher der Zeichenkette str entspricht.
   */
  public static PopulationUnitCostType fromString(String str) {
    PopulationUnitCostType res = UNKNOWN;

    if (str != null) {
      str = str.toUpperCase();
      if (str.equals("BP") || str.equals("Baupunkte")) {
        res = BP;
      } else if (str.equals("NE") || str.equals("Nahrungseinheiten")) {
        res = NE;
      } else if (str.equals("FP") || str.equals("Forschungspunkte")) {
        res = FP;
      } 
    }

    return res;
  }

  /**
   * Wandelt den Aufzählungswert in einen String um.
   * 
   * @param res
   *          Zeichenkette, die in einen Aufzählungswert umgewandelt wird.
   * 
   * @return Aufzählungswert, welcher der Zeichenkette str entspricht.
   */
  public static String toId(PopulationUnitCostType res) {
    String str = "UNKNOWN";

    if (res == BP) {
      str = "BP";
    } else if (res == NE) {
      str = "NE";
    } else if (res == FP) {
      str = "FP";
    } 

    return str;
  }

  /**
   * Wandelt den Aufzählungswert in einen String um.
   * 
   * @param res
   *          Zeichenkette, die in einen Aufzählungswert umgewandelt wird.
   * 
   * @return Aufzählungswert, welcher der Zeichenkette str entspricht.
   */
  public static String toLabel(PopulationUnitCostType res) {
    String str = "UNKNOWN";

    if (res == BP) {
      str = "Baupunkte";
    } else if (res == NE) {
      str = "Nahrungseinheiten";
    } else if (res == FP) {
      str = "Forschungspunkte";
    } 

    return str;
  }

  /**
   * Wandelt den Aufzählungswert in einen String um.
   * 
   * @return Aufzählungswert, welcher der Zeichenkette str entspricht.
   */
  public String toString() {
    return toLabel(this);
  }

  /**
   * @return Das Label des Types
   */
  public String getLabel() {
    return toLabel(this);
  }

  /**
   * @return Die Index des Types
   */
  public Integer getIndex() {
    return toIndex(this);
  }
  
  /**
   * @return Die Id des Types
   */
  public String getId() {
    return toId(this);
  }
}
