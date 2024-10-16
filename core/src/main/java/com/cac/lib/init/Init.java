package com.cac.lib.init;

import com.badlogic.gdx.Gdx;
import com.cac.Set;
import com.cac.Temp;

public class Init {
    private static int deviceWidth = Temp.Window.deviceWidth;
    private static int deviceHeight = Temp.Window.deviceHeight;
    private static int blockUnit = Set.Game.Screen.blockUnit;

    public Init() {}

    public static void init() {
        Temp.Window.deviceWidth = Gdx.graphics.getWidth();
        Temp.Window.deviceHeight = Gdx.graphics.getHeight();
        Temp.Game.Level.startLevel = 1;
        Temp.State.initialScreen = true;
    }
}
