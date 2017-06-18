import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MenuList {

	private ArrayList<Menu> mlist = new ArrayList<Menu>();
	private static Scanner input;
	public String fil;
	public String position;
	public String Sname;

	public MenuList() {
		try {
			File file = new File("menu.txt");
			input = new Scanner(file);

			while (input.hasNext()) {
				String line = input.nextLine();
				String[] split = line.split("-");
				String[] split2 = split[0].split("");
				fil = split[2] + ".png";
				position = split[3];
				Sname = split[4];
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

				Menu menu = new Menu(name, rice, soup, noodle, bread, meat, spicy, oily, sober, hot, notkorean,
						fastfood, fil, position, Sname);

				mlist.add(menu);
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
			System.err.println("NoSuchElementException");
			System.exit(1);
		}

		if (input != null) {
			input.close();

		}

	}

	public int getNumberOfItem() {
		return mlist.size();
	}

	public Menu getItem(int i) {
		return mlist.get(i);
	}

	public void setItem(Menu element) {
		mlist.add(element);
	}

	public void listItem() {
		for (Menu mymenu : mlist) {
			mymenu.showMenu();
		}

	}

}
