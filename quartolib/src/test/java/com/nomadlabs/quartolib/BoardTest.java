package com.nomadlabs.quartolib;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by doubleo2 on 9/7/14.
 */
public class BoardTest {

    private StandardBoard mBoard;

    @Before
    public void setUp() {
        mBoard = new StandardBoard();
    }

    @Test
    public void testSquareFree() {
        assertTrue(mBoard.isSquareFree(2, 1));
    }

    @Test
    public void testSquareOccupied() {
        Piece piece = new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND,
                Piece.Size.SHORT);

        mBoard.play(new Move(null, piece, 3, 3));

        assertFalse(mBoard.isSquareFree(3, 3));
    }

    @Test
    public void testComboIsComplete() {
        Piece[] pieces = new Piece[] {
                new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.SQUARE, Piece.Size.SHORT),
                new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND, Piece.Size.TALL),
                new Piece(Piece.Color.BLUE, Piece.Density.SOLID, Piece.Shape.ROUND, Piece.Size.SHORT),
                new Piece(Piece.Color.BLUE, Piece.Density.SOLID, Piece.Shape.SQUARE, Piece.Size.TALL)
        };

        assertTrue(mBoard.isFourPieceCombo(pieces));
    }

    @Test
    public void testComboIsIncomplete() {

        Piece[] pieces = new Piece[] {
                new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND, Piece.Size.TALL),
                new Piece(Piece.Color.BLUE, Piece.Density.SOLID, Piece.Shape.ROUND, Piece.Size.SHORT),
                null,
                new Piece(Piece.Color.BLUE, Piece.Density.SOLID, Piece.Shape.SQUARE, Piece.Size.TALL)
        };

        assertFalse(mBoard.isFourPieceCombo(pieces));

        pieces[2] = pieces[3];
        pieces[3] = null;

        assertFalse(mBoard.isFourPieceCombo(pieces));
    }

    @Test
    public void testStandardBoardRowWins() {
        Piece[] pieces = new Piece[] {
                new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.SQUARE, Piece.Size.SHORT),
                new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND, Piece.Size.TALL),
                new Piece(Piece.Color.BLUE, Piece.Density.SOLID, Piece.Shape.ROUND, Piece.Size.SHORT),
                new Piece(Piece.Color.BLUE, Piece.Density.SOLID, Piece.Shape.SQUARE, Piece.Size.TALL)
        };

        for (int i = 0; i < 4; i++) {
            mBoard.play(new Move(null, pieces[i], 1, i));
        }

        assertTrue(mBoard.hasWinner());
    }

    @Test
    public void testStandardBoardColumnWins() {
        Piece[] pieces = new Piece[] {
                new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.SQUARE, Piece.Size.SHORT),
                new Piece(Piece.Color.BLUE, Piece.Density.HOLLOW, Piece.Shape.ROUND, Piece.Size.TALL),
                new Piece(Piece.Color.BLUE, Piece.Density.SOLID, Piece.Shape.ROUND, Piece.Size.SHORT),
                new Piece(Piece.Color.BLUE, Piece.Density.SOLID, Piece.Shape.SQUARE, Piece.Size.TALL)
        };

        for (int i = 0; i < 4; i++) {
            mBoard.play(new Move(null, pieces[i], i, 2));
        }

        assertTrue(mBoard.hasWinner());
    }
}
