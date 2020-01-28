package hello;

public class Search
{
	public int LinearSearch(int arr[],int value,int i)
	{
		int len=arr.length-1;
		if(arr[i]!=value && i<=len)
		{
			return LinearSearch(arr,value,i+1);
		}
		else if(arr[i]==value && i<=len)
		{
			return i;
		}
		else
		{
			return 0;
		}
	} 
	public int BinarySearch(int arr[],int i,int len,int value) 
		{ 
			if(len>=i)
			{ 
				int mid=i+(len-i)/2; 
				if(arr[mid]==value) 
					return mid; 
				else if(arr[mid]>value) 
					return BinarySearch(arr,i,mid-1,value);
				else
				return BinarySearch(arr,mid+1,len,value); 
			} 
			return -1; 
		} 
}
