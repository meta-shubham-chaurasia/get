package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MarkSheet1 {

	/**
	 * Calculating average of grades of students
	 * @param grades array containing grades of students
	 * @param students number of students
	 * @return average of all grades
	 */
	public double Average(int[] grades,int students) throws ArithmeticException
	{
		if(students<=0)
		{
			throw new ArithmeticException("cannot be negative");
		}
		double avg=0;
		for(int i=0;i<students;i++)
		{
			avg=avg+grades[i];
		}
		avg=avg/students;
		return avg;
	}
	
	/**
	 * Calculating maximum grade from all grades
	 * @param grades array containing grades of students
	 * @param students number of students
	 * @return maximum grade
	 */
	public int MaximumGrade(int[] grades,int students) throws ArithmeticException
	{
		if(students<=0)
		{
			throw new ArithmeticException("cannot be negative");
		}
		int max=0;
		for(int i=0;i<students;i++)
		{
			if(grades[i]>max)
				max=grades[i];
		}
		return max;
	}

	/**
	 * Calculating minimum grade from all grades
	 * @param grades array containing grades of students
	 * @param students number of students
	 * @return minimum grade
	 */
	public int MinimumGrade(int[] grades,int students) throws ArithmeticException
	{
		if(students<=0)
		{
			throw new ArithmeticException("cannot be negative");
		}
		int min=grades[0];
		for(int i=1;i<students;i++)
		{
			if(grades[i]<min)
				min=grades[i];
		}
		return min;
	}
	
	/**
	 * Calculating the percentage of students who passed if their grades are greater than or equal to 40
	 * @param grades array containing grades of students
	 * @param students number of students
	 * @return percentage of students who are passed
	 */
	public double PercentageOfStudentsPassed(int[] grades,int students) throws ArithmeticException
	{
		if(students<=0)
		{
			throw new ArithmeticException("cannot be negative");
		}
		double passed=0;
		for(int i=0;i<students;i++)
		{
			if(grades[i]>=40)
				passed++;
		}
		double percentagePassed=(passed/students)*100;
		return percentagePassed;
	}
	
}

class MarkSheet
{
	public static void main(String args[])throws IOException
	{
		int choice;
		MarkSheet1 op=new MarkSheet1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int z=0;
		l1:
		while(z>-1){
			System.out.println("Enter the number of students");
			try{
				int students=Integer.parseInt(br.readLine());
		
				int[] grades=new int[students];
				for(int i=0;i<students;i++)
				{
					System.out.println("Enter the grade");
					grades[i]=Integer.parseInt(br.readLine());
				}
				for(int i=1;i>0;i++)
				{
					System.out.println("Enter 1 to perform average of all grades,2 for maximum grade,3 for minimum grade,4 for percentage of students passed,5 to stop");
		
					choice=Integer.parseInt(br.readLine());
					switch(choice)
					{
						case 1:try{
							double avg=op.Average(grades,students);
							System.out.println("The average is :"+avg+"\n");	
						}
						catch(ArithmeticException e){
							System.out.println("invalid");
						}
							break;
						case 2:try{
							int max=op.MaximumGrade(grades,students);
							System.out.println("The maximum grade is :"+max+"\n");
						}
						catch(ArithmeticException e){
							System.out.println("invalid");
						}
							break;	
						case 3:try{
							int min=op.MinimumGrade(grades,students);
							System.out.println("The minimum grade is :"+min+"\n");
						}
						catch(ArithmeticException e){
							System.out.println("invalid");
						}
							break;	
						case 4:try{
							double percentagePassed=op.MaximumGrade(grades,students);
							System.out.println("The percentage of students who passed is :"+percentagePassed+"\n");	
						}
						catch(ArithmeticException e){
							System.out.println("invalid");
						}
							break;
						case 5:i=-1;
							break;
						default:System.out.println("INVALID CHOICE");	
					}
				}
			}
			catch(Exception e){
				System.out.println("Invalid");
				continue l1;
			}
		}
	}
}
