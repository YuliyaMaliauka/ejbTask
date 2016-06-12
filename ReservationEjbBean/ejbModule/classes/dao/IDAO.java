/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.dao;

import java.io.IOException;
import org.jdom.JDOMException;

import classes.pojos.Reservation;
import classes.pojos.Reservation.Customer;
import classes.pojos.Reservation.FareFamily;

/**
 *
 * @author user
 */
public interface IDAO {
    Reservation getReservation()throws IOException,JDOMException;
    Customer getCustomer()throws IOException,JDOMException;
    FareFamily getFareFamily()throws IOException,JDOMException;
}
