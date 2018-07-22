package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    Texture Bird1;
    Texture Bird2;
    Vector2 pos;
    float a;
    float b;
    Rectangle rect;

    public Bird() {
        Bird1 = new Texture("Bird1.png");
        Bird2 = new Texture("Bird2.png");
        pos = new Vector2(150, 230);
        rect = new Rectangle(pos.x,pos.y, 40,30);
        a=0;
        b= -0.3f; //скорость падения
    }

    public void render(SpriteBatch batch) {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
        batch.draw(Bird1, pos.x, pos.y);}
        else {
        batch.draw(Bird2, pos.x, pos.y);}
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            a = 4; } // высата подъема при нажатии клавиши
        a+=b;
        pos.y +=a;

    }
    public void restart() {
        pos = new Vector2(150, 230);
        a=0;

    }
    }



