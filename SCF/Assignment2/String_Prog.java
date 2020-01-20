package hello;
import java.io.*;
import java.util.*;
public class String_Prog {

	/**
	 * Comparing Strings
	 * @param str1 First Input String
	 * @param str2 Second Input String
	 * @return 0 & 1 Based on String Equality
	 */
	public static int String_Compare(String str1,String str2){
		int equals=1;
		if(str1.length()!=str2.length()){
			equals=0;
			return equals;
		}
		else{
			char s1[]=str1.toCharArray();
			char s2[]=str2.toCharArray();
			for (int i = 0; i < str1.length(); i++) {
				if(s1[i]!=s2[i]){
					equals=0;
					break;
				}
			}
			return equals;
		}
	}
	/**
	 * Reverse the Input String
	 * @param str1 String to Reverse
	 * @return reversed String
	 */
	public static String String_Reverse(String str1){
		String reverse="";
		char str[]=str1.toCharArray();
		for (int i = str1.length()-1; i >=0 ; i--) {
			reverse+=str[i];
		}
		return reverse;
	}
	/**
	 * Change UpperCase to LowerCase and vice-versa
	 * @param str String Input
	 * @return Final Updated String
	 */
	public static String String_ChangeCase(String str){
		char str1[]=str.toCharArray();
		for (int i= 0; i < str1.length; i++) {
			if(str1[i]>=97&&str1[i]<=122){
				str1[i]=(char)(str1[i]-32);
				
				
			}
			else if(str1[i]>=65&&str1[i]<=90)
				str1[i]=(char)(str1[i]+32);
		}
		String CaseChange=str1.toString();
		return CaseChange;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
		for(int i=1;i>0;i++){
			System.out.println("Enter 1 to Compare\nEnter 2 to reverse\nEnter 3 to Change Case\nEnter 4 to Find Largest Word\nEnter 5 to exit ");
			try{
				int choi=Integer.parseInt(br.readLine());
				if(choi>5){
					System.out.println("Invalid Choice");
				}
				else{
					switch(choi){
						case 1:
							System.out.println("Enter String 1");
							String str1=br.readLine();
							System.out.println("Enter String 2");
							String str2=br.readLine();
							System.out.println(String_Compare(str1,str2));
						break;
						case 2:
							System.out.println("Enter String to reverse");
							String str_rev=br.readLine();
							System.out.println(String_Reverse(str_rev));
						break;
						case 3:
							System.out.println("Enter String to Change Case");
							String str_case=br.readLine();
							System.out.println(String_ChangeCase(str_case));
						break;
						case 4:
						break;
						case 5:i=-1;
						break;
						default:
							System.out.println("Invalid Choice");
						}
					}	
				}
			catch(Exception e){
				System.out.println("Invalid Choice");
			}
		}	
	}

}
