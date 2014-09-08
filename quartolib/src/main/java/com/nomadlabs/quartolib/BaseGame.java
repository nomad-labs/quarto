package com.nomadlabs.quartolib;

public abstract class BaseGame {

    Board mBoard;

    Player mPlayer1;

    Player mPlayer2;

    public abstract Player hasWinner();
}
