package com.sanchez.tictactoe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanchez.tictactoe.Game;
import com.sanchez.tictactoe.GameState;

@RestController
public class GameController {
	public static final String GAME_STATE = "gameState";
	
	/**
	 * Resets the game to it's initial state, and allows selection of
	 * either play against the computer, or against another human.
	 * 
	 * @param session 
	 * @return Spring framework View name
	 */
	@GetMapping(value = "/tictactoe/start")
	public String reset(
			HttpSession session
			) {
		
		GameState gameState = new GameState();
		putStateInSession(session, gameState);
		
		return "New game started";
	}
	@GetMapping("/tictactoe/move")
	public String move(HttpSession session, @RequestParam(value = "row", required = true) Integer row,
			@RequestParam(value = "col", required = true) Integer col) throws Exception {

		GameState gameState = getStateFromSession(session);
		Game game = gameState.getGame();

		try {
			game.playAt(row, col, gameState.getTurn());
			evaluateBoard(gameState, row, col);
		} catch (Exception e) {
			//throw e;
			gameState.setGameMessage(e.getMessage());
		}
		
		return gameState.getGameMessage().replace(System.lineSeparator(), "<br/>");

	}

	/**
	 * Evaluate the game board to see if a winner can be declared, or if there is a
	 * draw. If neither of these conditions is detected, switch active player.
	 * 
	 * @param gameState
	 * @param col
	 * @param row
	 */
	public void evaluateBoard(GameState gameState, Integer row, Integer col) {
		Game game = gameState.getGame();

		// First, check for a draw
		if (game.isDraw()) {
			gameState.setGameMessage("It's a draw!");
		} else if (game.isWinner(row, col)) {
			gameState.setGameMessage(gameState.getTurn().getWinMessage());
		} else {
			gameState.setTurnMessage(gameState.getTurn().setTurnMessage());
			gameState.setTurn(gameState.getTurn().setTurn());
			gameState.setGameMessage(gameState.toString());
		}
	}

	private GameState getStateFromSession(HttpSession session) {
		GameState gameState = (GameState) session.getAttribute(GAME_STATE);
		if (gameState == null) {
			gameState = new GameState();
			putStateInSession(session, gameState);
		}
		return gameState;
	}

	/**
	 * method to save game state in session.
	 * 
	 * @param session
	 */
	private void putStateInSession(HttpSession session, GameState gameState) {
		session.setAttribute(GAME_STATE, gameState);
	}
}
