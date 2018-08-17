package com.harush.zitoon.quoridor.core.logic;

import com.harush.zitoon.quoridor.core.model.Coordinate;
import com.harush.zitoon.quoridor.core.model.LogicResult;

public interface Board {

    LogicResult setPawn(Pawn pawn, Coordinate coordinate);

    LogicResult setWall(Wall wall, Coordinate coordinate);

    boolean isBoardBoxOccupied(Coordinate coordinate);

    boolean isBoardBorderOccupied(Coordinate coordinate);

    boolean isWithinBoard(Coordinate coordinate);
}
