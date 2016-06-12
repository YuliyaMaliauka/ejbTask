package com.myapp.tags;

public class EJBFactory {
	public static IEJB getInstance(){
        return new ReservationType();
    }
}
