package classes.by.gsu.epamlab.factories;

import classes.by.gsu.epamlab.dao.IUserDAO;
import classes.by.gsu.epamlab.exceptions.DaoException;
import classes.by.gsu.epamlab.impl.DBMySQLUserImpl;

public class UserFactory {
	private static IUserDAO instance = null;

	public static IUserDAO getInstanceClassFactory() throws DaoException {
		if(instance == null){
			instance = new DBMySQLUserImpl();
				}
		return instance; 		
		
	}

}
