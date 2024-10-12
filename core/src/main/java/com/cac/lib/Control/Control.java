package com.cac.lib.Control;

import com.cac.lib.Event;
import com.cac.lib.Camera.Camera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.cac.Set;
import com.cac.Temp;

public class Control {
    private static float speed = Set.Camera.speed;
    private static float deltaTime = Gdx.graphics.getDeltaTime();

    private static void detect() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            Camera.translate(0, speed * deltaTime, 0); // Move up
        } 
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            Camera.translate(0, -speed * deltaTime, 0); // Move down
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            Camera.translate(-speed * deltaTime, 0, 0); // Move left
        } 
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            Camera.translate(speed * deltaTime, 0, 0); // Move right
        }
    }

    private static void test() {
        if (Event.getPressedDown("E")) {
            Event.print(Event.getMousePosition());
        }
    }

    public static void update() {
        detect();
        test();
    }
}
