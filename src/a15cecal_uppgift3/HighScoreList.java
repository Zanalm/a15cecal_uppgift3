package a15cecal_uppgift3;

import java.io.*;
import java.util.Scanner;

public class HighScoreList {
	public static void main(String[] args) {

	}

	public HighScoreItem getItemInfo() {
		// takes input from user and displays it in the console
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name = scanner.next();
		System.out.println("Name: " + name);

		System.out.print("What is the score? ");
		int score = scanner.nextInt();
		System.out.println("Score: " + score);

		HighScoreItem NewItem = new HighScoreItem(name, score);
		return NewItem;
	}

	public void writeFile(HighScoreItem itemToWrite) {
		// The name of the file to save as
		String fileName = "highscorelist.txt";
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(itemToWrite.getName() + "\t" + itemToWrite.getScore());

			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
		}

	}
}