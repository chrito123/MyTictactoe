package com.sanchez.tictactoe;

import java.util.Iterator;

public class Game {
	enum Box {
		X, O, EMPTY
	};

	public Box[][] grid = new Box[3][3];
	public Box winner;

	private static Game instance;

	private Game() {
		instance = new Game();
	}

	public String playAt(int row, int col, Box box) throws Exception {
		if (row > 2 || col > 2) {
			throw new Exception("Wrong column or wrong row");
		}
		if (grid[row][col] != Box.EMPTY) {
			throw new Exception("Square @ (" + row + ", " + col + ") is not empty");
		}
		if (box.equals(Box.EMPTY)) {
			throw new Exception("Wrong box, can't play blank");
		}
		grid[row][col] = box;
		return box.toString();
	}

	public boolean isWinner(int row, int col) {
		boolean isWinner = false;
		// check horizontal
		isWinner = (grid[row][0] == grid[row][1]) && (grid[row][1] == grid[row][2]);
		// check vertical
		isWinner |= (grid[0][col] == grid[1][col]) && (grid[1][col] == grid[2][col]);
		// check diagonal
		isWinner |= (grid[0][0] == grid[1][1]) && (grid[1][1] == grid[2][2]);
		isWinner |= (grid[0][2] == grid[1][1]) && (grid[1][1] == grid[2][0]);
		return isWinner;
	}

	public boolean isDraw(int row, int col) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == Box.EMPTY)
					return false;
			}
		}
		return true;
	}

	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}
}
