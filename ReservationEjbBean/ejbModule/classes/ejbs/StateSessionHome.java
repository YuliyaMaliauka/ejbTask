package classes.ejbs;

import javax.ejb.EJBHome;

public interface StateSessionHome extends EJBHome {
	public StateSessionObj create()
			  throws javax.ejb.CreateException,
				java.rmi.RemoteException;

}
