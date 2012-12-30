package de.fastforward.game.settings;

import de.fastforward.game.commons.setting.Setting;

public enum GameSetting implements Setting {
    screen_resolution("1280x720"), screen_fullscreen("false"), game_title("Das Spiel!")

    ;

    private GameSetting(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    private final String defaultValue;

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String getKey() {
        return this.name();
    }
}
