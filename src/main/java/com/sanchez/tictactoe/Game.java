package com.sanchez.tictactoe;

public class Game {

	public Box[][] grid = new Box[3][3];
	public Box winner;

	private static Game instance;

	private Game() {
		init();
	}

	public void init() {
		for (int r = 0; r < 3; ++r) {
			for (int c = 0; c < 3; ++c) {
				grid[r][c] = Box.EMPTY;
			}
		}
	}

	public String playAt(int row, int col, Box box) throws Exception {
		if (row > 2 || col > 2) {
			throw new Exception("Wrong column or wrong row");
		}
		if (grid[row][col] != Box.EMPTY) {
			throw new Exception("Box (" + row + ", " + col + ") is not empty");
		}
		if (box.equals(Box.EMPTY)) {
			throw new Exception("Wrong box, can't play empty");
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
		// check first diagonal
		if (row == col)
			isWinner |= (grid[0][0] == grid[1][1]) && (grid[1][1] == grid[2][2]);
		// check the second diagonal
		if (row + col == 2)
			isWinner |= (grid[0][2] == grid[1][1]) && (grid[1][1] == grid[2][0]);
		return isWinner;
	}

	public boolean isDraw() {
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

	@Override
	public String toString() {
		StringBuilder response = new StringBuilder();
		for (Box[] row : grid) {
			response.append("---------------" + System.lineSeparator());
			response.append(row[0] + "|" + row[1] + "|" + row[2] + System.lineSeparator());

		}
		response.delete(0, response.indexOf(System.lineSeparator()));
		return response.toString();
	}

}
