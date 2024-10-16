package com.cac;

import java.util.ArrayList;
import java.util.HashMap;
public class Temp {
    public static class Device {
        public static String type = "";
    }
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
            public static float X = 0;
            public static float Y = 0;
            public static float Z = 0;
        }

        public static class State {
            public static boolean isPressed = false;
        }
    }

    public static class Game {
        public static class Level {
            public static HashMap<Integer, Integer[][]> levelObject = new HashMap<>();
            public static int now = -1;
            public static int startLevel = -1;
        }

        public static class Object {
            public static ArrayList<int[]> objectList = new ArrayList<>();
            public static int blockQuantityX = 0;
            public static int blockQuantityY = 0;
        }

        public static class GolfBall {
            public static class State {
                public static boolean isForce = false;
                public static boolean run = false;
            }
            public static class Position {
                public static float X = 0;
                public static float Y = 0;

                public static float setupX = 0;
                public static float setupY = 0;

            }
        }

        public static class Hole {
            public static class Position {
                public static float X = 0;
                public static float Y = 0;
            }

            public static class State {
                public static boolean show = false;
            }
        }
    }

    public static class State {
        public static boolean runStartLevel = false;
        public static int runStartLevelLevel = 1;

        public static boolean initialScreen = false;
    }
}
