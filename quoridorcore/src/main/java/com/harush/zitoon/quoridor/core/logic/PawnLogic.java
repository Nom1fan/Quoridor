package com.harush.zitoon.quoridor.core.logic;


import com.harush.zitoon.quoridor.core.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PawnLogic implements Pawn {

    private static final Logger log = Logger.getLogger(PawnLogic.class.getSimpleName());

    private Coordinate coordinate;

    public PawnLogic() {
        coordinate = new Coordinate(-1, -1);
    }

    @Override
    public LogicResult spawn(Coordinate coordinate, Board board) {
        log.config("Spawning at coordinate:" + coordinate);

        LogicResult logicResult = board.setPawn(this, coordinate);

        if (!logicResult.isSuccess()) {
            return createFailedLogicResult("Can't spawn at:" + coordinate);
        }

        return new LogicResult(true);
    }

    @Override
    public LogicResult move(Coordinate coordinate, Board board) {
        log.config("Moving to coordinate:" + coordinate);

        if (!isSpawned()) {
            return createFailedLogicResult("Pawn cannot move before spawning");
        }

        if (board.isWithinBoard(coordinate)) {
            return createFailedLogicResult(String.format("Moving to: %s is an invalid pawn move", coordinate));
        }


        board.setPawn(null, coordinate);

        LogicResult logicResult = board.setPawn(this, coordinate);
        if (logicResult.isSuccess()) {
            this.coordinate = new Coordinate(coordinate.getX(), coordinate.getY());
        }

        return logicResult;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    private boolean isSpawned() {
        return coordinate.getX() != -1 && coordinate.getY() != -1;
    }

    private List<Coordinate> getValidCoordinatesForMove(Board board) {
        List<Coordinate> validCoordinatesForMove = new ArrayList<>();

        validCoordinatesForMove.add(getValidCoordinateUp(board));
        validCoordinatesForMove.add(getValidCoordinateLeft(board));


    }

    private Coordinate getValidCoordinateLeft(Board board) {


    }

    private Coordinate getValidCoordinateUp(Board board) {
        if (board.isBoardBorderOccupied(coordinate)) {
            return null;
        }

        Coordinate coordinateUp = new Coordinate(coordinate.getX(), coordinate.getY() - 1);

        if (board.isWithinBoard(coordinateUp) && !board.isBoardBoxOccupied(coordinateUp)) {
            return coordinateUp;
        }

        Coordinate coordinateJump = new Coordinate(coordinate.getX(), coordinate.getY() - 2);

        if (board.isWithinBoard(coordinateJump) && !board.isBoardBoxOccupied(coordinateJump)) {
            return coordinateJump;
        }

        return null;
    }

    private LogicResult createFailedLogicResult(String errMsg) {
        return new LogicResult(false, errMsg);
    }

}
