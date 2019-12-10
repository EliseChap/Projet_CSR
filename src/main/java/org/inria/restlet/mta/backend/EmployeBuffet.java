package org.inria.restlet.mta.backend;

import org.inria.restlet.mta.database.api.impl.Restaurant;

/**
 * Cette classe s'occupe du processus employeBuffet
 * 
 * @author Elise CHAPON
 * @author Maëlla GHERAIA
 */
public class EmployeBuffet extends Thread{
 
	Restaurant restaurant;

	public EmployeBuffet(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}

	/**
	 * Cette méthode réapprovisionne les bacs du buffet
	 */
	public void run() {
		while(true) {
			restaurant.getLegumes().reapprovisionner();
			restaurant.getViandes().reapprovisionner();
			restaurant.getNouilles().reapprovisionner();
			restaurant.getPoissons().reapprovisionner();
		}
	}

}