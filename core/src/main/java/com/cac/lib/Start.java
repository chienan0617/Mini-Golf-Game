package com.cac.lib;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.cac.lib.camera.Camera;
import com.cac.lib.init.Init;
import com.cac.lib.level.Background;
import com.cac.lib.object.Ball;
import com.cac.lib.ui.Font;
import com.cac.lib.object.Hole;

import com.cac.Temp;
import com.cac.Set;

public class Start {
    public static void init() {
        Init.init();
        Camera.init();
        Ball.init();
        Background.init();
        Font.init();
        Hole.init();
    }

    // public static Texture create() { // test
    //     Texture level = Background.draw(1); //
    //     Temp.Game.GolfBall.State.run = true;
    //     return level;
    // }

    public static void update(SpriteBatch batch) {
        Ball.update(batch, Temp.Game.Object.objectList);
        Font.update(batch);
        Hole.update(batch);
    }
}
