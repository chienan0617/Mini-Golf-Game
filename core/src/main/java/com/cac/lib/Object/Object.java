package com.cac.lib.Object;

import com.cac.Set;
import com.cac.Temp;
import com.cac.lib.Event;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Object {
    private static ShapeRenderer shapeRenderer = new ShapeRenderer();
    private static float tempX = Temp.Mouse.Position.tempX;
    private static float tempY = Temp.Mouse.Position.tempY;
    private static float ballX = Temp.Game.GolfBall.Position.X;
    private static float ballY = Temp.Game.GolfBall.Position.Y;
    private static float ballSetupX = Temp.Game.GolfBall.Position.setupX;
    private static float ballSetupY = Temp.Game.GolfBall.Position.setupY;
    private static boolean mouseState = Temp.Mouse.State.isPressed;
    private static Texture golfBall = new Texture("image/golf_ball.png");
    private static long pressTime = 0;
    private static long releaseTime = 0;

    public static void init() {
        ballX = ballSetupX = Gdx.graphics.getWidth(); ballY = ballSetupY = Set.Game.GolfBall.initPositionY;
    }

    private static void detect() {
        if (Event.getMouseDown(1)) {
            if (!mouseState) {
                pressTime = System.currentTimeMillis();
                mouseState = true;
            }
            float[] pos = Event.getMousePosition();
            tempX = pos[0]; tempY = pos[1];
            drawLine();

        } else if (mouseState) {
            releaseTime = System.currentTimeMillis();
            mouseState = false;
            long pressDuration = releaseTime - pressTime;
            System.out.println(pressDuration + " ms");

            goBall();
        }
}


    private static void goBall() {
        float ballSlope = (tempY - ballY) / (tempX - ballX);
        Event.print(ballSlope);
    }

    private static void drawLine() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 0, 0, 1);
        Gdx.gl.glLineWidth(5);
        shapeRenderer.line(tempX, tempY, Event.getWindowSize()[0] / 2, Event.getWindowSize()[1] / 2); // 繪製從 (tempX, tempY) 到 (200, 200) 的線
        shapeRenderer.end();
    }

    public static void drawBall(SpriteBatch batch) {
        batch.begin();
        batch.draw(golfBall, ballX, ballY);
        batch.end();
    }

    public static void update(SpriteBatch batch) {
        detect();
        drawBall(batch);
    }
}

class Function {
    public Function() {}
}