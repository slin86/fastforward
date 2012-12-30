package de.fastforward.game.commons.environment;

import java.io.File;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import de.fastforward.game.commons.Commons;

public abstract class XmlPersistentPool<T> {
    private final File        file;
    private final JAXBContext context;

    public XmlPersistentPool() throws JAXBException {
        ListWrapper<T> list = new ListWrapper<T>();
        context = JAXBContext.newInstance(list.getClass());

        String filename = this.getClass().getSimpleName() + Commons.CONF_FILE_FORMAT;
        String filepath = this.getClass().getResource(filename).getPath();

        file = new File(filepath);
    }

    @SuppressWarnings("unchecked")
    protected Collection<T> load() throws JAXBException {
        // parse the XML and return an instance of the AppConfig class
        ListWrapper<T> wrapper = (ListWrapper<T>) context.createUnmarshaller().unmarshal(file);
        return wrapper.entries;
    }

    protected void save() throws JAXBException {
        Collection<T> tosave = getAll();

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ListWrapper<T> wrapper = new ListWrapper<T>();
        wrapper.entries.addAll(tosave);

        marshaller.marshal(wrapper, file);
    }

    public abstract Collection<T> getAll();
}
