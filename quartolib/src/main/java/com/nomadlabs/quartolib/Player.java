package com.nomadlabs.quartolib;

/**
 * Created by doubleo2 on 9/7/14.
 */
public class Player {

    private String mId;

    private String mName;

    Piece[] mPieces;

    public Player(String id, String name, Piece[] pieces) {
        mId = id;
        mName = name;
        mPieces = pieces;
    }

    public boolean canPlayPiece(Piece piece) {
        for (Piece p : mPieces) {
            if (p.equals(piece) && !p.isPlayed) {
                return true;
            }
        }
        return false;
    }
}
