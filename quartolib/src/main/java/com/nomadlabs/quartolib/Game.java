package com.nomadlabs.quartolib;

import java.util.ArrayList;
import java.util.List;

public class Game {

    BaseBoard mBoard;

    Move mLastMove;

    List<Move> mMoves;

    Player mPlayer1;

    Player mPlayer2;

    Player mWinner;

    public Game(Player p1, Player p2, BaseBoard board) {
        mPlayer1 = p1;
        mPlayer2 = p2;
        mBoard = board;
        mMoves = new ArrayList<Move>();
    }

    public boolean isMyTurn(Player p) {
        if (mMoves.size() == 0) {
            return p.equals(mPlayer1);
        }
        return !mLastMove.getPlayer().equals(p);
    }

    public boolean isValidMove(Player player, Piece piece, int x, int y) {
        return player.canPlayPiece(piece) &&
               mBoard.isSquareFree(x, y);
    }

    // Return MoveResult with game status or error?
    public void play(Player player, Piece piece, int x, int y) {
        if (!isMyTurn(player)) {
            // throw exception here?
        }
        if (!isValidMove(player, piece, x, y)) {
            // throw exception here?
        }

        Move move = new Move(player, piece, x, y);
        mBoard.play(move);
        mMoves.add(move);
        mLastMove = move;

        checkForWinner();
    }

    private void checkForWinner() {
        if (mBoard.hasWinner()) {
            mWinner = mLastMove.getPlayer();
        }
    }

}
