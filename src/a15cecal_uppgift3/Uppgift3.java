package a15cecal_uppgift3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Uppgift3 {
	static HighScoreList game;

	public static void main(String[] args) {
		Scanner scanInput = new Scanner(System.in);
		int menuOptions = 0;
		game = new HighScoreList();
		System.out.println("Say hello to the high score list!");
		try {
			new FileOutputStream("highscorelist.txt", true).close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (menuOptions != 4) {
			System.out.println("\n--------High score menu--------");
			System.out.println("1. Insert new player stats");
			System.out.println("2. Print list");
			System.out.println("3. Reset list");
			System.out.println("4. Quit");
			System.out.print("Please make your decision and press enter: ");

			// creates string in case users type in letters instead of a number
			// (integer)
			String input = scanInput.next();
			try {
				menuOptions = Integer.parseInt(input);
			} catch (Exception e) {
				menuOptions = 0;
				System.out.println("Please enter a number: " + e.getMessage());
			}
			// if user selects 1 it'll be prompted to add a name and a score,
			// then writes to file
			switch (menuOptions) {
			case 1:
				game.addHighScores();
				writeFile();
				break;
			// reads the file and 2 will print the whole list
			case 2:
				readFile();
				game.showHighScores();
				break;
			// 3 will reset the list
			case 3:
				game.resetHighScores();
				writeFile();
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

	public static void writeFile() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("highscorelist.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(game);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static void readFile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("highscorelist.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			game = (HighScoreList) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
