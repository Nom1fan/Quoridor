package com.harush.zitoon.quoridor.core.logic;

public class BoardBoxLogic implements BoardBox {

    private Pawn pawn;

    @Override
    public boolean isOccupied() {
        return pawn != null;
    }

    @Override
    public Pawn getPawn() {
        return pawn;
    }

    @Override
    public void setPawn(Pawn boardPiece) {
        this.pawn = boardPiece;
    }
}
