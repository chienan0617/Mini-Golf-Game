package com.cac.lib;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.cac.Temp;


public class Event {
    public Error err = new Error();

    /**
     * This method prints a message to the console. <p>
     * the same as print()
     * 
     * @param message :the message to be print.
     * @see {@link System.out#println()}.
     */
    public static void print(Object message) {
        try {
            System.out.println(message);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    /**
     * This method print a message to the console. <p>
     * the same as print()
     * 
     * @param message :the message to be print.
     * @param end :the end of the sentence.
     * @see {@link System.out#println()}.
     */
    public static void print(Object message, Object end) {
        try {
            System.out.println(message);
            System.out.println(end);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    /**
     * This method let user input a message and return what they are input.<p>
     * 
     * @param ask :print the message before user input.
     * @return {@code String} : what user input.
     */
    public static String input(String ask) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print(ask);
            String input = scanner.nextLine();
            scanner.close();

            return input;
        } catch (Exception error) {
            error.printStackTrace();

            return null;
        } 
    }

    /*
     * To raise the error code
     * 
     * @param errorCode :the error code
     * @return {@code void}
     */
    public static void error(int errorCode) {
        try {
            System.out.println("[Error: "+ errorCode + "]");
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    /**
     * Detect the keys which is be pressed.
     * 
     * @param keys :which keys need to be detect.
     * @return {@code boolean}: is key pressed?
     */
    public static boolean getPressedDown(String keys) {
        keys.toUpperCase();

        for (char key : keys.toCharArray()) {
            int keyCode = Input.Keys.valueOf(String.valueOf(key).toUpperCase());
            if (Gdx.input.isKeyPressed(keyCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * To get the mouse position.
     * 
     * @return {@code float[]}: {posX, posY}.
     */
    public static float[] getMousePosition() {
        return new float[] {Gdx.input.getX(), Gdx.input.getY()};
    }

    /**
     * To get the camera position.
     * 
     * @see Temp.Position#X
     * @see Temp.Position#Y
     * @return {@code float[]}: {posX, posY}.
     */
    public static float[] getCameraPosition() {
        return new float[] {Temp.Camera.Position.X, Temp.Camera.Position.Y};
    }

    /**
     * To get the {@link Texture}'s range.
     * 
     * @param tex :the {@link Texture}
     * @param putX :the X coordinate of the {@link Texture}
     * @param putY :the Y coordinate of the {@link Texture}
     * 
     * @return {@code int[]} : {LeftBottom, RightBottom, LeftTop, RightTop}
     */
    public static int[] getTextureRange(Texture tex, int putX, int putY) {
        return new int[] {putX, putX + tex.getWidth(), putY, putY + tex.getHeight()};
    }

    /**
     * To detect whether the rectangle range in the array that param in.
     * 
     * @param getMousePos :the same system of {@link Event#getMousePosition()}
     * @param rectRange :the same system of {@link Event#getTextureRange(Texture, int, int)}
     * 
     * @return {@code boolean} : true if in the range.
     */
    public static boolean isCoordinateInArray(float[] MousePos, int[] rectRange) {
        float relativeMouseX = MousePos[0] - rectRange[0];
        float relativeMouseY = MousePos[1] - rectRange[2];

        return relativeMouseX >= 0 && relativeMouseX <= (rectRange[1] - rectRange[0]) &&
            relativeMouseY >= 0 && relativeMouseY <= (rectRange[3] - rectRange[2]);
    }
    
    /**
     * Auto detect whether the mouse position is in texture range.<p>
     * 
     * @param texture :which need to be detect
     * @return {@code true}: if the mouse in the range
     */
    public static boolean isTexturePressed(Texture texture) {
        return true;
    }
}

class Error {
    public static void error(String error) {
        System.out.println("[Error] :" + error);
    }
}