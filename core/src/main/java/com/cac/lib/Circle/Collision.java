package com.cac.lib.Circle;

import com.badlogic.gdx.graphics.Texture;

import com.cac.Set;
import com.cac.Temp;

public class Collision {
    private static int blockUnit = Set.Game.Screen.blockUnit;
    private static float ballX = Temp.Game.GolfBall.Position.X;
    private static float ballY = Temp.Game.GolfBall.Position.Y;
    private static float forceX = Ball.ballX;
    private static float forceY = Ball.ballY;
    private static Texture golfBall = Ball.golfBall;

    public static void detectCollision(int[] range) {
        // Get block position
        float blockX = range[0] * blockUnit;
        float blockY = range[1] * blockUnit;

        // Check if ball collides with block
        if (ballX + golfBall.getWidth() > blockX && ballX < blockX + blockUnit &&
            ballY + golfBall.getHeight() > blockY && ballY < blockY + blockUnit) {
            // Collision detected, handle bounce
            if (ballX < blockX || ballX > blockX + blockUnit) {
                forceX = -forceX; // Reverse X direction
            }
            if (ballY < blockY || ballY > blockY + blockUnit) {
                forceY = -forceY; // Reverse Y direction
            }
        }
    }


}
