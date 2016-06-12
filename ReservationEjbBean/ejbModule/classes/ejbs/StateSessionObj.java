package classes.ejbs;

import javax.ejb.EJBObject;

import classes.pojos.Reservation;
import classes.pojos.Reservation.Customer;
import classes.pojos.Reservation.FareFamily;

public interface StateSessionObj extends EJBObject {
	public Reservation getReservation() throws java.rmi.RemoteException;
	public Customer getCustomer() throws java.rmi.RemoteException;
	public FareFamily getFareFamily() throws java.rmi.RemoteException;
}
