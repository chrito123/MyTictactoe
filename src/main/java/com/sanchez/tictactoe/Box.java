package com.sanchez.tictactoe;

public enum Box {
	
		X{
            @Override
            public String getWinMessage(){
				return "X player wins!";
			}

			@Override
			public Box setTurn() {
				return Box.O;
			}

			@Override
			public String setTurnMessage() {
				return "Turn: O";
			}
		}, O{
            @Override
            public String getWinMessage(){
				return "O player wins!";
			}

			@Override
			public Box setTurn() {
				return Box.X;
			}

			@Override
			public String setTurnMessage() {
				return "Turn: X";
			}
		}, EMPTY{
            @Override
            public String getWinMessage(){
				return "Can't win";
			}

			@Override
			public Box setTurn() {
				// Tnothing to do cause empty will not change of empty
				return null;
			}

			@Override
			public String setTurnMessage() {
				// Tnothing to do cause empty will not change of empty
				return null;
			}
			@Override
			public String toString() {
				return "&nbsp;&nbsp;&nbsp;";
			}
		};
		public abstract String getWinMessage();
		public abstract Box setTurn();
		public abstract String setTurnMessage();


}
