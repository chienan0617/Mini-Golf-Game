package com.cac.lib.level;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.util.Arrays;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.cac.Set;
import com.cac.Temp;
import com.cac.lib.Event;

public class Level {
    private static int deviceWidth = Temp.Window.deviceWidth;
    private static int deviceHeight = Temp.Window.deviceHeight;
    private static int blockUnit = Set.Game.Screen.blockUnit;
    private static Json level_json = new Json();

    public Level() {

    }

    private static Pixmap drawObject(Pixmap background, int level) {
        float[] O = Set.Game.Screen.objectFormat1;
    
        try {
            JsonValue root = level_json.fromJson(null, Gdx.files.internal("level/1.json").reader());
            JsonValue object = root.get("Object");
    
            if (object == null) {
                System.out.println("Failed to load JSON Object");
                return background;
            }
    
            for (JsonValue array : object) {
                for (JsonValue A : array) {
                    int[] coords = A.asIntArray();
                    Temp.Game.Object.objectList.add(coords);

                    Event.log(Arrays.toString(coords));//
                    background.setColor(O[0], O[1], O[2], O[3]);
                    background.fillRectangle(coords[0] * blockUnit, coords[1] * blockUnit, blockUnit, blockUnit);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return background;
    }

    public static Pixmap drawBackground(Pixmap background) {
        for (int posX = 0; posX <= deviceWidth; posX += blockUnit) {
            for (int posY = 0; posY <= deviceHeight; posY += blockUnit) {
                float[] V = (posX + posY) % 2 == 0 ? Set.Game.Screen.backgroundFormat1 : Set.Game.Screen.backgroundFormat2;
                background.setColor(V[0], V[1], V[2], V[3]);
                background.fillRectangle(posX, posY, blockUnit, blockUnit);
            }
        }
        return background;
    }

    public static Texture draw(int level) {
        Pixmap background = new Pixmap(deviceWidth, deviceHeight, Pixmap.Format.RGBA8888);
        background = drawBackground(background);
        background = drawObject(background, level);
        return new Texture(background);
    }
}