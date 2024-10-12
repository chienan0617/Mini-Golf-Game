package com.cac;

public class Set {
    public static class Window {
        public static final int width = 512;
        public static final int height = 512;
        public static final String title = "Golf Game";
    }

    public static class Game {
        public static class Screen {
            public static final int blockUnit = 75; // pixel            
            public static final float[] backgroundFormat1 = {0.6000f, 0.8980f, 0.3098f, 1.0000f};
            public static final float[] backgroundFormat2 = {0.4235f, 0.7450f, 0.1803f, 1.0000f};
            public static final float[] objectFormat1 = {0.3686f, 0.2313f, 0.1882f, 1.0000f};
        }

        public static class GolfBall {
            public static final int initPositionY = 75;
        }
    }
    
    public static class Camera {
        public static float speed = 400f;
    }
}
