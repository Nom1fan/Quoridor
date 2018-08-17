package com.harush.zitoon.quoridor.core.logic;

import com.harush.zitoon.quoridor.core.model.Coordinate;
import com.harush.zitoon.quoridor.core.model.LogicResult;

public interface Pawn extends BoardPiece {

    LogicResult spawn(Coordinate coordinate, Board board);

    LogicResult move(Coordinate coordinate, Board board);
}
