
public class Menu extends Attribute {

	String name;
	public String fil;
	public String position;
	public String Sname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menu(String name, int rice, int soup, int noodle, int bread, int meat, int spaicy, int oily, int sober,
			int hot, int nation, int fastFood, String fil, String position, String Sname) {

		this.name = name;
		this.fil = fil;
		this.position = position;
		this.Sname = Sname;
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

	public void showMenu() {
		System.out.printf("%s %d %d %d %d %d %d %d %d %d %d %d\n", this.name, isRice(), isSoup(), isNoodle(), isBread(),
				isMeat(), isSpicy(), isOily(), isHot(), isSober(), isNation(), isFastFood());
	}
}
