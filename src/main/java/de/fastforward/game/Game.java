package de.fastforward.game;

import java.awt.Frame;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import de.fastforward.game.environment.EnvironmentService;
import de.fastforward.game.settings.GameSetting;
import de.fastforward.game.settings.GameSettings;

@Component
@Scope("singleton")
public class Game extends JFrame {
	
	@Autowired
	GameSettings gs;
	
	@Autowired
	EnvironmentService es;
	
	public void start() {
		

		es.loadGameElements();
		
		// add(new Board());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		setResizable(false);

		setTitle(gs.getString(GameSetting.game_title));
		if (gs.getBoolean(GameSetting.screen_fullscreen)) {
			setUndecorated(true);
			setExtendedState(Frame.MAXIMIZED_BOTH);
		} else {
			int[] resolution = gs.getResolution();
			setSize(resolution[0], resolution[1]);
		}

		setVisible(true);
	}
}
