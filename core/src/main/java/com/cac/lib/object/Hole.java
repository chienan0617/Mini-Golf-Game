package com.cac.lib.object;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import com.cac.lib.Event;
import com.cac.Temp;
import com.cac.Main;
import com.cac.Set;

public class Hole {
    private static Texture hole = new Texture("image/hole_2.png");
    private static float holeX;
    private static float holeY;

    public static void init() {
        getPosJson();
    }

    private static void getPosJson() {
        FileHandle file = Gdx.files.internal("level/1.json");
        JsonReader jsonReader = new JsonReader();
        JsonValue jsonValue = jsonReader.parse(file);
        JsonValue holePosition = jsonValue.get("Hole");
        holeX = holePosition.getFloat(0);
        holeY = holePosition.getFloat(1);
    }

    private static void drawHole() {
        SpriteBatch batch = Main.getBatch();

        batch.begin();
        batch.draw(hole, holeX, holeY); // 使用 holeX 和 holeY 繪製洞的位置
        batch.end();
    }

    public static void detectBallIn() {
        float distance = (float) Math.sqrt(Event.squa(Temp.Game.GolfBall.Position.X - holeX) + Event.squa(Temp.Game.GolfBall.Position.Y - holeY));
        if (distance <= Set.Game.Hole.ballInDistance) {
            Ball.ballIn();
        }
    }

    public static void updateParam() {
        // 更新參數
    }

    public static void update() {
        if (Temp.Game.Hole.State.show) {
            drawHole();
        }
        detectBallIn();
    }
}

