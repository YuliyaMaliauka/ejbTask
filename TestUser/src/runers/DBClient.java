package runers;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import classes.ejbs.SessionUser;
import classes.ejbs.UserHome;

public class DBClient {

	public static void main(String[] args) {
		 		
				Properties properties = new Properties();
				properties.put(Context.INITIAL_CONTEXT_FACTORY,
						"org.jnp.interfaces.NamingContextFactory");
				properties.put(Context.PROVIDER_URL, "localhost:1099"); 
				try {
					// Get an initial context
					InitialContext jndiContext = new InitialContext(properties);
					System.out.println("Got context");

					// Get a reference to the Bean
					Object ref = jndiContext.lookup("User");
					System.out.println("Got reference");

					// Get a reference from this to the Bean's Home interface
					UserHome home = (UserHome) PortableRemoteObject.narrow(ref,	UserHome.class);

					// Create an Adder object from the Home interface
					SessionUser conUser = null;
					conUser = home.create();
					
					System.out.println("User: " + conUser.getUser("user", "user").getName());
				} catch (Exception e) {
					e.printStackTrace(); 
				}
	}
}
