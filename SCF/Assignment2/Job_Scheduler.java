package hello;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Job_Scheduler {
	
	public void Sorter(int[][] process)
	{
		Arrays.sort(process,new Comparator<int[]>(){
			public int compare(final int[] entry1,final int[] entry2)
			{
				if(entry1[0]>entry2[0])
					return 1;
				else
					return -1;
			}
		});
	}
	
	public void Completion(int[][] process,int number,int[] turnaroundTime,int[] completionTime)
	{
		for(int i=0;i<number;i++)
		{
			completionTime[i]=turnaroundTime[i]+process[i][0];
		}
	}
	
	public void Waiting(int[][] process,int[] waitingTime,int number)
	{
		waitingTime[0]=0;
		for(int i=1;i<number;i++)
		{
			waitingTime[i]=waitingTime[i-1]+process[i-1][1]+process[i-1][0];
			waitingTime[i]=waitingTime[i]-process[i][0];
		}
	}
	
	public void Turnaround(int[][] process,int[] waitingTime,int number,int[] turnaroundTime)
	{
		for(int i=0;i<number;i++)
		{
			turnaroundTime[i]=waitingTime[i]+process[i][1];
		}
	}
	
	public float AvgwaitingTime(int[] waitingTime,int number)
	{
		float avg=0;
		for(int i=0;i<number;i++)
		{
			avg=avg+waitingTime[i];
		}
		
		avg=avg/number;
		return avg;
	}
	
	public int Maxwaiting(int[] waitingTime,int number)
	{
		int maxi=waitingTime[0];
		for(int i=1;i<number;i++)
		{
			if(waitingTime[i]>maxi)
				maxi=waitingTime[i];
		}
		
		return maxi;
	}	
	
	public void Display(int[] arr,int number)
	{
		for(int i=0;i<number;i++)
		{
			System.out.println("For "+(i+1)+"th process,it is "+arr[i]+" units\n");
		}
		System.out.println();
	}

}

class Tester
{
	public static void main(String args[])throws IOException
	{
		Job_Scheduler job=new Job_Scheduler();
		System.out.println("Enter the number of processes that you want to give");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		int number=Integer.parseInt(br.readLine());
		
		int[] waitingTime=new int[number];
		int[] turnaroundTime=new int[number];
		int[] completionTime=new int[number];
		int[][] process=new int[number][2] ;
		
		for(int i=0;i<number;i++)
		{
			System.out.println("Enter the arrival time of "+(i+1)+"th process");
			try{
			process[i][0]=Integer.parseInt(br.readLine());
			}
			catch(Exception e){
				System.out.println("Invalid input");
				i=i-1;
				continue;
			}
			System.out.println("Enter the burst time of "+(i+1)+"th process");
			try{
			process[i][1]=Integer.parseInt(br.readLine());
			}
			catch(Exception e)
			{
				System.out.println("Invalid input");
				i=i-1;
				continue;
			}
		}
		job.Sorter(process);
		
		System.out.println("\n--WAITING TIME--");
		job.Waiting(process,waitingTime,number);
		job.Display(waitingTime,number);
		
		System.out.println("--TURN AROUND TIME--");
		job.Turnaround(process,waitingTime,number,turnaroundTime);
		job.Display(turnaroundTime,number);
		
		System.out.println("--COMPLETION TIME--");
		job.Completion(process,number,turnaroundTime,completionTime);
		job.Display(completionTime,number);
		
		System.out.println("--AVG. WAITING TIME--");
		float res=job.AvgwaitingTime(waitingTime,number);
		System.out.println("The avg waiting time is: "+res+" units\n");
		
		System.out.println("--MAX. WAITING TIME--");
		int res2=job.Maxwaiting(waitingTime,number);
		System.out.println("The max waiting time is: "+res2+" units\n");
		}
		catch(Exception e){
			System.out.println("Invalid input");
		}
	}
}

