package com.cac.lib;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.cac.Temp;


public class Event {
    public Error err = new Error();

    /**
     * Log the information to the console.
     * 
     * @param message :the message to log.
     * @return {@code void}
     */
    public static void log(Object... message){
        try {
            System.err.print("[INFO]: ");
            for (Object messages : message) {
                System.err.print(messages + " ");
            }
            System.err.println();
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
    }
    /**
     * Print the content to the console.
     * 
     * @param ask :the content to be print.
     * @return {@code void}
     */
    public static void print(Object ask) {
        try {
            System.out.println(ask);
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
    }

    /**
     * This method prints a message to the console. <p>
     * the same as print()
     * 
     * @param message :the message to be print.
     * @see {@link System.out#println()}.
     */
    public static void print(Object... messages) {
        try {
            for (Object message : messages) {
                System.out.println(message);
            }
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
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
    public static void print(Object end, Object... messages) {
        try {
            for (Object message : messages) {
                System.out.print(message);
                System.out.println(end);
            }
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
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
     * To return the Windows size
     * 
     * @param keys
     * @return
     */
    public static int[] getWindowSize() {
        try {
            return new int[] {Gdx.graphics.getWidth(), Gdx.graphics.getHeight()};
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
        return null;
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
     * To detect the mouse pressed
     * 
     * @return {@code void}
     */
    /**
     * To detect the mouse pressed
     *
     * @param pos the position of the mouse button (1 = left, 2 = middle, 3 = right)
     * @return {@code boolean} true if the specified mouse button is pressed, false otherwise
     */
    public static boolean getMouseDown(int pos) {
        try {
            switch (pos) {
                case 1:
                    return Gdx.input.isButtonPressed(Input.Buttons.LEFT);
                case 2:
                    return Gdx.input.isButtonPressed(Input.Buttons.MIDDLE);
                case 3:
                    return Gdx.input.isButtonPressed(Input.Buttons.RIGHT);
            }
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
        return false;
    }

    /**
     * To get the mouse position.
     * 
     * @return {@code float[]}: {posX, posY}.
     */
    public static float[] getMousePosition() {
        try {
            return new float[] {Gdx.input.getX(), Gdx.input.getY()};
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
        return null;
    }

    /**
     * To get the camera position.
     * 
     * @see Temp.Position.Camera#X
     * @see Temp.Position.Camera#Y
     * @return {@code float[]}: {posX, posY}.
     */
    public static float[] getCameraPosition() {
        try {
            return new float[] {Temp.Camera.Position.X, Temp.Camera.Position.Y};
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
        return null;
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

    /**
     * Return the abs.
     * 
     * @param input :the input that be abs
     * @return :the abs of the input
     */
    public static Object abs(Object input) {
        try {
            if (input instanceof Integer) {
                return Math.abs((Integer) input);
            } else if (input instanceof Double) {
                return Math.abs((Double) input);
            } else if (input instanceof Float) {
                return Math.abs((Float) input);
            } else {
                throw new IllegalArgumentException("Unsupported type");
            }
        } catch (Exception error) {
            Event.print("can't process input: " + error.getMessage());
            return null;
        }
    }

    /**
     * Return the average of two numbers.
     * 
     * @param X :No. 1 number.
     * @param Y :No. 2 number.
     * @return :the average.
     */
    public static Object average(Object X, Object Y) {
        try {
            if (X instanceof Number && Y instanceof Number) {
                double xValue = ((Number) X).doubleValue();
                double yValue = ((Number) Y).doubleValue();
                return (xValue + yValue) / 2;
            } else {
                throw new IllegalArgumentException("Unsupported type: Both parameters must be numbers");
            }
        } catch (Exception error) {
            Event.print("Can't process input: " + error.getMessage());
            return null;
        }
    }
}

class Error {
    public static void error(String error) {
        System.out.println("[Error] :" + error);
    }
}