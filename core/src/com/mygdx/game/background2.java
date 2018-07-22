package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class background2 {

    class BG2{
        private Texture img2;
        private Vector2 pos2;

        public BG2 (Vector2 pos){
            this.pos2=pos;
            img2 = new Texture("Движущийся фон.jpg");
        }
    }
    private float speed;
    private BG2[] bg;

    public background2() {
        speed = 1.5f;
        bg = new BG2[2];
        bg [0] = new BG2(new Vector2(0, -20));
        bg [1] = new BG2(new Vector2(560, -20));
         }

    public void render(SpriteBatch batch) {
        for (int i = 0; i <bg.length ; i++) {
            batch.draw(bg[i].img2, bg[i].pos2.x, bg[i].pos2.y);
        }
    }

    public void update() {
        bg[0].pos2.x -= speed;
        bg[1].pos2.x = bg[0].pos2.x + 560;
        if (bg[0].pos2.x < -560){
            bg[0].pos2.x = 0;
        }

    }

}


