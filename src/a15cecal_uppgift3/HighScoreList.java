package a15cecal_uppgift3;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HighScoreList {
	private ArrayList<HighScoreItem> list = new ArrayList<HighScoreItem>();

	private void addTextToFile() {
		try {
			FileWriter writer = new FileWriter("highscorelist.txt");
			for (int i = 0; i < list.size(); i++) {
				writer.write((i + 1) + ". " + list.get(i).getName() + " " + list.get(i).getScore() + " \n");
			}

			writer.close();
		} catch (IOException e) {
			System.out.println("Could not write high score to the list" + e.getMessage());
		}
	}

	private void sortHighscores() {
		Collections.sort(list, HighScoreItem.ScoreComparison);

	}

	// Removes objects on place [5] in list
	private void eraseObjects() {
		if (list.size() > 5) {
			list.remove(5);
		}
	}

	// This is called for when a user chooses option 1
	public void addHighscores() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String inputName;
		int inputScore;
		System.out.print("Enter players name: ");
		inputName = scan.nextLine();
		System.out.print("Enter players score: ");
		inputScore = scan.nextInt();

		list.add(new HighScoreItem(inputName, inputScore));
		sortHighscores();
		eraseObjects();
		addTextToFile();

		System.out.println(inputName + " with score " + inputScore + " was added to the list. ");
	}

	private void getHighscoresFromFile() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("Highscorelist.txt"));
			String lines;
			String[] inputFromFile;
			String name;
			String score;
			while ((lines = reader.readLine()) != null) {
				inputFromFile = lines.split("[ ]");
				name = inputFromFile[1];
				score = inputFromFile[2];
				int intScore = Integer.parseInt(score);
				list.add(new HighScoreItem(name, intScore));

			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Could not allocate information from file" + e.getMessage());
		}

	}

	// called for when user chooses option 2
	public void showHighscores() {
		System.out.println("\n---The highscore list---");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ". " + list.get(i).getName() + " " + list.get(i).getScore());
		}

	}

	private void fillInUnknownPlayer() {

		try {
			FileWriter writer = new FileWriter("highscorelist.txt");
			for (int i = 0; i < 5; i++) {
				list.add(new HighScoreItem("unknown", 0));
				writer.write((i + 1) + ". " + list.get(i).getName() + " " + list.get(i).getScore() + "\n");
			}

			writer.close();
		} catch (IOException e) {
			System.out.println("Could not find file!" + e.getMessage());
		}
	}

	// This is being used when a user chooses option 3
	public void resetHighscores() {

		list.clear();
		fillInUnknownPlayer();
		addTextToFile();

		System.out.println("The high score list was reset");

	}

	HighScoreList()
	{
 		getHighscoresFromFile();
	}
}