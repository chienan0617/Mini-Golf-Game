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
import com.cac.lib.Start;
import com.cac.lib.camera.Camera;
import com.cac.lib.object.Ball;
import com.cac.lib.object.Hole;
import com.cac.lib.control.Control;
import com.cac.lib.level.Background;
import com.cac.lib.level.StartLevel;
import com.cac.lib.ui.Font;
import com.cac.Set;
import com.cac.Temp;

import java.math.RoundingMode;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;

    @Override
    public void create() {
        new Temp();
        new Set();
        Start.init();

        batch = new SpriteBatch();
        image = StartLevel.start(1);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.setProjectionMatrix(Camera.getCamera().combined);
        batch.draw(image, 0, 0);
        batch.end();
        
        update();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    public void update() {
        Start.update(batch);
    }
}
