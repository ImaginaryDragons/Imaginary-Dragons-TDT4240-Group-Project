package com.dragons.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dragons.game.DragonsGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// TODO: Change fps to variable
		config.backgroundFPS = 2;
		config.foregroundFPS = 2;
		new LwjglApplication(new DragonsGame(new DesktopFirebaseInterface()), config);
	}
}
