package de.fastforward.game.environment.attribute;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.fastforward.game.commons.environment.XmlPersistentPool;
import de.fastforward.game.environment.attribute.data.Attribute;

/**
 * Hält alle Spieleigenschaften.
 * 
 * @author Nils Holthues
 */
@Component
@Scope("singleton")
public class AttributePool extends XmlPersistentPool<Attribute> {

    /** Pool aus Spieleigenschaft */
    private final Map<String, Attribute> features;

    public AttributePool() throws JAXBException {
        super();
        features = new HashMap<String, Attribute>();
    }

    @PostConstruct
    public void init() throws JAXBException {
    	System.out.println("Loading Features...");
        Collection<Attribute> features = super.load();

        for (Attribute feature : features) {
            this.addFeature(feature);
        }
    }

    /**
     * Fügt ein Spieleigenschaft dem Pool hinzu.
     * 
     * @param f
     *            das Spieleigenschaft
     */
    public void addFeature(Attribute f) {
        features.put(f.key, f);
    }

    /**
     * Läd eine Spieleigenschaft aus dem Pool.
     * 
     * @param id
     *            Bezeichner eines Feature
     * @return die Spieleigenschaft
     */
    public Attribute getFeature(String key) {
        Attribute f = features.get(key);
        if (f != null)
            return features.get(key);
        return null;
    }

    /**
     * @return alle Features
     */
    @Override
    public Collection<Attribute> getAll() {
        return features.values();
    }

    /**
     * Leer den RessourcenPool
     */
    public void clear() {
        features.clear();
    }

}