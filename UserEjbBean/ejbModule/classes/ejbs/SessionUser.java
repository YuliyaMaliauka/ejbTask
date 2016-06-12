package classes.ejbs;

import javax.ejb.EJBObject;

import classes.by.gsu.epamlab.beans.User;

public interface SessionUser extends EJBObject {
	
	public User getUser(String name, String password) throws java.rmi.RemoteException;
}
