import java.util.ArrayList;

public class User extends Attribute {

	private ArrayList<Integer> usedQ = new ArrayList<Integer>();

	private int max_att;

	public void showWeight() {
		System.out.printf(
				"현재 가중치, 밥 : %d, 국 : %d, 면 : %d, 빵 : %d, 고기 : %d, 매움 : %d, 느끼 : %d, 뜨겁 : %d, 해장 : %d, 한국 : %d, 빠름 : %d\n",
				isRice(), isSoup(), isNoodle(), isBread(), isMeat(), isSpicy(), isOily(), isHot(), isSober(),
				isNation(), isFastFood());
	}

	public void addUsedQ(int i) {
		usedQ.add(i);
	}

	public boolean checkUsedQ(int i) {
		return usedQ.contains(i);
	}

	public void increaseBread(int i) {
		super.setBread(super.isBread() + i);
	}

	public void increaseFastFood(int i) {
		super.setFastFood(super.isFastFood() + i);
	}

	public void increaseHot(int i) {
		super.setHot(super.isHot() + i);
	}

	public void increaseMeat(int i) {
		super.setMeat(super.isMeat() + i);
	}

	public void increaseNation(int i) {
		super.setNation(super.isNation() + i);
	}

	public void increaseNoodle(int i) {
		super.setNoodle(super.isNoodle() + i);
	}

	public void increaseOily(int i) {
		super.setOily(super.isOily() + i);
	}

	public void increaseRice(int i) {
		super.setRice(super.isRice() + i);
	}

	public void increaseSober(int i) {
		super.setSober(super.isSober() + i);
	}

	public void increaseSoup(int i) {
		super.setSoup(super.isSoup() + i);
	}

	public void increaseSpicy(int i) {
		super.setSpicy(super.isSpicy() + i);
	}

	public void decreaseBread(int i) {
		super.setBread(super.isBread() - i);
	}

	public void decreaseFastFood(int i) {
		super.setFastFood(super.isFastFood() - i);
	}

	public void decreaseHot(int i) {
		super.setHot(super.isHot() - i);
	}

	public void decreaseMeat(int i) {
		super.setMeat(super.isMeat() - i);
	}

	public void decreaseNation(int i) {
		super.setNation(super.isNation() - i);
	}

	public void decreaseNoodle(int i) {
		super.setNoodle(super.isNoodle() - i);
	}

	public void decreaseOily(int i) {
		super.setOily(super.isOily() - i);
	}

	public void decreaseRice(int i) {
		super.setRice(super.isRice() - i);
	}

	public void decreaseSober(int i) {
		super.setSober(super.isSober() - i);
	}

	public void decreaseSoup(int i) {
		super.setSoup(super.isSoup() - i);
	}

	public void decreaseSpicy(int i) {
		super.setSpicy(super.isSpicy() - i);
	}
}
