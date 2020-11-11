package com.mygdx.game.util;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordsInCircleTest {

    @Test
    public void testInCircle() {
        CoordsInCircle coordsInCircle = new CoordsInCircle(Pair.of(10, 10), 10);
        assertEquals(coordsInCircle.test(Pair.of(10,10)), true);
        assertEquals(coordsInCircle.test(Pair.of(20,10)), true);
        assertEquals(coordsInCircle.test(Pair.of(0,10)), true);
        assertEquals(coordsInCircle.test(Pair.of(10,20)), true);
        assertEquals(coordsInCircle.test(Pair.of(10,0)), true);

    }

    @Test
    public void testOutsideOfCircle() {
        CoordsInCircle coordsInCircle = new CoordsInCircle(Pair.of(10, 10), 5);
        assertEquals(coordsInCircle.test(Pair.of(16,10)), false);
        assertEquals(coordsInCircle.test(Pair.of(4,10)), false);
        assertEquals(coordsInCircle.test(Pair.of(10,16)), false);
        assertEquals(coordsInCircle.test(Pair.of(10,4)), false);
        coordsInCircle = new CoordsInCircle(Pair.of(500, 500), 100);
        assertEquals(coordsInCircle.test(Pair.of(590,526)), false);
    }
}