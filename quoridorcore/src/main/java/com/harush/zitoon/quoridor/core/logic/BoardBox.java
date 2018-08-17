package com.harush.zitoon.quoridor.core.logic;

public interface BoardBox {

    boolean isOccupied();

    Pawn getPawn();

    void setPawn(Pawn pawn);

}
