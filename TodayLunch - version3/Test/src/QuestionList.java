import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionList {
	private ArrayList<Question> qlist = new ArrayList<Question>();
	private static Scanner input;

	public QuestionList() {
		try {
			File file = new File("question.txt");
			input = new Scanner(file);

			while (input.hasNext()) {
				String line = input.nextLine();
				String[] split = line.split("-");
				String[] split2 = split[0].split("");

				String name = split[1];
				int rice = Integer.parseInt(split2[0]);
				int soup = Integer.parseInt(split2[1]);
				int noodle = Integer.parseInt(split2[2]);
				int bread = Integer.parseInt(split2[3]);
				int meat = Integer.parseInt(split2[4]);
				int spicy = Integer.parseInt(split2[5]);
				int oily = Integer.parseInt(split2[6]);
				int hot = Integer.parseInt(split2[7]);
				int sober = Integer.parseInt(split2[8]);
				int notkorean = Integer.parseInt(split2[9]);
				int fastfood = Integer.parseInt(split2[10]);

				Question question = new Question(name, rice, soup, noodle, bread, meat, spicy, oily, hot, sober,
						notkorean, fastfood);

				qlist.add(question);
			}

		}

		catch (IllegalStateException e) {
			System.err.println("IllegalStateException");
			System.exit(1);
		}

		catch (IOException e) {
			System.err.printf("IOException %s", e.getMessage());
			System.exit(1);
		}

		catch (NoSuchElementException e) {
			System.err.printf("NoSuchElementException %s", e.getMessage());
			System.exit(1);
		}

		if (input != null) {
			input.close();

		}
	}

	public int getNumberOfItem() {
		return qlist.size();
	}

	public Question getItem(int i) {
		return qlist.get(i);
	}

	public void setItem(Question element) {
		qlist.add(element);
	}

	public void listItem() {
		for (Question myquestion : qlist) {
			myquestion.showQuestion();
		}
	}
}