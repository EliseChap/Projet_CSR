package org.inria.restlet.mta.backend;

import java.util.Collection;

import org.inria.restlet.mta.database.api.impl.Restaurant;

public class Clients extends Thread{
	
	private static int affichageClient = 0; 
	private static int id = 0; 
	private static String etat = "WAITING_TO_ENTER"; 
	Restaurant restaurant;
	
	public Clients(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}

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
	

	public synchronized void standCuisson() {
		etat = "WAITING_THE_COOK"; 
		
		while(StandCuisson.getNombreClients()>1) {
			try {wait();} catch (InterruptedException e) {e.printStackTrace();} 
		}		
		restaurant.getStandCuisson().decrementerNombreClients();
	}
	
	public synchronized void buffetLegume() throws InterruptedException {
		
		int qte =	(int) (Math.random() * ( 100 - 0 )); 
		int duree =	(int) (Math.random() * ( 300 - 200 )); 
		while(EmployeBuffet.getBuffetLegumes().getsize()<qte) {			
				wait();
			}
				BuffetLegumes.accederBac(qte); 
				sleep(duree); 
	}
	
	public synchronized void buffetViande() throws InterruptedException  {
		
		int qte =	(int) (Math.random() * ( 100 - 0 )); 
		int duree =	(int) (Math.random() * ( 300 - 200 ));
		while(EmployeBuffet.getBuffetViande().getsize()<qte) {
				wait();
		}
		
		BuffetViande.accederBac(qte); 
		sleep(duree); 		
	}

	public synchronized void buffetNouilles() throws InterruptedException  {
	
		int qte =	(int) (Math.random() * ( 100 - 0 )); 
		int duree =	(int) (Math.random() * ( 300 - 200 )); 
	
		while(EmployeBuffet.getBuffetNouilles().getsize()<qte) {
				wait();
		}
	
		BuffetNouilles.accederBac(qte); 
		sleep(duree); 
}


	public synchronized void buffetPoisson() throws InterruptedException {

		int qte =	(int) (Math.random() * ( 100 - 0 )); 
		int duree =	(int) (Math.random() * ( 300 - 200 )); 
	
		while(EmployeBuffet.getBuffetPoisson().getsize()<qte) {
			wait();
		}
			BuffetPoisson.accederBac(qte); 
			sleep(duree); 
	}

	
	public static void manger() {
		etat = "EATING"; 

		try {sleep(100);	} catch (InterruptedException e) {e.printStackTrace();} 
	}
	
	public synchronized void sortir() {
		
		affichageClient++;
		System.out.println("Nombre de clients qui sortent du restaurant :" + affichageClient);
		restaurant.clientSort(); 			
		etat ="OUT"; 				
		}
	
	public long getId() {
		return id; 
	}
		
	public void setId(int i) {
		this.id =i; 		
	}


	public String getEtat() {
		return this.etat;
	}
		
}

