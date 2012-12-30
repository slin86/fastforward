package de.fastforward.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	@Autowired
	Game game;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"de/fastforward/game/config/applicationContext*.xml");
		
		Game game = context.getBean(Game.class);
		game.start();
	}
	
}
