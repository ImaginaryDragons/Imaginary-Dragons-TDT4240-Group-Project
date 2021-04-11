package com.dragons.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dragons.game.DragonsGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// TODO: Change fps to variable
		config.backgroundFPS = 30;
		config.foregroundFPS = 30;
		new LwjglApplication(new DragonsGame(new DesktopFirebaseInterface()), config);
	}
}
