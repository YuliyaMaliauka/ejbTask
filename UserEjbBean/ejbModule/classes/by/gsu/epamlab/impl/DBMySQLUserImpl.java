package classes.by.gsu.epamlab.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import classes.by.gsu.epamlab.beans.Role;
import classes.by.gsu.epamlab.beans.User;
import classes.by.gsu.epamlab.beans.UserData;
import classes.by.gsu.epamlab.connectDB.DBConnector;
import classes.by.gsu.epamlab.constants.Constants;
import classes.by.gsu.epamlab.dao.IUserDAO;
import classes.by.gsu.epamlab.exceptions.DaoException;

public class DBMySQLUserImpl implements IUserDAO {

	Map<String, UserData> users = new HashMap<>();

	@Override
	public User getUser(String name, String password) throws DaoException {
		Connection cn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			DBConnector.initDriver(Constants.CLASS_NAME);
			cn = DBConnector.getConnection();
			stmt = cn.createStatement();
			rs = stmt.executeQuery(Constants.SELECT_USERS);
			while (rs.next()) {
				users.put(rs.getString(1), new UserData(
						new User(rs.getString(1), Role.valueOf(rs.getString(3).toUpperCase())), rs.getString(2)));
			}
			if (!checkPass(name, password)) {
				throw new DaoException("No correct");
			} else
				return users.get(name).getUser();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeJdbcUtils(rs);
			DBConnector.closeJdbcUtils(stmt);
			DBConnector.closeJdbcUtils(cn);
		}
		throw new DaoException("is no user");
	}

	

	@Override
	public boolean checkUsers(String name) {
		for (String keyLogin : users.keySet()) {
			if (name.equals(keyLogin)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkPass(String name, String pass) throws DaoException {
		try {
			UserData ud = users.get(name);
			if (pass.equals(ud.getPassword())) {
				return true;
			}
		} catch (NullPointerException e) {
			throw new DaoException();
		}
		return false;

	}

}
