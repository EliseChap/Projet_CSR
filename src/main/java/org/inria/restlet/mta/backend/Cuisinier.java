package org.inria.restlet.mta.backend;

import org.inria.restlet.mta.database.api.impl.Restaurant;

public class Cuisinier extends Thread{

	Restaurant restaurant;
	
	public Cuisinier(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}
	
	public void run() {
		
		while(true) {
			Restaurant truc = restaurant;
			StandCuisson prout = truc.getStandCuisson();
			int nb = prout.getNombreClients();
			while(restaurant.getStandCuisson().getNombreClients()>=1) {
	
			try {
				cuisiner();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
			}
		}
				
	}
	
	public synchronized void cuisiner() throws InterruptedException {
		
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		notify(); 
	}
}
