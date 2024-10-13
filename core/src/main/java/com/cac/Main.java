package com.cac;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;
import com.cac.lib.Event;
import com.cac.lib.Ball.Ball;
import com.cac.lib.Camera.Camera;
import com.cac.lib.Control.Control;
import com.cac.lib.level.Level;
import com.cac.Set;
import com.cac.Temp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private BitmapFont font;
    private BitmapFont font2;
    private BitmapFont fontBallX;
    private BitmapFont fontBallY;

    @Override
    public void create() {
        new Temp();
        new Set();
        Temp.Window.deviceWidth = Gdx.graphics.getWidth();
        Temp.Window.deviceHeight = Gdx.graphics.getHeight();
        Camera.init();
        Ball.init();
        batch = new SpriteBatch();
        image = Level.draw(1);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/w.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 72; // 設置字體大小為72
        font = generator.generateFont(parameter);
        font2 = generator.generateFont(parameter);
        fontBallX = generator.generateFont(parameter);
        fontBallY = generator.generateFont(parameter);
        generator.dispose(); // 不再需要字體生成器
        font.setColor(1, 1, 1, 1);
        font2.setColor(1, 1, 1, 1);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.setProjectionMatrix(Camera.getCamera().combined);
        batch.draw(image, 0, 0);
        font.draw(batch, String.valueOf(Gdx.input.getX()), 50, 100);
        font2.draw(batch, String.valueOf(Gdx.input.getY()), 250, 100);

        // 四捨五入到小數第二位
        BigDecimal ballXRounded = BigDecimal.valueOf(Ball.ballX).setScale(2, RoundingMode.HALF_UP);
        BigDecimal ballYRounded = BigDecimal.valueOf(Ball.ballY).setScale(2, RoundingMode.HALF_UP);

        fontBallX.draw(batch, ballXRounded.toString(), 50, 200);
        fontBallY.draw(batch, ballYRounded.toString(), 250, 200);

        batch.end();
        update();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        font.dispose();
        font2.dispose();
    }

    public void update() {
        Ball.update(batch);
    }
}
