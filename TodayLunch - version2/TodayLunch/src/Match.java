import java.util.Scanner;
import java.security.SecureRandom;


public class Match {

	
	private MenuList myMenu = new MenuList();
	private QuestionList myQuestion = new QuestionList();
	private Attribute user = new Attribute();
	private int choice;
	private static Scanner input = new Scanner(System.in);
	private static final SecureRandom random = new SecureRandom();
	
	private int q_cnt, Max_cnt;
	
	public void randomdraw(int i)
	{
		q_cnt = 0;
		Max_cnt = i;
		
		while(true)
		{
			
			int number = random.nextInt(5);
			printQuestion(number);
			if(q_cnt == Max_cnt)
				break;
		}
		
		
		
	}
	
	
	public void printQuestion(int i)
	{
		Question q = myQuestion.getItem(i);
		
		if(q.getFlg())
			return;
		
		do{
			System.out.println(q.getQuestion());
			System.out.println("1. yse, 2. no");
			choice = input.nextInt();
			if(choice != 2 && choice != 1)
				System.out.println("please Input 1 or 2");
		}while(choice != 2 && choice != 1);
		
		if(choice == 1)
		{
			user.setBread(user.isBread() + q.isBread());
			user.setFastFood(user.isFastFood() + q.isFastFood());
			user.setHot(user.isHot() + q.isHot());
			user.setMeat(user.isMeat() + q.isMeat());
			user.setNation(user.isNation() + q.isNation());
			user.setNoodle(user.isNoodle() + q.isNoodle());
			user.setOily(user.isOily() + q.isOily());
			user.setRice(user.isRice() + q.isRice());
			user.setSober(user.isSober() + q.isSober());
			user.setSoup(user.isSoup() + q.isSoup());
			user.setSpaicy(user.isSpaicy() + q.isSpaicy());
		}
		
		else if(choice == 2)
		{
			user.setBread(user.isBread() - q.isBread());
			user.setFastFood(user.isFastFood() - q.isFastFood());
			user.setHot(user.isHot() - q.isHot());
			user.setMeat(user.isMeat() - q.isMeat());
			user.setNation(user.isNation() - q.isNation());
			user.setNoodle(user.isNoodle() - q.isNoodle());
			user.setOily(user.isOily() - q.isOily());
			user.setRice(user.isRice() - q.isRice());
			user.setSober(user.isSober() - q.isSober());
			user.setSoup(user.isSoup() - q.isSoup());
			user.setSpaicy(user.isSpaicy() - q.isSpaicy());
		}
		
		q.setFlgTrue();
		q_cnt++;
	}
	
	
}
