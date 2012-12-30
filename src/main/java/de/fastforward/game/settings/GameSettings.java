package de.fastforward.game.settings;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.fastforward.game.commons.setting.SettingXmlReader;

@Component
@Scope("singleton")
public class GameSettings extends SettingXmlReader<GameSetting> {

    public int[] getResolution() {
        String[] res = getString(GameSetting.screen_resolution).split("x");
        int[] resolution = new int[2];

        resolution[0] = Integer.parseInt(res[0]);
        resolution[1] = Integer.parseInt(res[1]);

        return resolution;
    }
}
