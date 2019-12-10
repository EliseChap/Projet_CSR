package org.inria.restlet.mta.backend;

import org.inria.restlet.mta.database.api.impl.Restaurant;

/**
 * Cette classe s'occupe du cuisinier qui cuit les ingrédients crus des clients
 * 
 * @author Elise CHAPON
 * @author Maëlla GHERAIA
 */
public class Cuisinier extends Thread{

	Restaurant restaurant;

	public Cuisinier(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}

	/**
	 * Le cuisinier prend les clients un par un
	 */
	public void run() {
		while(true) {
			while(restaurant.getStandCuisson().getNombreClients()>=1) {
				try {cuisiner();} catch (InterruptedException e) {e.printStackTrace();} 
			}
		}
	}

	/**
	 * Le cuisinier cuit.
	 */
	public void cuisiner() throws InterruptedException {

		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
