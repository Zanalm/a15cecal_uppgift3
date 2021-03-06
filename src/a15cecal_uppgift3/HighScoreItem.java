package a15cecal_uppgift3;

import java.io.Serializable;
import java.util.Comparator;

public class HighScoreItem implements Serializable {

	private static final long serialVersionUID = 2L;
	private String playersName;
	private int playersScore;

	public HighScoreItem(String name, int score) {
		playersName = name;
		playersScore = score;

	}

	// Getters
	public String getName() {
		return playersName;
	}

	public int getScore() {
		return playersScore;
	}

	// Method that compares players' score. Used for sortHighScores() in
	// HighScoreList
	public static Comparator<HighScoreItem> ScoreComparison = new Comparator<HighScoreItem>() {
		public int compare(HighScoreItem obj1, HighScoreItem obj2) {
			int scoreNr1 = obj1.getScore();
			int scoreNr2 = obj2.getScore();

			return scoreNr2 - scoreNr1;
		}
	};

	@Override
	public String toString() {
		return (playersName + playersScore);
	}
}
