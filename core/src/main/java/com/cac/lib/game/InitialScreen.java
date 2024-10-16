package com.cac.lib.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cac.Main;
import com.cac.Temp;

public class InitialScreen {
    public static void init() {

    }

    public static void update() {
        if (Temp.State.initialScreen) {
            Temp.State.initialScreen = false;

            showInitialScreen();
        }
    }

    private static void showInitialScreen() {
        SpriteBatch b = Main.getBatch();
        
    }
}
