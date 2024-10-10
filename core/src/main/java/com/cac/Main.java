package com.cac;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.cac.lib.Event;
import com.cac.lib.init.DrawLevel;

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
        Event.print(Temp.Window.deviceWidth, Temp.Window.deviceHeight);
        
        batch = new SpriteBatch();
        image = DrawLevel.draw();
        font = new BitmapFont();
        font2 = new BitmapFont();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
