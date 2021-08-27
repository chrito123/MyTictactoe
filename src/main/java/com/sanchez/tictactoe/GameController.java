package com.sanchez.tictactoe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

	@GetMapping("/tictactoe")
	public String move(@RequestParam(value = "row", required = true) Integer row,
			@RequestParam(value = "col", required = true) Integer col) {
		
		return null;

	}
}
