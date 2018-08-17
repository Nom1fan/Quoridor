package com.harush.zitoon.quoridor.core.logic;

public class BoardBorderLogic implements BoardBorder {

    private Wall wall;

    @Override
    public boolean isOccupied() {
        return wall != null;
    }

    @Override
    public Wall getWall() {
        return wall;
    }

    @Override
    public void setWall(Wall wall) {
        this.wall = wall;
    }
}
