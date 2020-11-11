package com.mygdx.game.demo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SceneDemo implements ApplicationListener {

    public class MyActor extends Actor {

        Texture texture;

        public MyActor() {
            AssetManager manager = new AssetManager();
            manager.load("data/jet.png", Texture.class);
            while (!manager.update()) {
                System.out.println("still laoding");
            }

            while (!manager.isLoaded("data/jet.png")) {
            }
            // texture is available, let's fetch it and do something interesting
            texture = manager.get("data/jet.png");
        }

        @Override
        public void draw(Batch batch, float alpha) {
            batch.draw(texture, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
        }
    }

    private Stage stage;

    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());

        MyActor myActor = new MyActor();
        stage.addActor(myActor);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}