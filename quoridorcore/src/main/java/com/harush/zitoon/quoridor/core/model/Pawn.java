package com.harush.zitoon.quoridor.core.model;


public interface Pawn {

    LogicResult spawn(int x, int y);

    LogicResult move(int x, int y);

    int getX();

    int getY();
}
