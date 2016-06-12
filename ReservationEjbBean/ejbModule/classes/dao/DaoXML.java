/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import classes.pojos.Reservation;
import classes.pojos.Reservation.Customer;
import classes.pojos.Reservation.FareFamily;
import classes.pojos.Reservation.Customer.Email;
import classes.pojos.Reservation.Customer.Payment;
import classes.pojos.Reservation.Customer.Phone;
import classes.pojos.Reservation.FareFamily.AncillaryAirComponent;

import org.jdom.Namespace;

/**
 *
 * @author user
 */
public class DaoXML implements IDAO {

    private final Namespace NAMESPACE = Namespace.getNamespace("urn:reservation.rqrs.datalex.com");
    private final String xmlFileName = "4257753.xml";
    private Element rootElement() throws IOException, JDOMException {

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(xmlFileName);
        Document document = builder.build(xmlFile);
        Element root = document.getRootElement();

        return root;
    }

    @Override
    public Reservation getReservation() throws IOException, JDOMException {
        Reservation reservation = new Reservation();
        
        Element root = rootElement();
        reservation.setCode(root.getAttributeValue("Code"));
        reservation.setDescription(root.getAttributeValue("Description"));
        List resElem = root.getChildren("ResComponent", NAMESPACE);
        Iterator resIterator = resElem.iterator();
        ArrayList<Reservation.ResComponent> resComponents = new ArrayList<Reservation.ResComponent>();
        while (resIterator.hasNext()) {
            Element resElement = (Element) resIterator.next();
            Reservation.ResComponent reservComponent = new Reservation.ResComponent();
            reservComponent.setComponentTypeCode(resElement.getAttributeValue("ComponentTypeCode"));
            reservComponent.setCreateDateTime(resElement.getAttributeValue("CreateDateTime"));
            reservComponent.setInternalStatus(resElement.getAttributeValue("InternalStatus"));
            reservComponent.setSequence(resElement.getAttributeValue("Sequence"));
            resComponents.add(reservComponent);
        }
        reservation.setResComponent(resComponents);

        return reservation;
    }

    @Override
    public Customer getCustomer() throws IOException, JDOMException {
    	
        Element root = rootElement();
        Customer customer = new Customer();

        Element cusElement = root.getChild("Customer", NAMESPACE);
        customer.setFirstName(cusElement.getAttributeValue("FirstName"));
        customer.setLastName(cusElement.getAttributeValue("LastName"));
        customer.setCustomerDocID(cusElement.getAttributeValue("CustomerDocID"));

        Email email = new Email();
        Element emailElement = cusElement.getChild("Email", NAMESPACE);
        email.setEmailAddress(emailElement.getAttributeValue("EmailAddress"));
        email.setEmailType(emailElement.getAttributeValue("EmailType"));
        email.setSyncStatus(emailElement.getAttributeValue("SyncStatus"));
        customer.setEmail(email);

        Phone phon = new Phone();
        Element phonElement = cusElement.getChild("Phone", NAMESPACE);
        phon.setPhoneNumber(phonElement.getAttributeValue("PhoneNumber"));
        phon.setPhoneType(phonElement.getAttributeValue("PhoneType"));
        phon.setSyncStatus(phonElement.getAttributeValue("SyncStatus"));
        customer.setPhone(phon);

        List paymentElements = cusElement.getChildren("Payment", NAMESPACE);
        Iterator payIterator = paymentElements.iterator();
        ArrayList<Payment> payments = new ArrayList<Payment>();
        while (payIterator.hasNext()) {
            Element payElement = (Element) payIterator.next();
            Reservation.Customer.Payment payment = new Customer.Payment();
            payment.setAmountPaid(payElement.getAttributeValue("AmountPaid"));
            payment.setFormOfPaymentTypeCode(payElement.getAttributeValue("FormOfPaymentTypeCode"));
            payment.setCurrencyCode(payElement.getAttributeValue("CurrencyCode"));
            payments.add(payment);
        }

        customer.setPayment(payments);

        return customer;
    }

    @Override
    public FareFamily getFareFamily() throws IOException, JDOMException {
    	
    	Element root = rootElement();
        FareFamily fareFamily = new FareFamily();

        Element fareFamElement = root.getChild("FareFamily", NAMESPACE);
        fareFamily.setFareFamilyCode(fareFamElement.getAttributeValue("FareFamilyCode"));
        
        List ancillaryAirComponentElements = fareFamElement.getChildren("AncillaryAirComponent", NAMESPACE);
        Iterator ancillaryAirComponentIterator = ancillaryAirComponentElements.iterator();
        ArrayList<AncillaryAirComponent> ancillaryAirComponents = new ArrayList<AncillaryAirComponent>();
        while (ancillaryAirComponentIterator.hasNext()) {
            Element ancillaryAirComponentElement = (Element) ancillaryAirComponentIterator.next();
            AncillaryAirComponent ancillaryAirComponent = new AncillaryAirComponent();
            ancillaryAirComponent.setAncillaryAirComponentCode(ancillaryAirComponentElement.getAttributeValue("AncillaryAirComponentCode"));
            ancillaryAirComponents.add(ancillaryAirComponent);
        }
        fareFamily.setAncillaryAirComponents(ancillaryAirComponents);

        return fareFamily;
    }
}
