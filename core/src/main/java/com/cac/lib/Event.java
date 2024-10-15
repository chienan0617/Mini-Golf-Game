package com.cac.lib;

import java.util.Arrays;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.cac.Temp;
import com.cac.Set;


public class Event {
    public Error err = new Error();

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

    public static void warm(Object... message){
        try {
            System.err.print("[WARM]: ");
            for (Object messages : message) {
                System.err.print(messages + " ");
            }
            System.err.println();
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
    }
    
    public static void print(Object ask) {
        try {
            System.out.println(ask);
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
    }

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

    public static void error(int errorCode) {
        try {
            System.out.println("[Error: "+ errorCode + "]");
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public static int[] getWindowSize() {
        try {
            return new int[] {Gdx.graphics.getWidth(), Gdx.graphics.getHeight()};
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
        return null;
    }

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

    public static float[] getMousePosition() {
        try {
            return new float[] {Gdx.input.getX(), Gdx.input.getY()};
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
        return null;
    }

    public static float[] getCameraPosition() {
        try {
            return new float[] {Temp.Camera.Position.X, Temp.Camera.Position.Y};
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
        return null;
    }

    public static int[] getTextureRange(Texture tex, int putX, int putY) {
        return new int[] {putX, putX + tex.getWidth(), putY, putY + tex.getHeight()};
    }

    public static boolean isCoordinateInArray(float[] MousePos, int[] rectRange) {
        float relativeMouseX = MousePos[0] - rectRange[0];
        float relativeMouseY = MousePos[1] - rectRange[2];

        return relativeMouseX >= 0 && relativeMouseX <= (rectRange[1] - rectRange[0]) &&
            relativeMouseY >= 0 && relativeMouseY <= (rectRange[3] - rectRange[2]);
    }
    
    public static boolean isTexturePressed(Texture texture) {
        return false;
    }

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

    public static Integer squa(Object num) {
        try {
            if (num instanceof Integer) {
                return (Integer) num * (Integer) num;
            } else if (num instanceof Double) {
                return (int) ((Double) num * (Double) num);
            } else if (num instanceof Float) {
                return (int) ((Float) num * (Float) num);
            } else if (num instanceof Long) {
                return (int) ((Long) num * (Long) num);
            } else {
                throw new IllegalArgumentException("Unsupported number type");
            }
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null); // Assuming Error is a custom class
        }
        return null;
    }
    
    public static int[] range(int start, int end) {
        try {
            int[] output = new int[Math.round(start - end)];
            int times = 0;
            
            for (int i = start; i <= end; i++) {
                times += 1;
                output[times] = i;
            }
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
        return null;
    }

    public static int[] range(int step) {
        try {
            int[] output = new int[step];
            int times = 0;

            for (int i = 0; i <= step; i++) {
                times += 1;
                output[times] = i;
            }
            return output;
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
        return null;
    }

    public static int[] range(int start, int step, int end) {
        try {
            int[] output = new int[Math.round(start - end)];
            int times = 0;
        
            for (int i = start; i <= end; i += end) {
                times += 1;
                output[times] = i;
            }
            return output;
        } catch (Exception error) {
            error.printStackTrace();
            Error.error(null);
        }
        return null;
    }
}

class Error {
    public static void error(String error) {
        System.out.println("[Error] :" + error);
    }
}