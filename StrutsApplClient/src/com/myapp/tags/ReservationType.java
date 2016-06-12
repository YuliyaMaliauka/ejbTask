package com.myapp.tags;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;


import classes.ejbs.StateSessionHome;
import classes.ejbs.StateSessionObj;


public class ReservationType implements IEJB{
	public StateSessionObj getReservEjb(){
	Properties properties = new Properties();
	properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
	properties.put(Context.PROVIDER_URL, "localhost:1099"); 
	StateSessionObj conRes = null;
	try {

		InitialContext jndiContext = new InitialContext(properties);
		Object ref = jndiContext.lookup("Datalex");
		StateSessionHome home = (StateSessionHome) PortableRemoteObject.narrow(ref, StateSessionHome.class);
		conRes = home.create();
		
	} catch (Exception e) {
						
	}
	return conRes;
	}
}
