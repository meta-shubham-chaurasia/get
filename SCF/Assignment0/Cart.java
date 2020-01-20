package hello;
import java.io.*;
import java.util.*;


class Item{
	public static HashMap<String, Double> Item_map = new HashMap<>(); //Item Name and their Price
		Item(){
			Item_map.put("vegetables",100.00);
			Item_map.put("fruits",200.00);
			Item_map.put("furniture", 500.00);
		}
}
class Cart extends Item{
	Cart(){
		super();	//Base Class Constructor
	}
	public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
	public static HashMap<String, Double> cart_map = new HashMap<>(); // Item Name and Quantity
	public void Add_Item() throws IOException{
		try{
		//System.out.println(map1);
		System.out.println("Enter the item name you wish to add");
		String Item_Name=br.readLine().toLowerCase();
		if(Item_map.containsKey(Item_Name)){
			System.out.println("Enter the quantity");
			double Item_Quantity=Double.parseDouble(br.readLine());
			if(Item_Quantity>0){
				cart_map.put(Item_Name,Item_Quantity);
			}
			else{
				System.out.println("Invalid Quantity");
			}
		}
		else{
			System.out.println("We don`t have this item currently");
		}
	}
	catch(Exception e){
		System.out.println("Invalid Input");
	}
	}
	public void Item_Update() throws IOException{
		try{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the item you wish to update");
			String name=br.readLine().toLowerCase();
			if (cart_map.get(name)==null) {
				System.out.println("You don`t have this item in the cart");
			}else{
				System.out.println("Enter the updated quantity");
				double temp=Double.parseDouble(br.readLine());
					if (cart_map.containsKey(name) && cart_map.get(name)>0) {
						cart_map.put(name,temp);
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
			for (Map.Entry<String,Double> entry : cart_map.entrySet()) { 
				if(entry.getValue()>0){
	            System.out.println("Item name = " + entry.getKey() + 
	                             ", Item Quantity = " + entry.getValue() + 
	                             ", Total Price = "+ Item_map.get(entry.getKey())*entry.getValue()); 
	            amount+=Item_map.get(entry.getKey())*entry.getValue();
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
		for (Map.Entry<String,Double> entry : Item_map.entrySet()) { 
			if(entry.getValue()>0){
            System.out.println("Item name = " + entry.getKey() + 
                             ", Item Price = " + entry.getValue()); 
			}
		}
		//System.out.println(map1.get(""));
		for(int i=1;i>0;i++){
			System.out.println("Enter 1 to add a product\nEnter 2 to update\nEnter 3 to print bill\nEnter 4 to exit ");
			try{
				int choi=Integer.parseInt(br.readLine());
				if(choi>4){
					System.out.println("Invalid Choice");
				}
				else{
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
			catch(Exception e){
				System.out.println("Invalid Choice");
			}
		}	
	}
}