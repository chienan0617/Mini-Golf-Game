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
import com.badlogic.gdx.physics.bullet.linearmath.btPoolAllocator;

public class Object {
    private static ShapeRenderer shapeRenderer = new ShapeRenderer();
    private static float tempX = Temp.Mouse.Position.tempX;
    private static float tempY = Temp.Mouse.Position.tempY;
    private static float ballX = Temp.Game.GolfBall.Position.X;
    private static float ballY = Temp.Game.GolfBall.Position.Y;
    private static float ballSetupX = Temp.Game.GolfBall.Position.setupX;
    private static float ballSetupY = Temp.Game.GolfBall.Position.setupY;
    private static boolean mouseState = Temp.Mouse.State.isPressed;
    private static boolean isForce = Temp.Game.GolfBall.State.isForce;
    private static Texture golfBall = new Texture("image/golf_ball.png");
    private static long pressTime = 0;
    private static long releaseTime = 0;

    public static void init() {
        ballX = ballSetupX = Set.Window.width; ballY = ballSetupY = Set.Game.GolfBall.initPositionY;
    }

    private static void detect() {
        float[] pos = Event.getMousePosition();
        tempX = pos[0]; tempY = pos[1];

        if (Event.getMouseDown(1)) {
            if (!mouseState) {
                pressTime = System.currentTimeMillis();
                mouseState = true;
            }
            drawLine();

        } else if (mouseState) {
            releaseTime = System.currentTimeMillis();
            mouseState = false;
            long pressDuration = releaseTime - pressTime;
            // System.out.println(pressDuration + " ms");

            isForce = true;
        }
    }

    private static void drawLine() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 0, 0, 1);
        Gdx.gl.glLineWidth(5);
    
        float dx = tempX - ballX;
        float dy = Math.abs(Temp.Window.deviceHeight - tempY) - ballY;
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
    
        float fixedDistance = 500;
        if (distance > 0) {  // 確保 distance 不為 0
            float ratio = fixedDistance / distance;
            dx *= ratio;
            dy *= ratio;
        }
        
        shapeRenderer.line(ballX + golfBall.getWidth() / 2, ballY + golfBall.getHeight() / 2, ballX + dx, ballY + dy);
        shapeRenderer.end();
    }
    
    

    public static void drawBall(SpriteBatch batch) {
        batch.begin();
        batch.draw(golfBall, ballX, ballY);
        batch.end();

        if (isForce) {
            float force = 5f; // test
            float deltaTime = Gdx.graphics.getDeltaTime();
    
            float ballSlope = (tempY - ballY) / (tempX - ballX);
            Event.print(ballSlope);

            isForce = false;
        }
    }

    public static void update(SpriteBatch batch) {
        detect();
        drawBall(batch);
    }
}

class Function {
    public Function() {}
}