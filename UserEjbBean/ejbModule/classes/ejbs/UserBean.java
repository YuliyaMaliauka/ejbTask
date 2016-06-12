package classes.ejbs;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


import classes.by.gsu.epamlab.beans.User;
import classes.by.gsu.epamlab.exceptions.DaoException;
import classes.by.gsu.epamlab.factories.UserFactory;

public class UserBean implements SessionBean {

	private static final long serialVersionUID = 1L;

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}
	public void ejbCreate() throws EJBException {
    }
	public User getUser(String name, String password) throws java.rmi.RemoteException{
		User user = null;
		try {
			user = UserFactory.getInstanceClassFactory().getUser(name, password);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;		
	}

}
