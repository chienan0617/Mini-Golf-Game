package com.cac;

import java.util.ArrayList;
import java.util.HashMap;
public class Temp {
    public static class Window {
        public static int deviceWidth = 0;
        public static int deviceHeight = 0;
    }

    public static class Time {
        public static long tick = 0;
    }

    public static class Camera {
        public static class Position {
            public static float X = 0;
            public static float Y = 0;
            public static float Z = 0;
        }
    }

    public static class Mouse {
        public static class Position {
            public static float tempX = 0;
            public static float tempY = 0;
            public static float tempZ = 0;
        }

        public static class State {
            public static boolean isPressed = false;
        }
    }

    public static class Game {
        public static class Level {
            public static HashMap<Integer, Integer[][]> levelObject = new HashMap<>();
        }

        public static class Object {
            public static ArrayList<int[]> objectList = new ArrayList<>();
        }

        public static class GolfBall {
            public static class State {
                public static boolean isForce = false;
            }
            public static class Position {
                public static float X = 0;
                public static float Y = 0;

                public static float setupX = 0;
                public static float setupY = 0;

            }
        }
    }
}
