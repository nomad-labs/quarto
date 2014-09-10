package com.nomadlabs.quartolib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by doubleo2 on 9/7/14.
 */
public class PieceTest {

    @Test
    public void testCommonDimension() {
        Piece one = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND, Piece.Size.SHORT);
        assertEquals(true, Piece.haveCommonDimension(one));
    }

    @Test
    public void testCommonDimensionFalse() {
        Piece one = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND, Piece.Size.SHORT);
        Piece two = new Piece(Piece.Color.RED, Piece.Density.SOLID, Piece.Shape.SQUARE, Piece.Size.TALL);
        assertFalse(Piece.haveCommonDimension(one, two));
    }

    @Test
    public void testCommonDimensionColor() {
        Piece one = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND, Piece.Size.SHORT);
        Piece two = new Piece(Piece.Color.BLUE, Piece.Density.SOLID, Piece.Shape.SQUARE, Piece.Size.TALL);
        assertTrue(Piece.haveCommonDimension(one, two));
    }

    @Test
    public void testCommonDimensionDensity() {
        Piece one = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND, Piece.Size.SHORT);
        Piece two = new Piece(Piece.Color.RED, Piece.Density.HOLLOW, Piece.Shape.SQUARE, Piece.Size.TALL);
        assertTrue(Piece.haveCommonDimension(one, two));
    }

    @Test
    public void testCommonDimensionShape() {
        Piece one = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.SQUARE, Piece.Size.SHORT);
        Piece two = new Piece(Piece.Color.RED, Piece.Density.SOLID, Piece.Shape.SQUARE, Piece.Size.TALL);
        assertTrue(Piece.haveCommonDimension(one, two));
    }

    @Test
    public void testCommonDimensionSize() {
        Piece one = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND, Piece.Size.TALL);
        Piece two = new Piece(Piece.Color.RED, Piece.Density.SOLID, Piece.Shape.SQUARE, Piece.Size.TALL);
        assertTrue(Piece.haveCommonDimension(one, two));
    }

    @Test
    public void testCommonDimensionThreeFalse() {
        Piece one = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND, Piece.Size.SHORT);
        Piece two = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.SQUARE, Piece.Size.TALL);
        Piece three = new Piece(Piece.Color.RED, Piece.Density.SOLID, Piece.Shape.SQUARE, Piece.Size.TALL);
        assertFalse(Piece.haveCommonDimension(one, two, three));
    }

    @Test
    public void testCommonDimensionThreeTrue() {
        Piece one = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.SQUARE, Piece.Size.SHORT);
        Piece two = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.SQUARE, Piece.Size.TALL);
        Piece three = new Piece(Piece.Color.RED, Piece.Density.SOLID, Piece.Shape.SQUARE, Piece.Size.TALL);
        assertTrue(Piece.haveCommonDimension(one, two, three));
    }

}
