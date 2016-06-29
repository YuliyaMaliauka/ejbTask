package tests;

import java.io.IOException;

import org.jdom.JDOMException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import classes.dao.DaoXML;
import classes.ejbs.StateSessionBean;
import classes.pojos.Reservation;
import classes.pojos.Reservation.Customer;
import classes.pojos.Reservation.FareFamily;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class TestEjbReservation {

	 @InjectMocks
	    private StateSessionBean stateSessionBean;
	    @Mock
	    private DaoXML daoXML;

	    @Before
	    public void setUp(){
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testReservation_Dao_getCode() throws IOException, JDOMException {
	    	 Reservation expReservation = mock(Reservation.class);
	         when(expReservation.getCode()).thenReturn("0004257753");
	         //Act
	         doReturn(expReservation).when(daoXML).getReservation();
	         Reservation actReservation = stateSessionBean.getReservation();	         
	         //Assert
	         assertThat(actReservation.getCode(), is(equalTo(expReservation.getCode())));
	    }
	    
	    @Test
	    public void testCustomer_Dao_getCustomerDocID() throws IOException, JDOMException{
	    	Customer expCustomer = new Customer();
	         //Act
	         doReturn(expCustomer).when(daoXML).getCustomer();
	         Customer actCustomer = stateSessionBean.getCustomer();
	         //Assert
	         assertThat(actCustomer.getCustomerDocID(), is(equalTo("RESV_RETRIEVE_Customer1850432")));
	    }
	    
	    @Test
	    public void testFareFamily_Dao_getFareFamilyCode() throws IOException, JDOMException{
	    	FareFamily expFareFamily = new FareFamily();
	         //Act
	         doReturn(expFareFamily).when(daoXML).getFareFamily();
	         FareFamily actFareFamily = stateSessionBean.getFareFamily();
	         //Assert
	         assertThat(actFareFamily.getFareFamilyCode(), is(equalTo("BASICPLUS")));
	    }
	    
	    @Test
	    public void testStateSessionBean_allMetods() throws IOException, JDOMException {
	    	StateSessionBean mokedBean = mock(StateSessionBean.class);
	    	mokedBean.getReservation();
	    	mokedBean.getCustomer();
	    	mokedBean.getFareFamily();
	    	//Assert
	    	verify(mokedBean).getReservation();
	    	verify(mokedBean).getCustomer();
	    	verify(mokedBean).getFareFamily();        
	    }
	
}
