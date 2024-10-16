package com.cac.lib.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.cac.Main;
import com.cac.Temp;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Font {
    private static BitmapFont font;

    public static void init() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/w.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 72;
        font = generator.generateFont(parameter);
        font.setColor(1, 1, 1, 1);
        generator.dispose(); // Don't forget to dispose of the generator
    }

    private static void drawFont() {
        SpriteBatch batch = Main.getBatch();

        BigDecimal ballXRounded = BigDecimal.valueOf(Temp.Game.GolfBall.Position.X).setScale(2, RoundingMode.HALF_UP);
        BigDecimal ballYRounded = BigDecimal.valueOf(Temp.Game.GolfBall.Position.Y).setScale(2, RoundingMode.HALF_UP);

        batch.begin();
        font.draw(batch, Float.toString(Temp.Mouse.Position.X), 50, 100);
        font.draw(batch, Float.toString(Temp.Mouse.Position.Y), 250, 100);
        font.draw(batch, ballXRounded.toString(), 50, 200);
        font.draw(batch, ballYRounded.toString(), 250, 200);
        batch.end();
    }

    public static void update() {
        drawFont();
    }
}
