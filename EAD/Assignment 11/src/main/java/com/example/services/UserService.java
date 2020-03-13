package com.example.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daoimpl.UserDaoImpl;
import com.example.models.User;

/**
 * Class to implement User related service
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDaoImpl userDao;

	/**
	 * Function to add new user
	 * @param user
	 * @return id of new user
	 */
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	/**
	 * Function to get user from id
	 * @param userId
	 * @return user
	 */
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	/**
	 * Function to get user from emailId
	 * @param userId
	 * @return user
	 */
	public int getUserId(String emailId) {
		return userDao.getUserId(emailId);
	}

	/**
	 * Function to update user
	 * @param empId
	 * @param user
	 * @return true if updated or false otherwise
	 */
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	/**
	 * Function to get list of all friends
	 * @param empId
	 * @return list of users in same organisation
	 */
	public List<User> getFriends(int empId) {
		return userDao.getFriends(empId);
	}
	
	/**
	 * Function to store address of uploaded profilepicture
	 * @param empId
	 * @param pictureAddress
	 * @return user
	 */
	public User uploadProfilePicture(int empId, String pictureAddress) {
		return userDao.uploadProfilePicture(empId, pictureAddress);
	}
}