package org.inria.restlet.mta.backend;

import java.util.Collection;

import org.inria.restlet.mta.database.api.impl.Restaurant;


/**
 * Cette classe s'occupe des clients du buffet à leur sortie du restaurant.
 * 
 * @author Elise CHAPON
 * @author Maëlla GHERAIA
 */
public class Clients extends Thread{

	private static int affichageClient = 0; 
	private static int id = 0; 
	private static String etat = "WAITING_TO_ENTER"; 
	Restaurant restaurant;

	public Clients(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}


	/**
	 * Chemin du client: se sert au buffet, va cuire sa viande, mange et sort
	 * 
	 */
	public void run() {		
		etat = "AT_THE_BUFFET"; 

		try {buffetLegume();} catch (InterruptedException e1) {e1.printStackTrace();} 
		try {buffetViande();} catch (InterruptedException e1) {e1.printStackTrace();}
		try {buffetPoisson();} catch (InterruptedException e1) {e1.printStackTrace();}
		try {buffetNouilles();} catch (InterruptedException e1) {e1.printStackTrace();}

		restaurant.getStandCuisson().incrementerNombreClients();	

		standCuisson(); 
		manger(); 
		sortir(); 
	}


	/**
	 * Cuisson de la viande
	 */
	public synchronized void standCuisson() {
		etat = "WAITING_THE_COOK"; 

		while(StandCuisson.getNombreClients()>1) {
			try {wait();} catch (InterruptedException e) {e.printStackTrace();} 
		}		
		restaurant.getStandCuisson().decrementerNombreClients();
	}


	/**
	 * Le client se sert au buffet de légumes
	 * @throws InterruptedException
	 */
	public synchronized void buffetLegume() throws InterruptedException {

		int qte =	(int) (Math.random() * ( 100 - 0 )); 
		int duree =	(int) (Math.random() * ( 300 - 200 )); 
		while(EmployeBuffet.getBuffetLegumes().getsize()<qte) {			
			wait();
		}
		BuffetLegumes.accederBac(qte); 
		sleep(duree); 
	}


	/**
	 * Le client se sert au buffet de viande
	 * @throws InterruptedException
	 */
	public synchronized void buffetViande() throws InterruptedException  {

		int qte =	(int) (Math.random() * ( 100 - 0 )); 
		int duree =	(int) (Math.random() * ( 300 - 200 ));
		while(EmployeBuffet.getBuffetViande().getsize()<qte) {
			wait();
		}

		BuffetViande.accederBac(qte); 
		sleep(duree); 		
	}


	/**
	 * Le client se sert au buffet de nouilles
	 * @throws InterruptedException
	 */
	public synchronized void buffetNouilles() throws InterruptedException  {

		int qte =	(int) (Math.random() * ( 100 - 0 )); 
		int duree =	(int) (Math.random() * ( 300 - 200 )); 

		while(EmployeBuffet.getBuffetNouilles().getsize()<qte) {
			wait();
		}

		BuffetNouilles.accederBac(qte); 
		sleep(duree); 
	}


	/**
	 *Le client se sert au buffet de poisson
	 * @throws InterruptedException
	 */
	public synchronized void buffetPoisson() throws InterruptedException {

		int qte =	(int) (Math.random() * ( 100 - 0 )); 
		int duree =	(int) (Math.random() * ( 300 - 200 )); 

		while(EmployeBuffet.getBuffetPoisson().getsize()<qte) {
			wait();
		}
		BuffetPoisson.accederBac(qte); 
		sleep(duree); 
	}


	/**
	 * Le client mange
	 */
	public static void manger() {
		etat = "EATING"; 

		try {sleep(100);	} catch (InterruptedException e) {e.printStackTrace();} 
	}


	/**
	 * Le client sort
	 */
	public synchronized void sortir() {

		affichageClient++;
		System.out.println("Nombre de clients qui sortent du restaurant :" + affichageClient);
		restaurant.clientSort(); 			
		etat ="OUT"; 				
	}


	/**
	 * Cette méthode récupère l'Id du client
	 */
	public long getId() {
		return id; 
	}


	/**
	 * Cette méthode modifie l'id du client
	 * @param i
	 */
	public void setId(int i) {
		this.id =i; 		
	}


	/**
	 * Cette méthode récupère l'état du client.
	 * @return l'état du client
	 */
	public String getEtat() {
		return this.etat;
	}

}

