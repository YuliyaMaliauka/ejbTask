/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.tags;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.jdom.JDOMException;

import classes.pojos.Reservation.Customer;

/**
 *
 * @author user
 */
public class CustomerTag extends SimpleTagSupport{
    private String typeCustomer;

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    
       
    @Override
    public void doTag() throws JspException, IOException {
        try {
        	IEJB ejb = EJBFactory.getInstance();
            Customer castomer =  ejb.getReservEjb().getCustomer();
            getJspContext().setAttribute(getTypeCustomer(), castomer);
        } catch (Exception ex) {
            Logger.getLogger(ReservationTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
