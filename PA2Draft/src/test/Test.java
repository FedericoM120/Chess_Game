package test;

import game.*;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter name for player1 and 2");
		String line = keyboard.nextLine();
		String[] tokens = line.split(" ");
		Game game = new Game(tokens[0], tokens[1]);

		while (true) {
			String player1Move;
			boolean validMove = false;
			while (!validMove) {
				System.out.println("player1 enter your move");
				player1Move = keyboard.nextLine();
				if (player1Move.equals("undo")) {
					if (!game.undo()) {
						System.out.println("Cannot undo!");
					} else {
						game.showBoard(System.out);
					}
				}else if (game.move(new Move(player1Move))) {
					game.showBoard(System.out);
					validMove = true;
				} else {
					System.out.println("Illegal move!");
				}
			}

			String player2Move;
			validMove = false;
			while (!validMove) {
				System.out.println("player2 enter your move");
				player2Move = keyboard.nextLine();
				if (player2Move.equals("undo")) {
					if (!game.undo()) {
						System.out.println("Cannot undo!");
					} else {
						game.showBoard(System.out);
					}
				}else if (game.move(new Move(player2Move))) {
					game.showBoard(System.out);
					validMove = true;
				} else {
					System.out.println("Illegal move!");
				}
			}
			game.showBoard(System.out);
		}
	}
}

