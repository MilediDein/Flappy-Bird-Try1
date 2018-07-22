package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.MyGdxGame.gameover;

public class Score {
    Texture Sc1;
    Texture Sc2;
    Texture Sc3;
    Texture Sc4;
    Vector2 position;
    static int score;
    static int BestScore;

    public Score (){
        Sc1 = new Texture("nomedal.png");
        Sc2 = new Texture("bronzemedal.png");
        Sc3 = new Texture("silvermedal.png");
        Sc4 = new Texture("goldmedal.png");
        position = new Vector2(150, 270);
        score = 0;
        BestScore = 0;
    }

    public void render(SpriteBatch batch) {
        if (gameover && score<3){
            batch.draw(Sc1, position.x, position.y);}
        else if (gameover && score==3 || gameover && score<5){
            batch.draw(Sc2, position.x, position.y);}
        else if (gameover && score==5 || gameover && score<7){
            batch.draw(Sc3, position.x, position.y);}
        else if (gameover && score>=7){
            batch.draw(Sc4, position.x, position.y);}
    }
    public void update() {

    }
        public void restart() {
        position = new Vector2(150, 270);
        score = 0;
    }
}
