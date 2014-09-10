package com.nomadlabs.quartolib;

/**
 * Created by doubleo2 on 9/7/14.
 */
public abstract class BaseBoard {

    Piece[] mSquares;

    public BaseBoard() {
        mSquares = new Piece[16];
    }

    public void play(Move move) {
        int index = indexFromXY(move.getX(), move.getY());

        assert mSquares[index] == null;
        Piece piece = move.getPiece();
        mSquares[index] = piece;

        piece.setPlayed(true);
    }

    private int indexFromXY(int x, int y) {
        return 4 * x + y;
    }

    public boolean isSquareFree(int x, int y) {
        int index = indexFromXY(x, y);
        if (index < mSquares.length && mSquares[index] == null) {
            return true;
        }
        return false;
    }

    public boolean hasWinner() {
        boolean winner = false;

        for (Piece[] combination : getCombinations()) {
            if (isFourPieceCombo(combination) &&
                    Piece.haveCommonDimension(combination)) {
                markAsWinners(combination);
                winner = true;
            }
        }

        return winner;
    }

    boolean isFourPieceCombo(Piece[] combination) {
        if (combination.length != 4) {
            return false;
        }

        for (Piece p : combination) {
            if (null == p) {
                return false;
            }
        }

        return true;
    }

    private void markAsWinners(Piece[] combination) {
        for (Piece p : combination) {
            p.setHighlighted(true);
        }
    }

    abstract Piece[][] getCombinations();
}
