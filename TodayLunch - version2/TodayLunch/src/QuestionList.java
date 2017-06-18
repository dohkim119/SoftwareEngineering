import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionList {
	private ArrayList <Question> qlist = new ArrayList<Question>();
	private static Scanner input;
	
	
	public QuestionList()
	{
		try
		{
			File file = new File("question.txt");
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
				
				Question question = new Question(name, spaicy, rice, noodle, soup, 
						bread, meat, oily,sober, hot, nation,fastFood);
				
				qlist.add(question);
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
	
	public Question getItem(int i)
	{
		return qlist.get(i);
	}
	
	public void setItem(Question element)
	{
		qlist.add(element);
	}
	
	public void listItem()
	{
		for(Question myquestion : qlist)
		{
			System.out.printf("%s %d %d %d %d %d %d %d %d %d %d %d\n",
					myquestion.getQuestion(),myquestion.isBread(),myquestion.isFastFood(),myquestion.isHot(),myquestion.isMeat(),
					myquestion.isNation(),myquestion.isNoodle(),myquestion.isOily(),myquestion.isRice(),myquestion.isSober(),
					myquestion.isSoup(),myquestion.isSpaicy());
		}
	}
}