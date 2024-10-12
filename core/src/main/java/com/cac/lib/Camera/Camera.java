package com.cac.lib.Camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.cac.Set;
import com.cac.Temp;

public class Camera {
    private static OrthographicCamera camera;

    /**
     * Init the camera
     */
    public static void init() {
        // 創建正交相機
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set((Temp.Window.deviceWidth / 2), (Temp.Window.deviceHeight / 2), 0);
        camera.update();
    }
    
    /**
     * Transfer the camera
     * 
     * @param posX :the value to transfer X coordinate.
     * @param posY :the value to transfer Y coordinate.
     * @param posZ :the value to transfer Z coordinate.
     * @see Temp.Camera.Position
     * 
     * @return {@code void}
     */
    public static void translate(float posX, float posY, float posZ) {
        Temp.Camera.Position.X += posX; Temp.Camera.Position.Y += posX; Temp.Camera.Position.Z += posZ;
        camera.position.set(Temp.Camera.Position.X, Temp.Camera.Position.Y, Temp.Camera.Position.Z);
        camera.update();
    }

    /**
     * Return camera
     * @return camera
     */
    public static OrthographicCamera getCamera() {
        return camera;
    }
}
