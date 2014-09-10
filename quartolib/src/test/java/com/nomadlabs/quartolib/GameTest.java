package com.nomadlabs.quartolib;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by doubleo2 on 9/8/14.
 */
public class GameTest {

    Game mGame;

    Player p1;

    Player p2;

    @Before
    public void setUp() {
        p1 = new Player("1", "One", Piece.createSet(Piece.Color.BLUE));
        p2 = new Player("2", "Two", Piece.createSet(Piece.Color.RED));
        mGame = new Game(p1, p2, new StandardBoard());
    }

    @Test
    public void playerOnePlaysFirst() {
        assertTrue(mGame.isMyTurn(p1));
        assertFalse(mGame.isMyTurn(p2));
    }

    @Test
    public void turnsAlternate() {
        playFirstPiece();
        assertFalse(mGame.isMyTurn(p1));
    }

    @Test
    public void testPieceOnlyPlaysOnce() {
        playFirstPiece();
        // try to play the same piece on a different square
        assertFalse(mGame.isValidMove(p1, p1.mPieces[0], 0, 1));
    }

    @Test
    public void testSquareMustBeVacant() {
        playFirstPiece();
        // try to play a different piece on the same square
        assertFalse(mGame.isValidMove(p1, p1.mPieces[1], 2, 3));
    }

    private void playFirstPiece() {
        mGame.play(p1, p1.mPieces[0], 2, 3);
    }

}
