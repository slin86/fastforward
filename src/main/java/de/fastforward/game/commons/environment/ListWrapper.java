package de.fastforward.game.commons.environment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import de.fastforward.game.environment.attribute.data.Attribute;

@XmlRootElement(name = "root")
public class ListWrapper<T> {

    @XmlElements({ @XmlElement(name = "feature", type = Attribute.class) })
    public List<T> entries = new ArrayList<T>();

}
