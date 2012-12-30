package de.fastforward.game.commons.setting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import de.fastforward.game.commons.Commons;

public class SettingXmlReader<T extends Setting> {
    private Properties   properties;
    protected final File file;

    public SettingXmlReader() {
        file = new File("D:/" + this.getClass().getSimpleName() + Commons.CONF_FILE_FORMAT);

        if (!file.exists()) {
            restoreDefaults();
            store();
        }

        init();

    }

    public void restoreDefaults() {
        Properties defaults = new Properties();
        try {
            defaults.loadFromXML(new FileInputStream(this.getClass()
                    .getResource(this.getClass().getSimpleName() + Commons.CONF_FILE_FORMAT).getPath()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        properties = new Properties(defaults);
    }

    public void init() {
        try {
            properties = new Properties();
            restoreDefaults();
            properties.loadFromXML(new FileInputStream(file));
        } catch (InvalidPropertiesFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void store() {
        try {
            properties.storeToXML(new FileOutputStream(file), "GameSettings", "UTF-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getString(T key) {
        return properties.getProperty(key.getKey());
    }

    public void setString(T key, String value) {
        properties.setProperty(key.getKey(), value);

        store();
    }

    public Integer getInteger(T key) {
        String value = getString(key);

        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setInteger(T key, Integer value) {
        setString(key, value.toString());
    }

    public Double getDouble(T key) {
        String value = getString(key);

        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setDouble(T key, Double value) {
        setString(key, value.toString());
    }

    public Boolean getBoolean(T key) {
        String value = getString(key);

        try {
            return Boolean.parseBoolean(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setBoolean(T key, Boolean value) {
        setString(key, value.toString());
    }

}