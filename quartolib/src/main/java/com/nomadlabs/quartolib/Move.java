package com.nomadlabs.quartolib;

/**
 * Created by doubleo2 on 9/7/14.
 */
public class Move {

    private Player mPlayer;

    private Piece mPiece;

    private int xCoord;

    private int yCoord;

    public Move(Player player, Piece piece, int x, int y) {
        mPlayer = player;
        mPiece = piece;
        xCoord = x;
        yCoord = y;
    }

    public Piece getPiece() {
        return mPiece;
    }

    public Player getPlayer() {
        return mPlayer;
    }

    public int getX() {
        return xCoord;
    }

    public int getY() {
        return yCoord;
    }
}
