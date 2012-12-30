package de.fastforward.game.environment.resource;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.fastforward.game.commons.environment.XmlPersistentPool;
import de.fastforward.game.environment.items.data.Item;

/**
 * Hält alle Spieleigenschaften.
 * 
 * @author Nils Holthues
 */
@Component
@Scope("singleton")
public class ItemPool extends XmlPersistentPool<Item> {

    /** Pool aus Spieleigenschaft */
    private final Map<String, Item> items;

    public ItemPool() throws JAXBException {
        super();
        items = new HashMap<String, Item>();
    }

    @PostConstruct
    public void init() throws JAXBException {
        Collection<Item> items = super.load();

        for (Item feature : items) {
            this.addItem(feature);
        }
    }

    /**
     * Fügt ein Spieleigenschaft dem Pool hinzu.
     * 
     * @param f
     *            das Spieleigenschaft
     */
    public void addItem(Item f) {
        items.put(f.key, f);
    }

    /**
     * Läd eine Spieleigenschaft aus dem Pool.
     * 
     * @param id
     *            Bezeichner eines Item
     * @return die Spieleigenschaft
     */
    public Item getItem(String key) {
        Item f = items.get(key);
        if (f != null)
            return items.get(key);
        return null;
    }

    /**
     * @return alle items
     */
    @Override
    public Collection<Item> getAll() {
        return items.values();
    }

    /**
     * Leer den RessourcenPool
     */
    public void clear() {
        items.clear();
    }

}