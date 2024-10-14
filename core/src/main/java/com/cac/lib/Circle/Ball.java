package com.cac.lib.Circle;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Rectangle;

import com.cac.Set;
import com.cac.Temp;
import com.cac.lib.Event;
import com.cac.lib.Circle.Collision;

public class Ball {
    private static ShapeRenderer shapeRenderer = new ShapeRenderer();
    public static Texture golfBall = new Texture("image/golf_ball.png");
    public static float ballX = Temp.Game.GolfBall.Position.X;
    public static float ballY = Temp.Game.GolfBall.Position.Y;
    public static float forceX = 0; // 當前X方向力
    public static float forceY = 0; // 當前Y方向力
    private static float tempX = Temp.Mouse.Position.tempX;
    private static float tempY = Temp.Mouse.Position.tempY;
    private static boolean mouseState = Temp.Mouse.State.isPressed;
    private static boolean isForce = Temp.Game.GolfBall.State.isForce;
    private static float initialForceX = 0; // 儲存初始X方向力
    private static float initialForceY = 0; // 儲存初始Y方向力
    private static float pressedMouseX = 0.0f;
    private static float pressedMouseY = 0.0f;
    private static float accumulatePower = 0.0f;

    // 新增碰撞箱
    private static Rectangle boundingBox;

    public static void init() {
        ballX = Temp.Game.GolfBall.Position.setupX = Set.Window.width;
        ballY = Temp.Game.GolfBall.Position.setupY = Set.Game.GolfBall.initPositionY;

        // 初始化碰撞箱
        boundingBox = new Rectangle(ballX, ballY, golfBall.getWidth(), golfBall.getHeight());
    }

    private static void detect() {
        float[] pos = Event.getMousePosition();
        tempX = pos[0];
        tempY = pos[1];

        float adjustedTempY = Math.abs(Temp.Window.deviceHeight - tempY); // 統一Y座標系
        accumulatePower = (float) Math.sqrt(Event.squa(pos[0] - pressedMouseX) + Event.squa(pos[1] - pressedMouseY));

        if (Event.getMouseDown(1)) { // 滑鼠按下時
            if (!mouseState) {
                mouseState = true;
                pressedMouseX = Event.getMousePosition()[0];
                pressedMouseY = Event.getMousePosition()[1];
            }
            drawLine(); // 顯示從球到滑鼠的瞄準線
        } else if (mouseState) { // 滑鼠釋放時
            mouseState = false;
            // float nowMouseX = Event.getMousePosition()[0];
            // float nowMouseY = Event.getMousePosition()[1];
        
            // 計算滑鼠按下和釋放時的位置距離，來作為累積力量
            Event.log("Force:", accumulatePower);

            // 根據拖動的距離計算力道
            float dx = tempX - ballX;
            float dy = adjustedTempY - ballY;
            // float distance = (float) Math.sqrt(dx * dx + dy * dy); // 滑鼠與球的距離
             
            // 設定一個最大拖動距離，對應於最大力道
            // float maxDistance = 300f; // 最大拖動距離
            float force = accumulatePower * Set.Game.GolfBall.shotForceWeighted; // 根據距離決定力道，並限制最大力道
            if (force >= Set.Game.GolfBall.maxShotForce) {
                force = Set.Game.GolfBall.maxShotForce;
            }

            // 計算發射角度
            float angle = (float) Math.atan2(dy, dx);

            // 根據角度與力道計算初始X和Y方向的力
            initialForceX = force * (float) Math.cos(angle);
            initialForceY = force * (float) Math.sin(angle);

            // 記錄初始力
            forceX = initialForceX;
            forceY = initialForceY;

            isForce = true; // 設定球的狀態為有力
        }
    }

    private static void drawLine() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 0, 0, 1); // Red color
        Gdx.gl.glLineWidth(5);
    
        float dx = tempX - ballX;
        float dy = Math.abs(Temp.Window.deviceHeight - tempY) - ballY; // Normalize Y coordinates
    
        // Normalize to direction vector
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        float normX = dx / distance;
        float normY = dy / distance;
    
        // Scale by accumulatePower
        dx = normX * accumulatePower;
        dy = normY * accumulatePower;
    
        shapeRenderer.line(ballX + golfBall.getWidth() / 2, ballY + golfBall.getHeight() / 2, ballX + dx, ballY + dy);
        shapeRenderer.end();
    }
    

    public static void drawBall(SpriteBatch batch) {
        batch.begin();
        batch.draw(golfBall, ballX, ballY);
        batch.end();

        if (isForce) {
            float deltaTime = Gdx.graphics.getDeltaTime();
            // 更新球的位置
            ballX += forceX * deltaTime;
            ballY += forceY * deltaTime;
            // 力的衰減
            forceX *= Set.Game.GolfBall.forcePerNe;
            forceY *= Set.Game.GolfBall.forcePerNe;

            // 更新碰撞箱
            updateBoundingBox();

            if (Math.abs(forceX) < Set.Game.GolfBall.minForceToStop && Math.abs(forceY) < Set.Game.GolfBall.minForceToStop) {
                isForce = false; // 力用完後設置為false
            }
        }
    }

    // 更新碰撞箱位置
    public static void updateBoundingBox() {
        boundingBox.setPosition(ballX, ballY);
    }

    public static void detectPos() {
        // 碰到左邊界
        if (ballX <= 0) {
            ballX = 0; // 防止超出左邊界
            forceX = -forceX; // 反轉X方向速度
        } else if (ballX + boundingBox.width >= Temp.Window.deviceWidth) {
            ballX = Temp.Window.deviceWidth - boundingBox.width; // 防止超出右邊界
            forceX = -forceX; // 反轉X方向速度
        }

        // 碰到下邊界
        if (ballY <= 0) {
            ballY = 0; // 防止超出下邊界
            forceY = -forceY; // 反轉Y方向速度
        } else if (ballY + boundingBox.height >= Temp.Window.deviceHeight) {
            ballY = Temp.Window.deviceHeight - boundingBox.height; // 防止超出上邊界
            forceY = -forceY; // 反轉Y方向速度
        }

        // 更新碰撞箱
        updateBoundingBox();
    }

    public static void update(SpriteBatch batch, ArrayList<int[]> blockRanges) {
        detect();
        detectPos();
        drawBall(batch);

        for (int[] range : blockRanges) {
            Collision.detectCollision(range);
        }
    
        drawBall(batch);
    }
}
