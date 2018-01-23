package a15cecal_uppgift3;

public class HighScoreItem {
	private String name;
	private int score;
	
	// constructor
		public HighScoreItem(String name, int score) {
			setName(name);
			setScore(score);
		}

		// These are getters and setters for playerName and playerScore
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
}

