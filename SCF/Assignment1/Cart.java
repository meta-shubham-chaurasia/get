package hello;

import java.io.*;
import java.util.*;
import java.util.HashMap; 
import java.util.Map; 

class Item{
	public static HashMap<String, Double> map1 = new HashMap<>(); //Item Name and their Price
		Item(){
		map1.put("vegetables",100.00);
		map1.put("fruits",200.00);
		map1.put("furniture", 500.00);
		}
}
class Cart extends Item{
	Cart(){
		super();	//Base Class Constructor
	}
	public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
	public static HashMap<String, Double> cart = new HashMap<>(); // Item Name and Quantity
	public void Add_Item() throws IOException{
		try{
		//System.out.println(map1);
		System.out.println("Enter the item name you wish to add");
		String Item_Name=br.readLine().toLowerCase();
		if(map1.containsKey(Item_Name)){
			System.out.println("Enter the quantity");
			double Item_Quantity=Double.parseDouble(br.readLine());
			cart.put(Item_Name,Item_Quantity);
		}
		else{
			System.out.println("We don`t have this item currently");
		}
		/*
		System.out.println("Do you wish to add more items (yes/no)");
			//br.readLine();
			String choice=br.readLine(); 
			if(choice.equalsIgnoreCase("yes")){
				Add_Item();
			}
			else if(choice.equalsIgnoreCase("no")){
				System.out.println("Do u wish to update any item");
				String ch=br.readLine();
				if(ch.equalsIgnoreCase("yes")){
					Item_Update();
				}
				else if(ch.equalsIgnoreCase("no")){
					Display_Item();
				}
				else{
					System.out.println("invalid choice");
				}
			}
			else{
				System.out.println("invalid choice");
			}*/
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	}
	public void Item_Update() throws IOException{
		try{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the item you want to update");
			String name=br.readLine().toLowerCase();
			if (cart.get(name)==null) {
				System.out.println("You don`t have this item in the cart");
			}else{
		System.out.println("Enter the updated quantity");
			double temp=Double.parseDouble(br.readLine());
			if (cart.containsKey(name) && cart.get(name)>0) {
				cart.put(name,temp);
			}
			}
			}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void Display_Item(){
		try{
		double amount=0;
		for (Map.Entry<String,Double> entry : cart.entrySet()) { 
			if(entry.getValue()>0){
            System.out.println("Item name = " + entry.getKey() + 
                             ", Item Quantity = " + entry.getValue() + 
                             ", Total Price = "+ map1.get(entry.getKey())*entry.getValue()); 
		amount+=map1.get(entry.getKey())*entry.getValue();
			}
		}
		System.out.println("Total Cart Amount = " +amount);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String args[])throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		Cart c1=new Cart();
		for (Map.Entry<String,Double> entry : map1.entrySet()) { 
			if(entry.getValue()>0){
            System.out.println("Item name = " + entry.getKey() + 
                             ", Item Price = " + entry.getValue()); 
			}
		}
		//System.out.println(map1.get(""));
		for(int i=1;i>0;i++){
			System.out.println("Enter 1 to add a product\nEnter 2 to update\nEnter 3 to print bill\nEnter 4 to exit ");
			int choi=Integer.parseInt(br.readLine());
			switch(choi){
			case 1:c1.Add_Item();
			break;
			case 2:c1.Item_Update();
			break;
			case 3:c1.Display_Item();
			break;
			case 4:i=-1;
			break;
			default:
				System.out.println("Invalid Choice");
			}
				
		}	
		
		
			
	}
}