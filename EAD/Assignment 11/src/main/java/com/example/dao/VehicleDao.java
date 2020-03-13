package com.example.dao;

import com.example.models.User;
import com.example.models.Vehicle;

/**
 * Interface to return vehicle related data 
 *
 */
public interface VehicleDao {
	String insertVehicle = "INSERT INTO Vehicle (vehicleName, type, vehicleNumber, identification, empId, vehicleId, passId) values (?, ?, ?, ?, ?, ?, ?);";
	String selectVehicle = "SELECT * FROM Vehicle where vehicleId = ?";
	String updateVehicle = "UPDATE Vehicle set vehicleName = ?, type = ?, vehicleNumber = ?"
			+ ", identification = ?, passId = ? where vehicleId = ?;";
	String lastRecord = "SELECT MAX(vehicleId) AS id FROM Vehicle";
	String selectVehicleIdByEmpId = "SELECT vehicleId FROM Vehicle where empId = ?";

	/**
	 * Get vehicle fro Id
	 * @param vehicleId
	 * @return vehicle
	 */
	Vehicle getVehicle(int vehicleId);

	/**
	 * Function to add vehicle
	 * @param vehicle
	 * @return id of the vehicle
	 */
	int addVehicle(Vehicle vehicle);

	/**
	 * Function to get vehicle by userId
	 * @param userId
	 * @return
	 */
	Vehicle getVehicleByUser(User user);
	
	/**
	 * Function to update vehicle
	 * @param vehicle
	 * @param vehicleId
	 * @return vehicle
	 */
	Vehicle updateVehicle(Vehicle vehicle);
}