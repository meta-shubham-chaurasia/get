package hello;

import java.io.*;
import java.util.*;
import java.util.HashMap; 
import java.util.Map; 

class Item{
	public static HashMap<String, Integer> map1 = new HashMap<>(); //Item Name and their Price
		Item(){
		map1.put("Vegetables",100);
		map1.put("Fruits",200);
		map1.put("Furniture", 500);
		}
}
class Cart extends Item{
	Cart(){
		super();	//Base Class Constructor
	}
	public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
	public static HashMap<String, Integer> cart = new HashMap<>(); // Item Name and Quantity
	public void Add_Item() throws IOException{
		System.out.println(map1);
		System.out.println("Enter the item name you wish to add");
		String Item_Name=br.readLine();
		if(map1.containsKey(Item_Name)){
			System.out.println("Enter the quantity");
			int Item_Quantity=Integer.parseInt(br.readLine());
			cart.put(Item_Name,Item_Quantity);
		}
		else{
			System.out.println("We don`t have this item currently");
		}
		System.out.println("Do you wish to add more items");
			//br.readLine();
			String choice=br.readLine(); 
			if(choice.equals("yes")){
				Add_Item();
			}
	}
	public void Item_Update() throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the item you want to update");
			String name=br.readLine();
		System.out.println("Enter the updated quantity");
			int temp=Integer.parseInt(br.readLine());
			if (cart.containsKey(name)) {
				cart.put(name,temp);
			}
		System.out.println("Do you wish to update more items");
			String choice=br.readLine();
			if(choice.equals("yes")){
				Item_Update();
			}
	}
	public void Display_Item(){
		int amount=0;
		for (Map.Entry<String,Integer> entry : cart.entrySet()) { 
			if(entry.getValue()>0){
            System.out.println("Item name = " + entry.getKey() + 
                             ", Item Quantity = " + entry.getValue() + 
                             ", Total Price = "+ map1.get(entry.getKey())*entry.getValue()); 
		amount+=map1.get(entry.getKey())*entry.getValue();
			}
		}
		System.out.println("Total Cart Amount = " +amount);
	}
	public static void main(String args[])throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		Cart c1=new Cart();
			c1.Add_Item();
		System.out.println("Do u wish to update any item");
		String ch=br.readLine();
		if(ch.equals("yes")){
			c1.Item_Update();
		}
			c1.Display_Item();
	}
}