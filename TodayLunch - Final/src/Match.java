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
		double maxweight = -999.0;
		double mindist = 999.0;
		ArrayList<Double> weights = new ArrayList<Double>();
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isRice())),(double)u.isRice()));
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isSoup())),(double)u.isSoup()));
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isNoodle())),(double)u.isNoodle()));;
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isBread())),(double)u.isBread()));
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isMeat())),(double)u.isMeat()));
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isSpicy())),(double)u.isSpicy()));
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isOily())),(double)u.isOily()));
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isHot())),(double)u.isHot()));
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isSober())),(double)u.isSober()));
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isNation())),(double)u.isNation()));
		weights.add(Math.copySign(Math.sqrt(Math.abs((double) u.isFastFood())),(double)u.isFastFood()));

		for (Double a : weights) {

			if (Math.abs(a) > maxweight) {
				maxweight = Math.abs(a);
			}
		}

		for (int i = 0; i < weights.size(); i++) {
			weights.set(i, weights.get(i) / maxweight);
			System.out.printf("%f ", weights.get(i));
		}
		System.out.printf("\n");
		double distance = 0;

		
		
		for (int i = 0; i < start.ml.getNumberOfItem(); i++) {
			Menu m = start.ml.getItem(i);
			distance = 	(Math.sqrt(Math.abs(weights.get(0)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isRice() -weights.get(0))-1,2),Math.abs(m.isRice() -weights.get(0))-1)) + 
						(Math.sqrt(Math.abs(weights.get(1)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isSoup() -weights.get(1))-1,2),Math.abs(m.isSoup() -weights.get(1))-1)) + 
						(Math.sqrt(Math.abs(weights.get(2)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isNoodle() -weights.get(2))-1,2),Math.abs(m.isNoodle() -weights.get(2))-1)) + 
						(Math.sqrt(Math.abs(weights.get(3)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isBread() -weights.get(3))-1,2),Math.abs(m.isBread() -weights.get(3))-1)) + 
						(Math.sqrt(Math.abs(weights.get(4)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isMeat() -weights.get(4))-1,2),Math.abs(m.isMeat() -weights.get(4))-1)) + 
						(Math.sqrt(Math.abs(weights.get(5)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isSpicy() -weights.get(5))-1,2),Math.abs(m.isSpicy() -weights.get(5))-1)) + 
						(Math.sqrt(Math.abs(weights.get(6)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isOily() -weights.get(6))-1,2),Math.abs(m.isOily() -weights.get(6))-1)) + 
						(Math.sqrt(Math.abs(weights.get(7)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isHot() -weights.get(7))-1,2),Math.abs(m.isHot() -weights.get(7))-1)) + 
						(Math.sqrt(Math.abs(weights.get(8)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isSober() -weights.get(8))-1,2),Math.abs(m.isSober() -weights.get(8))-1)) + 
						(Math.sqrt(Math.abs(weights.get(9)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isNation() -weights.get(9))-1,2),Math.abs(m.isNation() -weights.get(9))-1)) + 
						(Math.sqrt(Math.abs(weights.get(10)))+0.2) * (Math.copySign(Math.pow(Math.abs(m.isFastFood() -weights.get(10))-1,2),Math.abs(m.isFastFood() -weights.get(10))-1)); 
						

			System.out.printf("메뉴 %s : 거리 %f", m.getName(), distance);
			System.out.printf(", %f, ",Math.sqrt(Math.abs(weights.get(0))) * (Math.copySign(Math.pow(Math.abs(m.isRice() -weights.get(0))-1,2),Math.abs(m.isRice() -weights.get(0))-1)));
			System.out.printf("%f, ",Math.sqrt(Math.abs(weights.get(1))) * (Math.copySign(Math.pow(Math.abs(m.isSoup() -weights.get(1))-1,2),Math.abs(m.isSoup() -weights.get(1))-1)));
			System.out.printf("%f, ",Math.sqrt(Math.abs(weights.get(2))) * (Math.copySign(Math.pow(Math.abs(m.isNoodle() -weights.get(2))-1,2),Math.abs(m.isNoodle() -weights.get(2))-1)));
			System.out.printf("%f, ",Math.sqrt(Math.abs(weights.get(3))) * (Math.copySign(Math.pow(Math.abs(m.isBread() -weights.get(3))-1,2),Math.abs(m.isBread() -weights.get(3))-1)));
			System.out.printf("%f, ",Math.sqrt(Math.abs(weights.get(4))) * (Math.copySign(Math.pow(Math.abs(m.isMeat() -weights.get(4))-1,2),Math.abs(m.isMeat() -weights.get(4))-1)));
			System.out.printf("%f, ",Math.sqrt(Math.abs(weights.get(5))) * (Math.copySign(Math.pow(Math.abs(m.isSpicy() -weights.get(5))-1,2),Math.abs(m.isSpicy() -weights.get(5))-1)));
			System.out.printf("%f, ",Math.sqrt(Math.abs(weights.get(6))) * (Math.copySign(Math.pow(Math.abs(m.isOily() -weights.get(6))-1,2),Math.abs(m.isOily() -weights.get(6))-1)));
			System.out.printf("%f, ",Math.sqrt(Math.abs(weights.get(7))) * (Math.copySign(Math.pow(Math.abs(m.isHot() -weights.get(7))-1,2),Math.abs(m.isHot() -weights.get(7))-1)));
			System.out.printf("%f, ",Math.sqrt(Math.abs(weights.get(8))) * (Math.copySign(Math.pow(Math.abs(m.isSober() -weights.get(8))-1,2),Math.abs(m.isSober() -weights.get(8))-1)));
			System.out.printf("%f, ",Math.sqrt(Math.abs(weights.get(9))) * (Math.copySign(Math.pow(Math.abs(m.isNation() -weights.get(9))-1,2),Math.abs(m.isNation() -weights.get(9))-1)));
			System.out.printf("%f\n",Math.sqrt(Math.abs(weights.get(10))) * (Math.copySign(Math.pow(Math.abs(m.isFastFood() -weights.get(10))-1,2),Math.abs(m.isFastFood() -weights.get(10))-1))); 
			
			
			if (distance < mindist && !u.notProper(m)) {
				mindist = distance;
				menu = i;
			}
		}

		
		u.addProper(start.ml.getItem(menu));
		return menu;
	}

}
