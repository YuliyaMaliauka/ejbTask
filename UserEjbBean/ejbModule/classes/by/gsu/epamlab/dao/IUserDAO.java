package classes.by.gsu.epamlab.dao;

import classes.by.gsu.epamlab.beans.User;
import classes.by.gsu.epamlab.beans.UserData;
import classes.by.gsu.epamlab.exceptions.DaoException;

public interface IUserDAO {
	public User getUser(String name, String password) throws DaoException;
	boolean checkUsers(String name) ;
	boolean checkPass(String name, String pass) throws DaoException;
}
