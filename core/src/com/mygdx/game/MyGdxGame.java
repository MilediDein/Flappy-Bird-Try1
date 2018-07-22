package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    background img;
    background2 img2;
    Bird bird;
    Pipes pip;
     static boolean gameover;
    Texture restart1;
    Texture over;
    Texture Score1;
    boolean startgame;
    Texture gamename;
    Texture playbutton;
    Score score;

    @Override
    public void create() { //создание объектов
        batch = new SpriteBatch();
        img = new background();
        img2 = new background2();
        bird = new Bird();
        pip = new Pipes();
        gameover = false;
        restart1 = new Texture("restart.png");
        over = new Texture("game over.png");
        Score1 = new Texture("Score.png");
        gamename = new Texture("title.png");
        playbutton = new Texture("playbutton.png");
        score = new Score();
        startgame = true;

    }

    @Override
    public void render() { //прорисовка
        update();
        batch.begin();
        img.render(batch);

        if (startgame) {
            batch.draw(gamename, 100, 370);
            batch.draw(playbutton, 200, 170);
                    }
        else if (!gameover) {
            bird.render(batch);
            pip.render(batch);
            batch.draw(Score1, 0, 470);

        } else {
            batch.draw(over, 160, 400);
            batch.draw(restart1, 230, 200);
            score.render(batch);
        }
        img2.render(batch);
        batch.end();
    }

        public void update() {
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                startgame = false;
            }
            img.update();
            bird.update();
            pip.update();
            img2.update();
            if (bird.pos.y < 66 || bird.pos.y > 500) {
                gameover = true;
            }
            for (int i = 0; i < Pipes.ob.length; i++) {
                if (bird.pos.x > Pipes.ob[i].position.x && bird.pos.x < Pipes.ob[i].position.x + 55) {
                    if (!Pipes.ob[i].empty.contains(bird.pos)) {
                        gameover = true;
                    }
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameover == true) {
                restart();
            }
            for (int i = 0; i < Pipes.ob.length; i++) {
                if (bird.pos.x +28 == Pipes.ob[i].position.x+50 && Pipes.ob[i].empty.contains(bird.pos)) {
                    Score.score += 1;
                    System.out.print(Score.score);}


         /*    if (gameover == true&& Score.score > Score.BestScore){
                    Score.BestScore=Score.score;
                    System.out.print("BestScore: "+ Score.BestScore);
                  }
             else if (gameover == true&& Score.score <= Score.BestScore){
                    System.out.print("BestScore: "+ Score.BestScore + " ");
                 } не получилось, надо подумать как сделать*/

                }
            }



    public void restart(){
        startgame = true;
        bird.restart();
        pip.restart();
        gameover = false;
        score.restart();
    }
}

