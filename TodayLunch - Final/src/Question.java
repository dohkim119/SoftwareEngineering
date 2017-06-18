
public class Question extends Attribute {

	String question;
	boolean flg;

	public Question(String question, int rice, int soup, int noodle, int bread, int meat, int spaicy, int oily,
			int sober, int hot, int nation, int fastFood) {

		this.question = question;
		flg = false;

		super.setSpicy(spaicy);
		super.setRice(rice);
		super.setNoodle(noodle);
		super.setNation(nation);
		super.setBread(bread);
		super.setFastFood(fastFood);
		super.setHot(hot);
		super.setMeat(meat);
		super.setOily(oily);
		super.setSober(sober);
		super.setSoup(soup);

	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setFlgTrue() {
		flg = true;

	}

	public void setFlgFalse() {
		flg = false;
	}

	public boolean getFlg() {
		return flg;
	}

	public void showQuestion() {
		System.out.printf("%s %d %d %d %d %d %d %d %d %d %d %d\n", this.question, isRice(), isSoup(), isNoodle(),
				isBread(), isMeat(), isSpicy(), isOily(), isHot(), isSober(), isNation(), isFastFood());
	}
}
