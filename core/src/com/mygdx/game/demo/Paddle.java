package com.mygdx.game.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class Paddle {
    public static final int WIDTH = 200;
    public static final int Y = 100;
    public static final int HEIGHT = 30;
    private ShapeRenderer shapeRenderer;

    public Paddle(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }

    public int getY(){
        return Y + HEIGHT;
    }

    public int getLeftCoordinate() {
        return Gdx.input.getX();
    }

    public int getRightCoordinate() {
        return Gdx.input.getX() + WIDTH;
    }

    public void render() {
        System.out.println();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.box(Gdx.input.getX(), Y, 1, WIDTH, HEIGHT, 1);
//        shapeRenderer.box(Gdx.input.getX(), Y, 1, WIDTH, HEIGHT, 1);
        shapeRenderer.end();
    }
}
