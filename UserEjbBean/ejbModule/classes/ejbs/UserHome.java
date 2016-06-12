package classes.ejbs;

import javax.ejb.EJBHome;

public interface UserHome extends EJBHome {
	public SessionUser create()
			  throws javax.ejb.CreateException,
				java.rmi.RemoteException;
}
