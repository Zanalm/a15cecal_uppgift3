package a15cecal_uppgift3;

import java.util.Scanner;

public class Uppgift3 {
	public static void main(String[] args) {
		HighScoreList game = new HighScoreList();
		Scanner scanInput = new Scanner(System.in);
		int menuOptions = 0;
		System.out.println("Say hello to the high score list!");

		while (menuOptions != 4) {
			System.out.println("\n--------High score menu--------");
			System.out.println("1. Insert new player stats");
			System.out.println("2. Print list");
			System.out.println("3. Reset list");
			System.out.println("4. Quit");
			System.out.print("Please make your decision and press enter: ");

			// creates string in case users type in letters instead of a number (integer)
			String input = scanInput.next();
			try {
				menuOptions = Integer.parseInt(input);
			} catch (Exception e) {
				menuOptions = 0;
				System.out.println("Please enter a number: " + e.getMessage());
			}
			// if user selects 1 it'll be prompted to add a name and a score, see file HighScoreList for more
			switch (menuOptions) {
			case 1:
				game.addHighScores();
				break;
				// 2 will print the whole list
			case 2:
				game.showHighScores();
				break;
				// 3 will reset the list
			case 3:
				game.resetHighScores();
				break;
				// 4 will end the program
			case 4:
				break;
			default:
				System.out.println("Sorry, that's not one of the listed options");
				break;
			}

		}

		scanInput.close();
		System.out.println("Thank you for viewing the stats, see ya later!");
	}

}
