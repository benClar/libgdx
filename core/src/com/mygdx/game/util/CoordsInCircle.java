package com.mygdx.game.util;

import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Predicate;

public class CoordsInCircle implements Predicate<Pair<Integer, Integer>> {

    private final Pair<Integer, Integer> circleCoordinates;
    private final int radius;

    public CoordsInCircle(Pair<Integer, Integer> circleCoordinates, int radius){
        this.circleCoordinates = circleCoordinates;
        this.radius = radius;
    }

    @Override
    public boolean test(Pair<Integer, Integer> coordinates) {
        double v = Math.pow(coordinates.getLeft() - circleCoordinates.getLeft(), 2)
                + Math.pow(coordinates.getRight() - circleCoordinates.getRight(), 2);
        return Double.compare(v, Math.pow(radius, 2)) <= 0;
    }
}
