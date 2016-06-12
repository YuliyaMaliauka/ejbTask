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



import classes.pojos.Reservation;

/**
 *
 * @author user
 */
public class ReservationTag extends SimpleTagSupport{
    private String typeReservation;

    public String getTypeReservation() {
        return typeReservation;
    }

    public void setTypeReservation(String typeReservation) {
        this.typeReservation = typeReservation;
    }
       
    @Override
    public void doTag() throws JspException, IOException {
        try {
        	IEJB ejb = EJBFactory.getInstance();
        	Reservation reservation = ejb.getReservEjb().getReservation();
            getJspContext().setAttribute(getTypeReservation(), reservation);
        } catch (Exception ex) {
            Logger.getLogger(ReservationTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
