package a15cecal_uppgift3;

import java.io.BufferedReader;
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
			// when there's data in the file the program won't start...
			// the list items shows up in different places when more than 2 characters are used in score/name
			FileWriter writer = new FileWriter("highscorelist.txt");
			writer.write("----The saved high score list----" + "\r\n" + "\r\n");
			//writer.write(String.format("   %-7s %-3s%n", "Name", "     Score"));
			for (int i = 0; i < list.size(); i++) {
				writer.write("\n" + (i + 1) + ". " + list.get(i).getName() + "\t" + "\t" + list.get(i).getScore() + "\r\n");
			}

			writer.close();
		} catch (IOException e) {
			System.out.println("Error, could not write stats to the list!" + e.getMessage());
		}
	}

	private void sortHighScores() {
		Collections.sort(list, HighScoreItem.ScoreComparison);

	}

	// Removes objects on place 5 in the list
	private void eraseObjects() {
		if (list.size() > 5) {
			list.remove(5);
		}
	}

	// This is called for when a user chooses option 1
	public void addHighScores() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String inputName;
		int inputScore;
		System.out.print("Enter players name:");
		inputName = scan.nextLine();
		System.out.print("Enter players score:");
		inputScore = scan.nextInt();

		list.add(new HighScoreItem(inputName, inputScore));
		sortHighScores();
		eraseObjects();
		addTextToFile();

		System.out.println(inputName + " with score " + inputScore + " was added to the high score list. ");
	}

	private void getHighScoresFromFile() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("highscorelist.txt"));
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
	public void showHighScores() {
		System.out.println("\n---The highscore list---");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("\n" + (i + 1) + ". " + list.get(i).getName() + "\t\t" + list.get(i).getScore() + "\r\n");
		}

	}

	private void fillInUnknownPlayer() {

		try {
			FileWriter writer = new FileWriter("highscorelist.txt");
			for (int i = 0; i < 5; i++) {
				list.add(new HighScoreItem("unknown", 0));
				writer.write("\n" + (i + 1) + ". " + list.get(i).getName() + "\t\t" + list.get(i).getScore() + "\r\n");
			}

			writer.close();
		} catch (IOException e) {
			System.out.println("Could not find file!" + e.getMessage());
		}
	}

	// This is being used when a user chooses option 3
	public void resetHighScores() {

		list.clear();
		fillInUnknownPlayer();
		addTextToFile();

		System.out.println("The high score list was reset");

	}

	HighScoreList()
	{
 		getHighScoresFromFile();
	}
}