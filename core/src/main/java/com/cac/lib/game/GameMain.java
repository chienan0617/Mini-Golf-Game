package com.cac.lib.game;

import com.cac.Temp;


import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cac.Base;
import com.cac.Main;
import com.cac.Set;
import com.cac.lib.Event;
import com.cac.lib.level.StartLevel;

public class GameMain implements Base {
    public static void init() {

    }

    public static void update() {
        if (Temp.State.runStartLevel) {
            startLevel(Temp.State.runStartLevelLevel);
            Temp.State.runStartLevel = false;
        }
    }

    private static void startLevel(int level) {
        StartLevel.start(level);
    }

    public static void nextLevel() {
        Temp.State.runStartLevelLevel++;
        drawWaitingScreen();
        Event.wait(2000);
        Temp.State.runStartLevel = true;
    }

    private static void drawWaitingScreen() {
        SpriteBatch batch = Main.getBatch();
        float[] S = Set.Game.Screen.waitScreenFormat1;
        Pixmap pixmap = new Pixmap(Temp.Window.deviceWidth, Temp.Window.deviceHeight, Pixmap.Format.RGBA8888);
        
        pixmap.setColor(S[0], S[1], S[2], S[3]);
        pixmap.fill();
        Event.draw(batch, new Texture(pixmap), 0, 0);
        
    }
}
