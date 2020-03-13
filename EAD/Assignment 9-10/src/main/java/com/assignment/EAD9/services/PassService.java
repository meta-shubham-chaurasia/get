package com.assignment.EAD9.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.EAD9.daoimpl.PassDaoImpl;
import com.assignment.EAD9.models.Pass;

/**
 * Class to implement Pass related service
 *
 */
@Service
public class PassService {

	@Autowired
	private PassDaoImpl passDao;

	/**
	 * Function to generate new pass
	 * @param pass
	 * @return id of new pass
	 */
	public int generatePass(Pass pass) {
		return passDao.addPass(pass);
	}
}