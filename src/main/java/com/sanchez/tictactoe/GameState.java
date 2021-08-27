package com.sanchez.tictactoe;

public class GameState {
	
	private Game game;
	private String xPlayerName;
	private String oPlayerName;
	private String gameMessage;
	private String turnMessage;
	private boolean finished;
	private Box turn;
	
	//class used the save the state of the game
	public GameState()
	{
		game = Game.getInstance();
		game.init();
		init();
	}
	public void init() {
		finished=false;
		setxPlayerName("X Player");
		setoPlayerName("O Player");
		setGameMessage("");
		setTurn(Box.X);
		setTurnMessage("Turn: X");
		
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getxPlayerName() {
		return xPlayerName;
	}

	public void setxPlayerName(String xPlayerName) {
		this.xPlayerName = xPlayerName;
	}

	public String getoPlayerName() {
		return oPlayerName;
	}

	public void setoPlayerName(String oPlayerName) {
		this.oPlayerName = oPlayerName;
	}

	public String getGameMessage() {
		return gameMessage;
	}

	public void setGameMessage(String gameMessage) {
		this.gameMessage = gameMessage;
	}

	public String getTurnMessage() {
		return turnMessage;
	}

	public void setTurnMessage(String turnMessage) {
		this.turnMessage = turnMessage;
	}

	public Box getTurn() {
		return turn;
	}

	public void setTurn(Box turn) {
		this.turn = turn;
	}
	@Override
	public String toString() {
		StringBuilder response = new StringBuilder();
		response.append(game.toString() + System.lineSeparator()).append(getTurnMessage());
		return response.toString();
	}
}
