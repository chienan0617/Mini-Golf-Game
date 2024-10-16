package com.cac.lib;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.cac.lib.camera.Camera;
import com.cac.lib.game.GameMain;
import com.cac.lib.init.Init;
import com.cac.lib.level.Background;
import com.cac.lib.object.Ball;
import com.cac.lib.ui.Font;
import com.cac.lib.object.Hole;

import com.cac.Temp;
import com.cac.Set;

public class All {
    public static void init() {
        Init.init();
        Camera.init();
        Ball.init();
        Background.init();
        Font.init();
        Hole.init();
    }

    public static void update() {
        Ball.update(Temp.Game.Object.objectList);
        Camera.update();
        Font.update();
        Hole.update();
        GameMain.update();
    }
}
