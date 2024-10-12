package com.cac;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.cac.lib.Event;
import com.cac.lib.Camera.Camera;
import com.cac.lib.Control.Control;
import com.cac.lib.Object.Object;
import com.cac.lib.level.Level;

import com.cac.Set;
import com.cac.Temp;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private BitmapFont font;
    private BitmapFont font2;

    @Override
    public void create() {
        new Temp();
        new Set();

        Temp.Window.deviceWidth = Gdx.graphics.getWidth();
        Temp.Window.deviceHeight = Gdx.graphics.getHeight();
        Camera.init();
        
        batch = new SpriteBatch();
        image = Level.draw(1);
        font = new BitmapFont();
        font2 = new BitmapFont();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 0, 0);
        batch.setProjectionMatrix(Camera.getCamera().combined);
        batch.end();

        update();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    public void update() {
        Object.update(batch);
    }
}
