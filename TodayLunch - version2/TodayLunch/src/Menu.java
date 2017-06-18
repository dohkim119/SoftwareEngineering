
public class Menu extends Attribute {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Menu(String name, 
			int spaicy, int rice, int noodle, int soup,
			int bread,int meat,int oily,int sober,int hot,int nation,int fastFood)
	{
		
		this.name = name;
		
		super.setSpaicy(spaicy);
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
	
}
