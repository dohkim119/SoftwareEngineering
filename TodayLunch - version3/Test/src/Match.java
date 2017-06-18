import java.util.ArrayList;
import java.util.Scanner;
import java.security.SecureRandom;

public class Match {

	// private MenuList myMenu = new MenuList();
	// private QuestionList myQuestion = new QuestionList();
	// private User user = new User();
	// private int choice;
	private static Scanner input = new Scanner(System.in);
	private static final SecureRandom random = new SecureRandom();

	private int q_cnt, Max_cnt;

	public int selectQestion(User u) {
		Question q;
		Max_cnt = start.ql.getNumberOfItem();
		int number = random.nextInt(Max_cnt);

		while (u.checkUsedQ(number)) {
			number = random.nextInt(Max_cnt);
		}
		u.addUsedQ(number);

		q = start.ql.getItem(number);

		return number;
	}

	public boolean processAnswer(int i, int choice, User user) {

		Question q = start.ql.getItem(i);

		System.out.printf("선택된 질문 : %s, 답변 %d,\n", q.question, choice);
		q.showQuestion();

		if (choice == 1) {
			user.increaseRice(q.isRice());
			user.increaseSoup(q.isSoup());
			user.increaseNoodle(q.isNoodle());
			user.increaseBread(q.isBread());
			user.increaseMeat(q.isMeat());
			user.increaseSpicy(q.isSpicy());
			user.increaseOily(q.isOily());
			user.increaseHot(q.isHot());
			user.increaseSober(q.isSober());
			user.increaseNation(q.isNation());
			user.increaseFastFood(q.isFastFood());

		}

		else if (choice == 2) {

			user.decreaseRice(q.isRice());
			user.decreaseSoup(q.isSoup());
			user.decreaseNoodle(q.isNoodle());
			user.decreaseBread(q.isBread());
			user.decreaseMeat(q.isMeat());
			user.decreaseSpicy(q.isSpicy());
			user.decreaseOily(q.isOily());
			user.decreaseHot(q.isHot());
			user.decreaseSober(q.isSober());
			user.decreaseNation(q.isNation());
			user.decreaseFastFood(q.isFastFood());

		}

		if (questionEnd(user)) {
			return true;
		}
		return false;

	}

	public boolean questionEnd(User u) {
		return false;
	}

	public int resultMenu(User u) {
		int menu = 0;
		int cnt = 0;
		double maxweight = -999.0;
		int maxindex;
		double mindist = 999.0;
		ArrayList<Double> weights = new ArrayList<Double>();
		weights.add((double) u.isRice());
		weights.add((double) u.isSoup());
		weights.add((double) u.isNoodle());
		weights.add((double) u.isBread());
		weights.add((double) u.isMeat());
		weights.add((double) u.isSpicy());
		weights.add((double) u.isOily());
		weights.add((double) u.isHot());
		weights.add((double) u.isSober());
		weights.add((double) u.isNation());
		weights.add((double) u.isFastFood());

		for (Double a : weights) {

			if (a > maxweight) {
				maxweight = a;
				// maxindex = cnt;
			}
			// cnt++;
		}

		for (int i = 0; i < weights.size(); i++) {
			weights.set(i, weights.get(i) / maxweight);
			System.out.printf("%f ", weights.get(i));
		}

		double distance = 0;

		for (int i = 0; i < start.ml.getNumberOfItem(); i++) {
			Menu m = start.ml.getItem(i);
			distance = Math.abs(m.isRice() - weights.get(0)) + Math.abs(m.isSoup() - weights.get(1))
					+ Math.abs(m.isNoodle() - weights.get(2)) + Math.abs(m.isBread() - weights.get(3))
					+ Math.abs(m.isMeat() - weights.get(4)) + Math.abs(m.isSpicy() - weights.get(5))
					+ Math.abs(m.isOily() - weights.get(6)) + Math.abs(m.isHot() - weights.get(7))
					+ Math.abs(m.isSober() - weights.get(8)) + Math.abs(m.isNation() - weights.get(9))
					+ Math.abs(m.isFastFood() - weights.get(10));

			System.out.printf("메뉴 %s : 거리 %f\n", m.getName(), distance);

			if (distance < mindist) {
				mindist = distance;
				menu = i;
			}
		}

		return menu;
	}

}
