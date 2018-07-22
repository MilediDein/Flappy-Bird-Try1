package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class background {
    private Texture img;
    private Vector2 pos;

    public background () {
        img = new Texture("фон1.jpg");
        pos = new Vector2(0, 0);
    }
    public void render (SpriteBatch batch){
        batch.draw(img, pos.x, pos.y);
    }
    public void update (){

    }

}
