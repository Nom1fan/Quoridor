package com.harush.zitoon.quoridor.ui;

import static org.junit.Assert.*;

import com.harush.zitoon.quoridor.ui.model.HumanPlayer;
import com.harush.zitoon.quoridor.ui.model.Tile;
import org.junit.Before;
import org.junit.Test;

public class HumanPlayerTest {

	private Tile tile;
	private HumanPlayer player;
	
	/**
	 * Initiates new Player instance.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		tile = new Tile(2, 5);		
		player = new HumanPlayer("TestPlayer", "#ffffff");
	}
	
	/**
	 * Tests getName method.
	 */
	@Test
	public void TestGetName() {
		assertEquals("TestPlayer", player.getName());
	}
	
	
}
