package interviewDemo;

public class RunnerClass 
{
	public static void main(String[] args) 
	{
		int a=10;
		
		if(a<18)
		{
			throw new MyException("Not allowed for voting");
		}
		else
		{
			System.out.println("Allowed for voting");
		}
		
		
		
		
	}
	
	
}
