package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;


public class Pipes {

    Texture pip = new Texture("pipes.png");
    int distance = 150; // между трубами (верх-вниз)

    class onePipes {

        Vector2 position;
        float speed = 1.5f;
       // Rectangle rect1; //размер трубы
        Rectangle empty; //пустота между труб
        int b = new Random().nextInt(200);//рандомная высота труб

        public onePipes(Vector2 pos) {
            position = pos;
           // rect1 = new Rectangle(position.x, position.y - b, 55,330);
            empty = new Rectangle(position.x, position.y - b + 330, 55, 130);
            // empty размеры пустого прямоугольника
        }

        public void update() {
            position.x -= speed;

            if (position.x < 10) { //шрина картинки при исчезновении
                position.x = 560; // ширна игры
                b = new Random().nextInt(200);            }

            empty.x = position.x; //обновляем пустой прямоугольник вместе с трубой
            empty.y = position.y - b + 330;
        }
    }

    static onePipes[] ob = new onePipes[3];
    int startX = 400; //появление первой трубы

    public Pipes() {
        for (int i = 0; i < ob.length; i++) {
            ob[i] = new onePipes(new Vector2(startX, 0));
            startX += 190; //дистанция между трубами (право-лево)
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < ob.length; i++) {
            batch.draw(pip, ob[i].position.x, ob[i].position.y - ob[i].b); //нижняя труба
            batch.draw(pip, ob[i].position.x, ob[i].position.y + distance + 330 - ob[i].b); //верхняя

        }
    }

    public void update() {
        for (int i = 0; i < ob.length; i++) {
            ob[i].update();
        }
    }

    public void restart() {
        startX = 400;
        for (int i = 0; i < ob.length; i++) {
            ob[i] = new onePipes(new Vector2(startX, 0));
            startX += 190;
        }
    }
}

