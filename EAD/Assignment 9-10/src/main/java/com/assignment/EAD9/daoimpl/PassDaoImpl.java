package com.assignment.EAD9.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.assignment.EAD9.dao.PassDao;
import com.assignment.EAD9.models.Pass;
import com.assignment.EAD9.utils.ConnectionUtility;

/**
 * Class to get Pass related data
 *
 */
@Repository
public class PassDaoImpl implements PassDao {

	/**
	 * Get pass from passId
	 * @param passId
	 * @return pass
	 */
	@Override
	public Pass getPass(int passId) {
		Pass pass = new Pass();
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectPass);
			st.setInt(1, passId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				pass.setPassId(passId);
				pass.setPassType(rs.getString("passType"));
				pass.setPassPrice(rs.getDouble("passPrice"));
				pass.setVehicleId(rs.getInt("vehicleId"));
			}
		} catch (SQLException e) {
			System.out.println("Pass could not be fetched...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return pass;
	}

	/**
	 * Function to update pass
	 * @param pass
	 * @return true if update or false otherwise
	 */
	@Override
	public boolean updatePass(Pass pass) {
		return true;
	}

	/**
	 * Function to add new pass
	 * @param pass
	 * @return id of the pass
	 */
	@Override
	public int addPass(Pass pass) {
		int passId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(insertPass);
			st.setInt(1, pass.getPassId());
			st.setString(2, pass.getPassType());
			st.setDouble(3, pass.getPassPrice());
			st.setInt(4, pass.getVehicleId());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected != 0) {
				st = connection.prepareStatement(lastRecord);
				ResultSet rs = st.executeQuery();
				rs.next();
				passId = rs.getInt("id");
			}
		} catch (SQLException e) {
			System.out.println("Pass Added");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		System.out.println(getPass(passId));
		return passId;
	}
}