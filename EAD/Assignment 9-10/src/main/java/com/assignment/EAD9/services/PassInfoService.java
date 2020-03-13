package com.assignment.EAD9.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.EAD9.daoimpl.PassInfoDaoImpl;

/**
 * Class to implement PassInfo related service
 *
 */
@Service
public class PassInfoService {

	@Autowired
	private PassInfoDaoImpl passInfoDao;

	/**
	 * Function to get passId from vehicle type and pass ype
	 * @param vehicleType
	 * @param passType
	 * @return passId
	 */
	public int getPassId(String vehicleType, String passType) {
		return passInfoDao.getPassId(passType, vehicleType);
	}

	/**
	 * FUnction to get passType from passId
	 * @param passId
	 * @return passType
	 */
	public String getPassType(int passId) {
		return passInfoDao.getPassType(passId);
	}

	/**
	 * Function to get passPrice from passId
	 * @param passId
	 * @return passPrice
	 */
	public double getPassPrice(int passId) {
		return passInfoDao.getPassPrice(passId);
	}
}