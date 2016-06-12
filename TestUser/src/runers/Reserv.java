package runers;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import classes.ejbs.StateSessionHome;
import classes.ejbs.StateSessionObj;

public class Reserv {

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
			Object ref = jndiContext.lookup("Datalex");
			System.out.println("Got reference");

			// Get a reference from this to the Bean's Home interface
			StateSessionHome home = (StateSessionHome) PortableRemoteObject.narrow(ref,	StateSessionHome.class);

			// Create an Adder object from the Home interface
			StateSessionObj conUser = null;
			conUser = home.create();
			System.out.println("Reservation 1: " + conUser.getReservation());
			System.out.println("Reservation 2: " + conUser.getReservation().getResComponent().get(0).getCreateDateTime());
			System.out.println("Reservation 3: " + conUser.getReservation().getCode());
			System.out.println("Reservation 4: " + conUser.getReservation().getDescription());
			System.out.println("Customer: " + conUser.getCustomer().getFirstName());
			System.out.println("FFamily: " + conUser.getFareFamily().getFareFamilyCode());
		} catch (Exception e) {
			e.printStackTrace(); 
		}


	}

}
