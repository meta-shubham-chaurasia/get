package hello;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrOperation {

	/**
	 * Calculating the length of largest mirror section in an array of numbers
	 * @param arr array of numbers 
	 * @param n size of array
	 * @return size of largest mirror section
	 */
	public int SizeOfLargestMirror(int[] arr)
	{
		int n=arr.length;
		int[][] lengthSuffix=new int[n+1][n+1];
		int length=0;
		assert(n!=0):"Array empty";
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0||j==0)
					lengthSuffix[i][j]=0;
				else if(arr[i-1]==arr[n-j])
				{
					lengthSuffix[i][j]=lengthSuffix[i-1][j-1]+1;
					length=Math.max(length, lengthSuffix[i][j]);
				}
				else
					lengthSuffix[i][j]=0;
			}
		}
		return length;
	}
	
	/**
	 * Calculating the number of clumps in an array of numbers
	 * @param arr array of numbers 
	 * @param n size of array
	 * @return number of clumps in the array
	 */
	public int NumberOfClumps(int[] arr,int n)
	{
		int current=-1,clump=0;
		assert(n!=0):"Array empty";
		for(int i=0;i<n-1;i++)
		{
			if(arr[i]==arr[i+1]&&arr[i]!=current)
			{
				current=arr[i];
				clump++;
			}
			else
			{
				if(arr[i]!=current)
				{
					current=-1;
				}
			}
		}
		return clump;
	}
	
	/**
	 * Calculating the new array with Y follows X
	 * @param arr array of numbers 
	 * @param n size of array
	 * @param X denotes the value of X
	 * @param Y denotes the value of Y
	 * @return array of numbers with Y follows X
	 */
	public int[] YfollowsX(int[] arr,int n,int X,int Y)
	{
		int[] arr2=new int[n];
		int[] newArr=new int[n];
		int numberOfX=0,numberOfY=0;
		assert(n!=0):"Array empty";
		assert(arr[n-1]!=X):"X cannot be last element";
		for(int i=0;i<n;i++)
		{
			newArr[i]=arr[i];
			if(arr[i]==X)
				numberOfX++;
			if(arr[i]==Y)
				numberOfY++;
		}
		assert(numberOfX==numberOfY):"Unequal number of X and Y in input array";
		for(int i=0;i<n-1;i++)
		{
			if(arr[i]==X&&arr[i+1]==X)
			{
				assert(arr[i]!=arr[i+1]):"Unequal number of X and Y in input array";
				break;
			}
		}
			
		for(int i=0,k=-1;i<n;i++)
		{
			if(newArr[i]!=X&&newArr[i]!=Y)
				arr2[++k]=newArr[i];
		}
		for(int i=0,k=0;i<n;i++)
		{
			if(newArr[i]==X)
				newArr[++i]=Y;
			else
				newArr[i]=arr2[k++];
		}
		return newArr;
	}
	
	/**
	 * Calculating the index in an array of numbers where split can be made such that left sum and right sum are equal
	 * @param arr array of numbers 
	 * @param n size of array
	 * @return index where splitting be made else return -1
	 */
	public int SplitIndex(int[] arr)
	{
		int n=arr.length;
		int sum=0,sum2=0;
		assert(n!=0):"Array empty";
		for(int i=1;i<n;i++)
		{
			sum=sum+arr[i];
		}
		for(int i=0,j=1;j<n;i++,j++)
		{
			sum2=sum2+arr[i];
			if(sum==sum2)
				return (i+1);
			sum=sum-arr[j];
		}
		
		return -1;
	}
	
}

class Driver
{
	public static void main(String args[])throws IOException
	{
		int choice;
		ArrOperation op=new ArrOperation();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of numbers");
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the numbers");
			arr[i]=Integer.parseInt(br.readLine());
		}
		for(int i=1;i>0;i++)
		{
			System.out.println("Enter 1 to perform longest mirror section,2 for number of clumps,3 for XY problem,4 for split array problem,5 to stop");
			choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
				case 1:int lengthOfMirrorSection=op.SizeOfLargestMirror(arr);
					System.out.println("The length of Mirror Section is :"+lengthOfMirrorSection+"\n");				
					break;
					
				case 2:int numberOfClumps=op.NumberOfClumps(arr, n);
					System.out.println("The number of clumps is :"+numberOfClumps+"\n");				
					break;
				
				case 3:System.out.println("Enter value of X");
					int X=Integer.parseInt(br.readLine());
					System.out.println("Enter value of Y");
					int Y=Integer.parseInt(br.readLine());
					int[] newArr=op.YfollowsX(arr, n, X, Y);
					System.out.println("The new array is : ");
					for(int j=0;j<n;j++)
					{
						System.out.println(newArr[j]);
					}
					break;
				
				case 4:int index=op.SplitIndex(arr);
					if(index>-1)
						System.out.println("The splitting index is :"+index+"\n");	
					else
						System.out.println("Not possible");
					break;
				
				case 5:i=-1;				
					break;
				
				default:System.out.println("INVALID CHOICE");
			}
		}
	}
}
