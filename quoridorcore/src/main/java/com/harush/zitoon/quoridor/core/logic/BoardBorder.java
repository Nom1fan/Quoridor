package com.harush.zitoon.quoridor.core.logic;

public interface BoardBorder {

    boolean isOccupied();

    Wall getWall();

    void setWall(Wall wall);

}
