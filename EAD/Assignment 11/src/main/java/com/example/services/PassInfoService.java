package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daoimpl.PassInfoDaoImpl;
import com.example.models.PassInfo;

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
	public PassInfo getPassInfo(String vehicleType, String passType) {
		return passInfoDao.getPassInfo(passType, vehicleType);
	}
}