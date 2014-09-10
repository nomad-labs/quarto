package com.nomadlabs.quartolib;

/**
 * Created by doubleo2 on 9/8/14.
 */
public class StandardBoard extends BaseBoard {

    @Override
    public Piece[][] getCombinations() {
        Piece[][] combinations = new Piece[8][4];

        int count = 0;
        for (Piece p : mSquares) {
            if (null != p) {
                combinations[count / 4][count % 4] = p;
                combinations[4 + count % 4][(count + 1)/ 4] = p;
            }
            count++;
        }

        return combinations;
    }
}
