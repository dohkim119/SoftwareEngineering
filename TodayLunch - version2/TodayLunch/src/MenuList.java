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

	private ArrayList <Menu> mlist = new ArrayList<Menu>();
	private static Scanner input;
	
	
	public MenuList()
	{
		try
		{
			File file = new File("menu.txt");
			input = new Scanner(file);
			
			while(input.hasNext())
			{
				String name = input.next();
				
				int spaicy = input.nextInt();
				int rice = input.nextInt();
				int noodle = input.nextInt();
				int soup = input.nextInt();
				int bread = input.nextInt();
				int meat = input.nextInt();
				int oily = input.nextInt();
				int sober = input.nextInt();
				int hot = input.nextInt();
				int nation = input.nextInt();
				int fastFood = input.nextInt();
				
				Menu menu = new Menu(name, spaicy, rice, noodle, soup, 
						bread, meat, oily,sober, hot, nation,fastFood);
				
				mlist.add(menu);
			}
			
			
		}
		
		catch(IllegalStateException e)
		{
			System.err.println("IllegalStateException");
			System.exit(1);
		}
		
		catch( IOException e)
		{
			System.err.println("IOException");
			System.exit(1);
		}
		
		catch(NoSuchElementException e)
		{
			System.err.println("NoSuchElementException");
			System.exit(1);
		}
		
		
		if(input != null)
		{
			input.close();
			
		}
		
	}

	public Menu getItem(int i)
	{
		return mlist.get(i);
	}
	
	public void setItem(Menu element)
	{
		mlist.add(element);
	}
	
	public void listItem()
	{
		for(Menu mymenu : mlist)
		{
			System.out.printf("%s %d %d %d %d %d %d %d %d %d %d %d\n",
					mymenu.getName(),mymenu.isBread(),mymenu.isFastFood(),mymenu.isHot(),mymenu.isMeat(),
					mymenu.isNation(),mymenu.isNoodle(),mymenu.isOily(),mymenu.isRice(),mymenu.isSober(),
					mymenu.isSoup(),mymenu.isSpaicy());
		}
		
		
	}
	
}
