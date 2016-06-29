package classes.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;


import org.jdom.JDOMException;
import org.junit.Test;

import classes.ejbs.UserBean;

public class UserTests {
	    
	    @Test
	    public void testEjbGetUser() throws IOException, JDOMException {
	    	UserBean mokedEjb = mock(UserBean.class);
	    	mokedEjb.getUser("user", "user");	    	
	    	//Assert
	    	verify(mokedEjb).getUser("user", "user");
	    	
	    }
}
