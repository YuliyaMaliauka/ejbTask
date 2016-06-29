package tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.jdom.JDOMException;
import org.junit.Test;

import classes.dao.DaoXML;
import classes.dao.IDAO;
import classes.pojos.Reservation;
import classes.pojos.Reservation.Customer;
import classes.pojos.Reservation.FareFamily;

public class TestDAOxml {
	private static final Logger log = Logger.getLogger(TestDAOxml.class);


    @Test
    public void testReservation() throws IOException, JDOMException {
        IDAO xmlImpl = new DaoXML();
        Reservation reservation = xmlImpl.getReservation();
        log.info(reservation);

    }

    @Test
    public void testCustomer() throws IOException, JDOMException{
        IDAO xmlImpl = new DaoXML();
        Customer customer = xmlImpl.getCustomer();
        log.info(customer);
    }

    @Test
    public void testFareFamily() throws IOException, JDOMException{
        IDAO xmlImpl = new DaoXML();
        FareFamily fareFamily = xmlImpl.getFareFamily();
        log.info(fareFamily);
    }

}
