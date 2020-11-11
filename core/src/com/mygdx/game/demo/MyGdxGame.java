package com.mygdx.game.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyGdxGame extends ApplicationAdapter {
    ShapeRenderer shape;
    private List<Ball> balls;
    Random rand = new Random();
    private Paddle paddle;
    private SceneDemo scene;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        balls = IntStream.range(0, 1).mapToObj(i ->
//                new Ball(rand.nextInt(Gdx.graphics.getWidth()),
//                        rand.nextInt(Gdx.graphics.getHeight()),
//                        rand.nextInt(100),
//                        rand.nextInt(20),
//                        Gdx.graphics.getWidth(),
//                        Gdx.graphics.getHeight(),
//                        shape))
                new Ball(500,
                        500,
                        100,
                        10,
                        Gdx.graphics.getWidth(),
                        Gdx.graphics.getHeight(),
                        shape))
                .collect(Collectors.toList());
        System.out.println(balls.size());
        paddle = new Paddle(shape);
        scene = new SceneDemo();
        scene.create();
    }

    @Override
    public void render() {
        scene.render();
//        paddle.render();
//        balls.forEach(ball -> ball.move(paddle));
    }
}
