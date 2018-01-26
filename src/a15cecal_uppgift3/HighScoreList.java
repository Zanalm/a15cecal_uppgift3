package a15cecal_uppgift3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HighScoreList implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<HighScoreItem> list = new ArrayList<HighScoreItem>();

	private void addTextToFile() {
		try {
			FileWriter writer = new FileWriter("highscorelist.txt");
			for (int i = 0; i < list.size(); i++) {
				writer.write((i + 1) + ". " + list.get(i).getName() + "\t" + list.get(i).getScore() + "\n");
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

	// called for when user chooses option 2
	public void showHighScores() {
		System.out.println("---The highscore list---");
		for (int i = 0; i < list.size(); i++) {
			System.out
					.println((i + 1) + ". " + list.get(i).getName() + "\t" + list.get(i).getScore());
		}

	}

	private void fillInUnknownPlayer() {

		try {
			FileWriter writer = new FileWriter("highscorelist.txt");
			for (int i = 0; i < 5; i++) {
				list.add(new HighScoreItem("unknown", 0));
				writer.write((i + 1) + ". " + list.get(i).getName() + "\t" + list.get(i).getScore());
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
		// addTextToFile();

		System.out.println("The high score list was reset");

	}

	HighScoreList() {
		// getHighScoresFromFile();
	}
}