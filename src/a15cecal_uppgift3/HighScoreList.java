package a15cecal_uppgift3;
import java.io.*;

public class HighScoreList {
	public static void main(String[] args) {
		
		// The name of the file to open.
        String fileName = "highscorelist.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("Hi");
            bufferedWriter.write(" I'm dog.");
            bufferedWriter.newLine();
            bufferedWriter.write("I'll be your dog");
            bufferedWriter.write(" for the evening.");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

	}

}