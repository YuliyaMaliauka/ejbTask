package classes.tests;

import org.junit.Assert;
import org.junit.Test;

import classes.by.gsu.epamlab.beans.User;
import classes.by.gsu.epamlab.exceptions.DaoException;
import classes.by.gsu.epamlab.factories.UserFactory;

public class testDaoUser {

	@Test
	public void testGetUser() throws Exception{
		User user = null;
		try {
			user = UserFactory.getInstanceClassFactory().getUser("user", "user");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNotNull(user);
		Assert.assertTrue(user.getName().endsWith("user"));
	}
	
	
	
}
