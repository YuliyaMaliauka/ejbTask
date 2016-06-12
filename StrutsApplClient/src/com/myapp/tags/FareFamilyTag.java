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

import classes.pojos.Reservation.FareFamily;
/**
 *
 * @author user
 */
public class FareFamilyTag extends SimpleTagSupport{
    private String typeFamily;

    public String getTypeFamily() {
        return typeFamily;
    }

    public void setTypeFamily(String typeFamily) {
        this.typeFamily = typeFamily;
    }    
       
    @Override
    public void doTag() throws JspException, IOException {
        try {
        	IEJB ejb = EJBFactory.getInstance();
            FareFamily fareFamily = ejb.getReservEjb().getFareFamily();
            getJspContext().setAttribute(getTypeFamily(), fareFamily);
        } catch (Exception ex) {
            Logger.getLogger(ReservationTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
