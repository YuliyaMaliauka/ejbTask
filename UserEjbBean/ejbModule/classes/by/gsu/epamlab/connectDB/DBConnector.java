package classes.by.gsu.epamlab.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import classes.by.gsu.epamlab.constants.Constants;

public final class DBConnector {

	private DBConnector() {
	}

	public static synchronized Connection getConnection() throws SQLException {
		return DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME_DB, Constants.PASSWORD_DB);
	}

	public static void initDriver(String driverClass) {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(Constants.NOT_DRIVER_BD);
		}
	}

	public static void closeJdbcUtils(ResultSet... args) {
		for (ResultSet rs : args) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.err.println(Constants.PROBLEM_CLOSE_RESOURCE + e);
				}
			}
		}
	}

	public static void closeJdbcUtils(Statement... args) {
		for (Statement st : args) {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					System.err.println(Constants.PROBLEM_CLOSE_RESOURCE + e);
				}
			}
		}
	}

	public static void closeJdbcUtils(Connection cn) {
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				System.err.println(Constants.PROBLEM_CLOSE_RESOURCE + e);
			}
		}
	}
}
