package com.harush.zitoon.quoridor.ui;

import static org.junit.Assert.*;

import com.harush.zitoon.quoridor.ui.model.Board;
import com.harush.zitoon.quoridor.ui.model.HumanPlayer;
import com.harush.zitoon.quoridor.ui.model.Player;
import com.harush.zitoon.quoridor.ui.model.Tile;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Board.java.
 * @author Anas Khan
 * @version 0.1
 */

public class BoardTest {
	
	private Board board;
	private Tile[][] tiles;
	private Player player;

	@Before
	public void setUp() {
		board = new Board(9,9);
		player = new HumanPlayer("Alberto Del Rio", "#ffffff");
	}

	@Test
	public void testGetTile() {
		assertNotNull(board.getTile(3,4));
	}

	@Test
	public void testContainsWall() {
		board.setWall(5, 4, true, true, player);
		assertTrue(board.containsWall(5, 4, true));
	}

	@Test
	public void testSetWall() {
		board.setWall(8, 5, false, true, player);
		assertTrue(board.containsWall(8, 5, false));
	}

	@Test
	public void testGetWall() {
		board.setWall(8, 5, false, true, player);
		assertTrue(board.containsWall(8, 5, false));
	}

	@Test
	public void testRemoveWall() {
		board.setWall(3, 2, true, true, player);
		board.removeWall(3, 2, true);
	}

	@Test
	public void testGetHeight() {
		assertEquals(9, board.getHeight());
	}

	@Test
	public void testGetWidth() {
		assertEquals(9, board.getWidth());
	}

}
