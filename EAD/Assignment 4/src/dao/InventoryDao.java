package dao;

import utility.Connect_db;
import pojo.Inventory;

import java.util.*;
import java.sql.*;
public class InventoryDao {

	Connection con=null;
	PreparedStatement preparestatement=null;
	public ArrayList <Inventory>getInventory(){
		ArrayList<Inventory> inventoryList=new ArrayList<>();
		String queryToFetchInventory="select * from FruitTable";
		try{
			con=Connect_db.getConnection();
			preparestatement=con.prepareStatement(queryToFetchInventory);
			ResultSet rs= preparestatement.executeQuery();
			while(rs.next()){
				Inventory inv=new Inventory();
				inv.setName(rs.getString(1));
				inv.setQuantity(rs.getInt(2));
				inventoryList.add(inv);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return inventoryList;
	}
	
	public Inventory getInventoryFruit(String name){
		Inventory inventory=new Inventory();
		String queryToFetchInventory="select * from FruitTable where name=(?)";
		try{
			con=Connect_db.getConnection();
			preparestatement=con.prepareStatement(queryToFetchInventory);
			preparestatement.setString(1, name);
			ResultSet rs= preparestatement.executeQuery();
			while(rs.next()){
				inventory.setName(rs.getString(1));
				inventory.setQuantity(rs.getInt(2));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return inventory;
	}
	
	public void addInventoryFruit(Inventory inventory){
		String queryToAddInInventory="insert into FruitTable values(?,?)";
		try{
			con=Connect_db.getConnection();
			preparestatement=con.prepareStatement(queryToAddInInventory);
			preparestatement.setString(1, inventory.getName());
			preparestatement.setInt(2, inventory.getQuantity());
			preparestatement.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void updateInventoryFruit(String name, Inventory inventory){
		String queryToUpdateInInventory="update FruitTable set name=?,quantity=? where name=?";
		try{
			con=Connect_db.getConnection();
			preparestatement=con.prepareStatement(queryToUpdateInInventory);
			preparestatement.setString(1, inventory.getName());
			preparestatement.setInt(2, inventory.getQuantity());
			preparestatement.setString(3, name);
			preparestatement.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void DeleteInventoryFruit(String name) {
		String queryToDeleteInInventory="delete from FruitTable where name=?";
		try{
			con=Connect_db.getConnection();
			preparestatement=con.prepareStatement(queryToDeleteInInventory);
			preparestatement.setString(1, name);
			preparestatement.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void DeleteInventory() {
		String queryToDeleteInventory="truncate FruitTable";
		try{
			con=Connect_db.getConnection();
			preparestatement=con.prepareStatement(queryToDeleteInventory);
			preparestatement.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public ArrayList<Inventory> replaceInventory(ArrayList<Inventory> inventory) {
		for(Inventory inv:inventory){
			String queryToAddInInventory="insert into FruitTable values(?,?)";
			try{
				con=Connect_db.getConnection();
				preparestatement=con.prepareStatement(queryToAddInInventory);
				preparestatement.setString(1, inv.getName());
				preparestatement.setInt(2, inv.getQuantity());
				preparestatement.executeUpdate();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		return inventory;
	}
}
