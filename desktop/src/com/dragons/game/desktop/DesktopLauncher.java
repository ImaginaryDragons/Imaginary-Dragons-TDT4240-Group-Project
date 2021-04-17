package com.dragons.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dragons.game.DragonsGame;
import static com.dragons.game.utilities.Constants.FPS;
import java.io.IOException;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		// TODO: Change fps to variable
		config.backgroundFPS = FPS;
		config.foregroundFPS = FPS;

		try {
			new LwjglApplication(new DragonsGame(new DesktopFirebaseInterface()), config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
