package de.fastforward.game.environment;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.fastforward.game.environment.attribute.AttributePool;
import de.fastforward.game.environment.items.ItemPool;

@Component
public class EnvironmentService {
	
	@Autowired
	AttributePool featurePool;
	
    public void loadGameElements() {

    }
}
