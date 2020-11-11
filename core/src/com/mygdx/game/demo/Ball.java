package com.mygdx.game.demo;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Predicate;
import com.mygdx.game.util.CoordsInCircle;
import com.badlogic.gdx.graphics.Color;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.tuple.Pair;

public class Ball {

    private int x;
    private int y;
    private int rad;

    private int speed;
    private ShapeRenderer shapeRenderer;

    Pair<Predicate<Integer>, Predicate<Integer>> widthCompare;
    Pair<Predicate<Integer>, Predicate<Integer>> heightCompare;

    Pair<BiFunction<Integer, Integer, Integer>, BiFunction<Integer, Integer, Integer>> xMod;
    Pair<BiFunction<Integer, Integer, Integer>, BiFunction<Integer, Integer, Integer>> yMod;


    private BiFunction<Integer, Integer, Integer> increaseCoord = (coord, movement) -> coord + movement;
    private BiFunction<Integer, Integer, Integer> decreaseCoord = (coord, movement) -> coord - movement;

    public Ball(int x, int y, int rad, int speed, int width, int height, ShapeRenderer shapeRenderer) {
        this.x = x;
        this.y = y;
        this.rad = rad;
        this.speed = speed;
        this.shapeRenderer = shapeRenderer;

        widthCompare = Pair.of(input -> input < width, input -> input > 0);
        heightCompare = Pair.of(input -> input < height, input -> input > 0);

        xMod = Pair.of(increaseCoord, decreaseCoord);
        yMod = Pair.of(increaseCoord, decreaseCoord);
    }

    private Pair<Integer, Integer> getEdgeCoord(int coord) {
        return Pair.of(coord + rad, coord - rad);
    }

    private int move(int coord,
                     BiFunction<Integer, Integer, Integer> modify,
                     Predicate<Integer> isInLimit) {
        Pair<Integer, Integer> edgeCoord = getEdgeCoord(coord);

        if (isInLimit.evaluate(modify.apply(edgeCoord.getLeft(), speed)) && isInLimit.evaluate(modify.apply(edgeCoord.getRight(), 1))) {
            return modify.apply(coord, speed);
        }
        throw new IllegalStateException();
    }


    private boolean checkForPaddle(Paddle paddle) {
        CoordsInCircle coordsInCircle = new CoordsInCircle(Pair.of(x, y), rad);
        List<Boolean> collect = IntStream.range(paddle.getLeftCoordinate(), paddle.getRightCoordinate())
                .mapToObj(paddleX -> coordsInCircle.test(Pair.of(paddleX, paddle.getY())))
                .collect(Collectors.toList());
        if (collect.contains(true)) {
            swapY();
            y = paddle.getY() + rad;
            y = yMod.getLeft().apply(y, speed);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.GOLD);
            shapeRenderer.circle(x, y, rad);
            shapeRenderer.end();
            return true;
        }
        return false;
    }

    public void move(Paddle paddle) {

        if(isDead()){

        }
        System.out.println(x);
        System.out.println(y);
        System.out.println(paddle.getLeftCoordinate());
        System.out.println(paddle.getRightCoordinate());
        System.out.println(paddle.getY());
        checkForPaddle(paddle);

        try {
            x = move(x, xMod.getLeft(), widthCompare.getLeft());
        } catch (IllegalStateException e) {
            swapX();
            move(x, xMod.getLeft(), widthCompare.getLeft());
        }

        try {
            y = move(y, yMod.getLeft(), heightCompare.getLeft());
        } catch (IllegalStateException e) {
            swapY();
            move(y, yMod.getLeft(), heightCompare.getLeft());
        }

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.circle(x, y, rad);
        shapeRenderer.end();
    }

    private void swapX(){
        xMod = Pair.of(xMod.getRight(), xMod.getLeft());
        widthCompare = Pair.of(widthCompare.getRight(), widthCompare.getLeft());
    }
    private void swapY(){
        yMod = Pair.of(yMod.getRight(), yMod.getLeft());
        heightCompare = Pair.of(heightCompare.getRight(), heightCompare.getLeft());
    }
    private boolean isDead() {
        return false;
    }
}
