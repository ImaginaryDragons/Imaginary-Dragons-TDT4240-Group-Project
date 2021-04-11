package com.dragons.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dragons.game.DragonsGame;

import java.io.IOException;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		try {
			new LwjglApplication(new DragonsGame(new DesktopFirebaseInterface()), config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
