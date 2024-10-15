package com.cac.lib.level;

import com.badlogic.gdx.graphics.Texture;

import com.cac.lib.level.Background;

import com.cac.Set;
import com.cac.Temp;

public class StartLevel {
    public static Texture start(int level) {
        Texture levelBackground = Background.draw(level);
        Temp.Game.GolfBall.State.run = true;
        Temp.Game.Hole.State.show = true;

        return levelBackground;
    }
}
