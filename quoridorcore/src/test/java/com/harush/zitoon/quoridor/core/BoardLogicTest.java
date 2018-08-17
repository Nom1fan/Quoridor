package com.harush.zitoon.quoridor.core;

import com.harush.zitoon.quoridor.core.logic.BoardBoxLogic;
import com.harush.zitoon.quoridor.core.logic.BoardLogic;
import com.harush.zitoon.quoridor.core.logic.BoardPiece;
import com.harush.zitoon.quoridor.core.logic.PawnLogic;
import com.harush.zitoon.quoridor.core.model.LogicResult;
import com.harush.zitoon.quoridor.core.theirs.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class BoardLogicTest {

    private BoardLogic boardLogic;

    @Mock
    private BoardPiece boardPiece;

    private BoardBoxLogic[][] boardBoxLogics;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        boardBoxLogics = new BoardBoxLogic[9][9];
        boardLogic = new BoardLogic(boardBoxLogics, boardBorders);
    }

    @Test
    public void coordinateOutOfBoard_LogicResultFalse() {
        LogicResult logicResult = boardLogic.setPawn(boardPiece, -1, -1);

        Assert.assertFalse(logicResult.isSuccess());
        Assert.assertEquals("Cannot set board piece at (-1,-1)", logicResult.getErrMsg());
    }

    @Test
    public void coordinateOccupied_LogicResultFalse() {
        boardBoxLogics[1][1] = new BoardBoxLogic();
        boardBoxLogics[1][1].setPawn(new PawnLogic());

        LogicResult logicResult = boardLogic.setPawn(boardPiece, 1, 1);

        Assert.assertFalse(logicResult.isSuccess());
        Assert.assertEquals("Cannot set board piece at (1,1)", logicResult.getErrMsg());
    }

    @Test
    public void setAtValidLocation_BoardPieceSet() {

        boardBoxLogics[1][1] = new BoardBoxLogic();

        when(boardPiece.getOrientation()).thenReturn(Position.Orientation.NONE);
        when(boardPiece.getX()).thenReturn(-1);
        when(boardPiece.getY()).thenReturn(-1);

        LogicResult logicResult = boardLogic.setPawn(boardPiece, 1, 1);

        Assert.assertTrue(logicResult.isSuccess());

        Assert.assertTrue(boardBoxLogics[1][1].isOccupied());
        Assert.assertEquals(boardPiece, boardBoxLogics[1][1].getPawn());
    }
}
