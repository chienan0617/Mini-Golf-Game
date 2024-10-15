package com.cac.lib.object;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cac.Set;
import com.cac.Temp;
import com.cac.lib.Event;

public class Hole {
    private static float ballX = Temp.Game.GolfBall.Position.X;
    private static float ballY = Temp.Game.GolfBall.Position.Y;
    private static float holeX = Temp.Game.Hole.Position.X;
    private static float holeY = Temp.Game.Hole.Position.Y;
    private static Texture hole = new Texture("image/hole.png");

    public static void init() {

    }

    private static void drawHole(SpriteBatch batch) {
        batch.begin();
        batch.draw(hole, holeX, holeY);
        batch.end();
    }

    public static void detectBallIn() {
        if (Math.sqrt(Event.squa(ballX - holeX) + Event.squa(ballY - holeY)) <= Set.Game.Hole.ballInDistance) {
            Ball.ballIn();
        }
    }

    public static void update(SpriteBatch batch) {
        if (Temp.Game.Hole.State.show) {
            drawHole(batch);
        }

        detectBallIn();
    }
}
