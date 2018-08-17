package com.harush.zitoon.quoridor.core.logic;

import com.harush.zitoon.quoridor.core.model.Coordinate;
import com.harush.zitoon.quoridor.core.model.LogicResult;
import com.harush.zitoon.quoridor.core.model.Orientation;
import org.springframework.lang.NonNull;

public class BoardLogic implements Board {

    private BoardBox[][] boardBoxes;

    private BoardBorder[][] boardBorders;

    public BoardLogic(@NonNull BoardBox[][] boardBoxes, @NonNull BoardBorder[][] boardBorders) {
        this.boardBoxes = boardBoxes;
        this.boardBorders = boardBorders;
    }

    @Override
    public LogicResult setPawn(Pawn pawn, Coordinate coordinate) {

        if (!isWithinBoard(coordinate)) {
            return new LogicResult(false, "Cannot set pawn at: " + coordinate);
        }

        int x = coordinate.getX();
        int y = coordinate.getY();

        boardBoxes[x][y].setPawn(pawn);

//        if (boardPiece.getOrientation() == NONE) {
//            int currentX = boardPiece.getX();
//            int currentY = boardPiece.getY();
//
//            if (isValidCoordinate(currentX, currentY)) {
//                boardBoxes[currentX][currentY].setBoardPiece(null);
//            }
//            boardBoxes[x][y].setBoardPiece(boardPiece);
//        } else {
//            if (boardPiece.getOrientation() == Horizontal) {
//                setHorizontal(boardPiece, x, y);
//            } else {
//                setVertical(boardPiece, x, y);
//            }
//        }

        return new LogicResult(true);
    }

    @Override
    public LogicResult setWall(Wall wall, Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (!isValidCoordinateForWall(wall.getOrientation(), x , y)) {
            return new LogicResult(false, String.format("Cannot set wall at (%d,%d)", x, y));
        }

        int currentX = wall.getCoordinate().getX();
        int currentY = wall.getCoordinate().getY();

        if (isValidCoordinateForWall(wall.getOrientation(), currentX, currentY)) {
            boardBorders[currentX][currentY].setWall(null);
        }
        boardBorders[x][y].setWall(wall);

        return new LogicResult(true);
    }

    @Override
    public boolean isWithinBoard(Coordinate coordinate) {
        return (isCoordinateWithinBorders(coordinate.getX()) && isCoordinateWithinBorders(coordinate.getY()));
    }

    private boolean isValidCoordinateForWall(Orientation orientation, int x, int y) {
        switch (orientation) {
            case HORIZONTAL:
                return (x >= 0 && x <= 7) && (y >= 1 && y <= 8);

            case VERTICAL:
                return (x >= 1 && x <= 8) && (y >= 0 && y <= 7);
            default:
                throw new RuntimeException("Unknown orientation received. Known values are either HORIZONTAL or VERTICAL");
        }
    }

//    private void setVertical(BoardPiece boardPiece, int x, int y) {
//        int currentX = boardPiece.getX();
//        int currentY = boardPiece.getY();
//
//        if (isValidCoordinateForPawn(currentX, currentY)) {
//            for (int i = 0; i < boardPiece.getLength(); i++) {
//                boardBoxes[boardPiece.getX()][boardPiece.getY() + i].setPawn(null);
//            }
//        }
//
//        for (int i = 0; i < boardPiece.getLength(); i++) {
//            boardBoxes[x][y + i].setPawn(boardPiece);
//        }
//    }
//
//    private void setHorizontal(BoardPiece boardPiece, int x, int y) {
//        int currentX = boardPiece.getX();
//        int currentY = boardPiece.getY();
//
//        if (isValidCoordinateForPawn(currentX, currentY)) {
//            for (int i = 0; i < boardPiece.getLength(); i++) {
//                boardBoxes[currentX + i][currentY].setPawn(null);
//            }
//        }
//
//        for (int i = 0; i < boardPiece.getLength(); i++) {
//            boardBoxes[x + i][y].setPawn(boardPiece);
//        }
//    }

    @Override
    public boolean isBoardBoxOccupied(Coordinate coordinate) {
        return boardBoxes[coordinate.getX()][coordinate.getY()].isOccupied();
    }

    @Override
    public boolean isBoardBorderOccupied(Coordinate coordinate) {
        return boardBorders[coordinate.getX()][coordinate.getY()].isOccupied();
    }

    private boolean isCoordinateWithinBorders(int coordinate) {
        return coordinate >= 0 && coordinate <= 8;
    }
}
