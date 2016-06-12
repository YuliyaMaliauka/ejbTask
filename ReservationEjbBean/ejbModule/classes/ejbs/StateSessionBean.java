package classes.ejbs;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.jdom.JDOMException;

import classes.dao.*;

import classes.pojos.Reservation;
import classes.pojos.Reservation.Customer;
import classes.pojos.Reservation.FareFamily;

public class StateSessionBean implements SessionBean {

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
	
	public Reservation getReservation() throws java.rmi.RemoteException{
		
        Reservation reservation = null;
		
			try {
				reservation = DAOFactory.getInstance().getReservation();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
        return reservation;
	}
	
	public Customer getCustomer() throws java.rmi.RemoteException{
		
		Customer castomer = null;
		try {
			castomer = DAOFactory.getInstance().getCustomer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return castomer;
	}
	
	public FareFamily getFareFamily() throws java.rmi.RemoteException{
		
		FareFamily fareFamily = null;
		try {
			fareFamily = DAOFactory.getInstance().getFareFamily();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return fareFamily;
	}

}
