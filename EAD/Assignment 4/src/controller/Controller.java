package controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.InventoryDao;
import pojo.Inventory;

import java.util.*;
import java.util.ArrayList;
@Path("/inventory")
public class Controller {
	InventoryDao inventoryDao=new InventoryDao();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory>displayInventory(){
		return inventoryDao.getInventory();
	}
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Inventory FruitInventory(@PathParam("name") String name)
	{
		return inventoryDao.getInventoryFruit(name);
	}
	
	@POST 
	public Inventory addInventory(Inventory inventory)
	{
		inventoryDao.addInventoryFruit(inventory);
		return inventory;
	}
	
	@PUT
	public ArrayList<Inventory> replaceInventory(ArrayList<Inventory> inventory)
	{
		inventoryDao.DeleteInventory();
		inventoryDao.replaceInventory(inventory);
		return inventory;
	}
	
	@PUT
	@Path("/{name}")
	public Inventory updateInventoryFruit(@PathParam("name") String name, Inventory inventory)
	{
		if(inventoryDao.getInventoryFruit(inventory.getName()).getQuantity()==0){
			inventoryDao.addInventoryFruit(inventory);
		}
		else{
			inventoryDao.updateInventoryFruit(name,inventory);
		}
		return inventory;
	}
	
	@DELETE
	@Path("/{name}")
	public Inventory DeleteFruitInventory(@PathParam("name") String name)
	{
		Inventory inv=inventoryDao.getInventoryFruit(name);
		if(inv.getQuantity()!=0){
			inventoryDao.DeleteInventoryFruit(name);
		}
		return inv;
	}
	
	@DELETE
	public Inventory DeleteInventory(Inventory inventory)
	{
		inventoryDao.DeleteInventory();
		return inventory;
	}
}
