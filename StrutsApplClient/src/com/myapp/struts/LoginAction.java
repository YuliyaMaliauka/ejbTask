/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.io.PrintWriter;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.*;

import classes.ejbs.SessionUser;
import classes.ejbs.UserHome;

/**
 *
 * @author user
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
    	
    	
    	
    	Properties properties = new Properties();
    	properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
    	properties.put(Context.PROVIDER_URL, "localhost:1099"); 

    	LoginForm formBean = (LoginForm) form;
    	String login = formBean.getLogin();
    	String password = formBean.getPassword();
    	formBean.setError();
    	ActionForward forward = mapping.getInputForward();
    			
    	try {

    		InitialContext jndiContext = new InitialContext(properties);
    		Object ref = jndiContext.lookup("User");
    		UserHome home = (UserHome) PortableRemoteObject.narrow(ref, UserHome.class);
    		SessionUser conUser = home.create();
    		
    		String name = conUser.getUser(login, password).getName();
    		
    		
    	    HttpSession session = request.getSession();   	    
    	    session.setAttribute("user", (conUser.getUser(login, password))); 
    	    request.setAttribute("login", name);
    	    forward = mapping.findForward(SUCCESS);
    	    
    		   	        
    	} catch (Exception e) {
    		/*ActionMessages error = new ActionMessages();
            error.add("userName", new ActionMessage("login.enter.error"));
            saveErrors(request, error);*/
    		forward = mapping.findForward(FAILURE);
    		
        	
    		
    	}
    	return forward;
    }
}
